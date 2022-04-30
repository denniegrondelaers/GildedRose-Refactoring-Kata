package com.gildedrose.factory;

import com.gildedrose.Item;

public class ItemProcessingFactory {
    private final Item item;

    public ItemProcessingFactory(Item item) {
        this.item = item;
    }

    public ItemProcessingFactory decrementSellIn() {
        item.sellIn--;
        return this;
    }

    public ItemProcessingFactory decrementQuality() {
        item.quality--;
        return this;
    }

    public ItemProcessingFactory ifSellInIsLowerThanValueThenAlterQuality(int sellInLowerBoundary, int quantityTransformation) {
        if (item.sellIn < sellInLowerBoundary) {
            item.quality += quantityTransformation;
        }
        return this;
    }

    public ItemProcessingFactory ifSellInIsLowerThanZeroThenSetQualityToZero() {
        if (item.sellIn < 0) {
            item.quality = 0;
        }
        return this;
    }

    public ItemProcessingFactory ifQualityIsLessThanValueThenAlterQuality(int qualityUpperBoundary, int quantityTransformation) {
        if (item.quality < qualityUpperBoundary) {
            item.quality += quantityTransformation;
        }
        return this;
    }

    public ItemProcessingFactory ifQualityIsLessThanZeroThenSetQualityToZero() {
        if (item.quality < 0) {
            item.quality = 0;
        }
        return this;
    }

    public ItemProcessingFactory ifSellInIsLowerThanValueAndAndQualityLessThanFiftyThenIncrementQuality(int sellInLowerBoundary) {
        if (item.sellIn < sellInLowerBoundary && item.quality < 50) {
            item.quality++;
        }
        return this;
    }
}
