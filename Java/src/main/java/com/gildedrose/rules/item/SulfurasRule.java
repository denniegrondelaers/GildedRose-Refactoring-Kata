package com.gildedrose.rules.item;

import com.gildedrose.Item;

public class SulfurasRule implements ItemRule {
    @Override
    public boolean matches(Item item) {
        return item.name.toUpperCase().startsWith("SULFURAS");
    }

    @Override
    public void apply(Item item) {
        //nothing
    }
}
