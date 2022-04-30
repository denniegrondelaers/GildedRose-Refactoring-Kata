package com.gildedrose.rule.item;

import com.gildedrose.Item;
import com.gildedrose.factory.ItemProcessingFactory;

public class NormalItemRule implements ItemRule {
    @Override
    public boolean matches(Item item) {
        return false;
    }

    @Override
    public void apply(Item item) {
        new ItemProcessingFactory(item)
            .decrementQuality()
            .decrementSellIn()
            .ifSellInIsLowerThanValueThenAlterQuality(0, -1)
            .ifQualityIsLessThanZeroThenSetQualityToZero();
    }
}
