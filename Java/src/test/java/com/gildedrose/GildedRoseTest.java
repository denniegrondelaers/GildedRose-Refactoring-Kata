package com.gildedrose;

import com.gildedrose.rules.RuleEngine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
    public static final String DEXTERITY_VEST = "+5 Dexterity Vest";
    public static final String AGED_BRIE = "Aged Brie";
    public static final String ELIXIR_OF_THE_MONGOOSE = "Elixir of the Mongoose";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    // new Item("Conjured Mana Cake", 3, 6)

    private final RuleEngine engine = new RuleEngine();

    @Test
    void givenNormalItem_whenProcessing_thenUpdateSellInAndQualityCorrectly() {
        Item item1 = new Item(DEXTERITY_VEST, 10, 20);
        engine.process(item1);
        assertEqualsOverItemFields(item1, DEXTERITY_VEST, 9, 19);

        Item item2 = new Item(ELIXIR_OF_THE_MONGOOSE, 0, 20);
        engine.process(item2);
        assertEqualsOverItemFields(item2, ELIXIR_OF_THE_MONGOOSE, -1, 18);

        Item item3 = new Item(DEXTERITY_VEST, 10, 0);
        engine.process(item3);
            assertEqualsOverItemFields(item3, DEXTERITY_VEST, 9, 0);
    }

    @Test
    void givenAgedBrie_whenProcessing_thenUpdateSellInAndQualityCorrectly() {
        Item item1 = new Item(AGED_BRIE, 2, 0);
        engine.process(item1);
        assertEqualsOverItemFields(item1, AGED_BRIE, 1, 1);

        Item item2 = new Item(AGED_BRIE, -2, 0);
        engine.process(item2);
        assertEqualsOverItemFields(item2, AGED_BRIE, -3, 2);
    }

    @Test
    void givenSulfuras_whenProcessing_thenUpdateSellInAndQualityCorrectly() {
        Item item1 = new Item(SULFURAS, 0, 80);
        engine.process(item1);
        assertEqualsOverItemFields(item1, SULFURAS, 0, 80);

        Item item2 = new Item(SULFURAS, -1, 80);
        engine.process(item2);
        assertEqualsOverItemFields(item2, SULFURAS, -1, 80);
    }

    @Test
    void givenBackstagePasses_whenProcessing_thenUpdateSellInAndQualityCorrectly() {
        Item item1 = new Item(BACKSTAGE_PASSES, 15, 20);
        engine.process(item1);
        assertEqualsOverItemFields(item1, BACKSTAGE_PASSES, 14, 21);

        Item item2 = new Item(BACKSTAGE_PASSES, 10, 20);
        engine.process(item2);
        assertEqualsOverItemFields(item2, BACKSTAGE_PASSES, 9, 22);

        Item item3 = new Item(BACKSTAGE_PASSES, 5, 20);
        engine.process(item3);
        assertEqualsOverItemFields(item3, BACKSTAGE_PASSES, 4, 23);

        Item item4 = new Item(BACKSTAGE_PASSES, 0, 20);
        engine.process(item4);
        assertEqualsOverItemFields(item4, BACKSTAGE_PASSES, -1, 0);

        Item item5 = new Item(BACKSTAGE_PASSES, 15, 50);
        engine.process(item5);
        assertEqualsOverItemFields(item5, BACKSTAGE_PASSES, 14, 50);

        Item item6 = new Item(BACKSTAGE_PASSES, 10, 50);
        engine.process(item6);
        assertEqualsOverItemFields(item6, BACKSTAGE_PASSES, 9, 50);

        Item item7 = new Item(BACKSTAGE_PASSES, 5, 50);
        engine.process(item7);
        assertEqualsOverItemFields(item7, BACKSTAGE_PASSES, 4, 50);

        Item item8 = new Item(BACKSTAGE_PASSES, 0, 50);
        engine.process(item8);
        assertEqualsOverItemFields(item8, BACKSTAGE_PASSES, -1, 0);
    }

    private void assertEqualsOverItemFields(Item item, String name, int sellIn, int quality) {
        assertEquals(name, item.name);
        assertEquals(sellIn, item.sellIn);
        assertEquals(quality, item.quality);
    }
}
