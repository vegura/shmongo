package me.vegura.model;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Data;
import lombok.experimental.Accessors;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.List;

@Data @Accessors(chain = true)
@MongoEntity(collection = "orders")
public class Order {
    @BsonId()
    private Integer id;

    @BsonProperty("route_points")
    private List<RoutePoint> routePoints;

    private String feedback;
}
