package com.gildedrose.rules.item;

import com.gildedrose.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemRuleEngine {

    private static final List<ItemRule> itemRules = new ArrayList<>();

    static {
        itemRules.add(new AgedBrieRule());
        itemRules.add(new SulfurasRule());
        itemRules.add(new BackstagePassesRule());
    }

    public void process(Item item) {
        ItemRule selectedRule = itemRules.stream()
            .filter(rule -> rule.matches(item))
            .findAny()
            .orElse(new NormalItemRule());

        selectedRule.apply(item);
    }
}
