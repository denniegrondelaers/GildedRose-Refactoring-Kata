package com.gildedrose;

import com.gildedrose.rules.RuleEngine;

class GildedRose {
    public final Item[] items;
    private final RuleEngine ruleEngine = new RuleEngine();

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            ruleEngine.process(item);
        }
    }
}
