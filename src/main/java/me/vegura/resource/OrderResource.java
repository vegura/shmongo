package me.vegura.resource;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import me.vegura.dto.OrderTwoPointsDto;
import me.vegura.service.OrderService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Slf4j
@Path("/order")
public class OrderResource {

    @Inject
    OrderService orderService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void createOrder(OrderTwoPointsDto rideRequest) {
        log.info("Ride request -> {}", rideRequest);
        orderService.createRideForTwoPoints(rideRequest);
    }

}
