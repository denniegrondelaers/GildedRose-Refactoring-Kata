package com.gildedrose.rule;

public interface IRule<E> {
    boolean matches(E item);
    void apply(E item);
}
