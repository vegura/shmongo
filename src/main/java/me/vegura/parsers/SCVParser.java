package me.vegura.parsers;

import java.util.Set;

public interface SCVParser<T> {
    Set<T> parse(String filename);
}
