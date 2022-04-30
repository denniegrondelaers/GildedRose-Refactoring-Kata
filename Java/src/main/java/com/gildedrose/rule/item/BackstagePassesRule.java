package com.gildedrose.rule.item;

import com.gildedrose.Item;
import com.gildedrose.factory.ItemProcessingFactory;

public class BackstagePassesRule implements ItemRule {
    @Override
    public boolean matches(Item item) {
        return item.name.toUpperCase().startsWith("BACKSTAGE PASSES");
    }

    @Override
    public void apply(Item item) {
        new ItemProcessingFactory(item)
            .ifQualityIsLessThanValueThenAlterQuality(50, 1)
            .ifSellInIsLowerThanValueAndAndQualityLessThanFiftyThenIncrementQuality(11)
            .ifSellInIsLowerThanValueAndAndQualityLessThanFiftyThenIncrementQuality(6)
            .decrementSellInByOne()
            .ifSellInIsLowerThanZeroThenSetQualityToZero()
        ;
    }
}
