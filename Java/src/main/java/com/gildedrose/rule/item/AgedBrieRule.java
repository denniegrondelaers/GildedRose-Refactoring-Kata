package com.gildedrose.rule.item;

import com.gildedrose.Item;
import com.gildedrose.factory.ItemProcessingFactory;

public class AgedBrieRule implements ItemRule {
    @Override
    public boolean matches(Item item) {
        return item.name.toUpperCase().startsWith("AGED BRIE");
    }

    @Override
    public void apply(Item item) {
        new ItemProcessingFactory(item)
            .ifQualityIsLessThanValueThenAlterQuality(50, 1)
            .decrementSellInByOne()
            .ifSellInIsLowerThanValueAndAndQualityLessThanFiftyThenIncrementQuality(0);
    }
}
