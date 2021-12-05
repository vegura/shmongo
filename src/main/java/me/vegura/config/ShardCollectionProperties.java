package me.vegura.config;

import lombok.Data;

@Data
public class ShardCollectionProperties {
    private String collection;
    private String shardingField;
}
