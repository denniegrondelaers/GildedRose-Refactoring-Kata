package com.gildedrose.rules;

public interface IRule<E> {
    boolean matches(E item);
    void apply(E item);
}
