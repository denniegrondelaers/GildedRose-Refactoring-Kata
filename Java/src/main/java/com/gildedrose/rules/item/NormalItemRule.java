package com.gildedrose.rules.item;

import com.gildedrose.Item;

public class NormalItemRule implements ItemRule {
    @Override
    public boolean matches(Item item) {
        return false;
    }

    @Override
    public void apply(Item item) {
        item.quality -= 1;
        item.sellIn -= 1;

        if (item.sellIn < 0) {
            item.quality -= 1;
        }

        if (item.quality < 0) {
            item.quality = 0;
        }
    }
}
