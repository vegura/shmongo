package me.vegura.resource;

import java.util.Set;

public interface SCVParser<T> {
    Set<T> parse(String filename);
}
