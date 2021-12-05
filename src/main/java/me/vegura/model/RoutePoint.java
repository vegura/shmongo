package me.vegura.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Data;
import lombok.experimental.Accessors;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.math.BigDecimal;

@Data @Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RoutePoint {
    private Integer id;

    @BsonProperty("postal_code")
    private String postalCode;

    @BsonProperty("x")
    private BigDecimal latitude;

    @BsonProperty("y")
    private BigDecimal longitude;
    private String description;
}
