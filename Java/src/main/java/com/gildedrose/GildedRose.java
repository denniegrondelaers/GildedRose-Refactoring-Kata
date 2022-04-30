package com.gildedrose;

import com.gildedrose.rule.item.ItemRuleEngine;

class GildedRose {
    private final Item[] items;
    private final ItemRuleEngine itemRuleEngine = new ItemRuleEngine();

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            itemRuleEngine.process(item);
        }
    }
}
