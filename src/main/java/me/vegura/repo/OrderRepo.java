package me.vegura.repo;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import me.vegura.model.LondonIdx;
import me.vegura.model.Order;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OrderRepo implements PanacheMongoRepository<Order> {

}
