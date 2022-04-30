package com.gildedrose.rules;

import com.gildedrose.Item;

public class AgedBrieRule implements ItemRule {
    @Override
    public boolean matches(Item item) {
        return item.name.toUpperCase().startsWith("AGED BRIE");
    }

    @Override
    public void apply(Item item) {
        if (item.quality < 50) {
            item.quality += 1;
        }

        item.sellIn -= 1;

        if (item.sellIn < 0 && item.quality < 50) {
            item.quality += 1;
        }
    }
}
