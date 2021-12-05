package me.vegura.model;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Data;
import lombok.experimental.Accessors;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.math.BigDecimal;

@MongoEntity(collection = "london_postcodes")
@Data
@Accessors(chain = true)
public class LondonIdx {
    @BsonId
    private String postcode;
    private BigDecimal latitude;
    private BigDecimal longitude;

    @BsonProperty("district_name")
    private String districtName;
}
