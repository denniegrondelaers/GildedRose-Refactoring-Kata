package com.gildedrose.rules.item;

import com.gildedrose.Item;

public class BackstagePassesRule implements ItemRule {
    @Override
    public boolean matches(Item item) {
        return item.name.toUpperCase().startsWith("BACKSTAGE PASSES");
    }

    @Override
    public void apply(Item item) {
        if (item.quality < 50) {
            item.quality += 1;
        }
        if (item.quality < 50 && item.sellIn <= 10) {
            item.quality += 1;
        }
        if (item.quality < 50 && item.sellIn <= 5) {
            item.quality += 1;
        }

        item.sellIn -= 1;

        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }
}
