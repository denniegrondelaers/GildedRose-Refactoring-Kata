package com.gildedrose.rule.item;

import com.gildedrose.Item;
import com.gildedrose.factory.ItemProcessingFactory;

public class ConjuredItemRule implements ItemRule {
    @Override
    public boolean matches(Item item) {
        return item.name.toUpperCase().startsWith("CONJURED");
    }

    @Override
    public void apply(Item item) {
        new ItemProcessingFactory(item)
            .decrementQualityByValue(2)
            .decrementSellInByOne()
            .ifSellInIsLowerThanValueThenAlterQuality(0, -2)
            .ifQualityIsLessThanZeroThenSetQualityToZero();
    }
}
