package me.vegura.repo;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import me.vegura.model.LondonIdx;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LondonIdxRepo implements PanacheMongoRepository<LondonIdx> {
}
