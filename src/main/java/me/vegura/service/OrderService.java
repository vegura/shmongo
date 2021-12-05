package me.vegura.service;

import lombok.extern.slf4j.Slf4j;
import me.vegura.dto.OrderTwoPointsDto;
import me.vegura.model.LondonIdx;
import me.vegura.model.Order;
import me.vegura.model.RoutePoint;
import me.vegura.repo.LondonIdxRepo;
import me.vegura.repo.OrderRepo;
import org.bson.types.ObjectId;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

@Slf4j
@ApplicationScoped
public class OrderService {

    private static final String POSTCODE_ID = "_id";

    @Inject
    OrderRepo orderRepo;

    @Inject
    LondonIdxRepo londonIdxRepo;

    public void createRideForTwoPoints(OrderTwoPointsDto twoPointsDto) {

        final LondonIdx startPoint = londonIdxRepo.find(POSTCODE_ID, twoPointsDto.getFrom()).firstResult();
        final LondonIdx endPoint = londonIdxRepo.find(POSTCODE_ID, twoPointsDto.getTo()).firstResult();

        int orderId = generateOrderId();

        final Order order = new Order()
                .setId(orderId)
                .setRoutePoints(List.of(
                        new RoutePoint()
                                .setId(UUID.randomUUID().hashCode())
                                .setPostalCode(startPoint.getPostcode())
                                .setLatitude(startPoint.getLatitude())
                                .setLongitude(startPoint.getLongitude())
                                .setDescription("arrival point"),
                        new RoutePoint()
                                .setId(UUID.randomUUID().hashCode())
                                .setPostalCode(endPoint.getPostcode())
                                .setLatitude(endPoint.getLatitude())
                                .setLongitude(endPoint.getLongitude())
                                .setDescription("departure point")
                ));

        log.info("Order persisted -> {}", orderId);
        orderRepo.persistOrUpdate(order);
    }

    // Private

    private int generateOrderId() {
        return UUID.randomUUID().hashCode();
    }
}
