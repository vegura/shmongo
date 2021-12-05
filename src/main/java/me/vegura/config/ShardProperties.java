package me.vegura.config;

import lombok.Data;
import org.eclipse.microprofile.config.inject.ConfigProperties;

import java.util.List;

@Data
@ConfigProperties(prefix = "taxi.shard")
public class ShardProperties {
    private String uri;
    private String database;
    private List<ShardCollectionProperties> shardCollections;
}
