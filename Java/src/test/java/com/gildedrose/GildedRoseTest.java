package com.gildedrose;

import com.gildedrose.rule.item.ItemRuleEngine;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
    public static final String DEXTERITY_VEST = "+5 Dexterity Vest";
    public static final String AGED_BRIE = "Aged Brie";
    public static final String ELIXIR_OF_THE_MONGOOSE = "Elixir of the Mongoose";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    // new Item("Conjured Mana Cake", 3, 6)

    private final ItemRuleEngine engine = new ItemRuleEngine();

    @ParameterizedTest
    @CsvSource({
        "10, 20, 9, 19",
        "0, 20, -1, 18",
        "10, 0, 9, 0"})
    void givenNormalItem_whenProcessing_thenUpdateSellInAndQualityCorrectly(int preSellIn, int preQuality,
                                                                            int postSellIn, int postQuality) {
        testItem(DEXTERITY_VEST, preSellIn, preQuality, postSellIn, postQuality);
        testItem(ELIXIR_OF_THE_MONGOOSE, preSellIn, preQuality, postSellIn, postQuality);
    }

    @ParameterizedTest
    @CsvSource({
        "2, 0, 1, 1",
        "-2, 0, -3, 2"})
    void givenAgedBrie_whenProcessing_thenUpdateSellInAndQualityCorrectly(int preSellIn, int preQuality,
                                                                          int postSellIn, int postQuality) {
        testItem(AGED_BRIE, preSellIn, preQuality, postSellIn, postQuality);
    }

    @ParameterizedTest
    @CsvSource({
        "0, 80, 0, 80",
        "-1, 80, -1, 80"})
    void givenSulfuras_whenProcessing_thenUpdateSellInAndQualityCorrectly(int preSellIn, int preQuality,
                                                                          int postSellIn, int postQuality) {
        testItem(SULFURAS, preSellIn, preQuality, postSellIn, postQuality);
    }

    @ParameterizedTest
    @CsvSource({
        "15, 20, 14, 21",
        "10, 20, 9, 22",
        "5, 20, 4, 23",
        "0, 20, -1, 0",
        "15, 50, 14, 50",
        "10, 50, 9, 50",
        "5, 50, 4, 50",
        "0, 50, -1, 0"})
    void givenBackstagePasses_whenProcessing_thenUpdateSellInAndQualityCorrectly(int preSellIn, int preQuality,
                                                                                 int postSellIn, int postQuality) {
        testItem(BACKSTAGE_PASSES, preSellIn, preQuality, postSellIn, postQuality);
    }

    private void testItem(String itemName, int preSellIn, int preQuality, int postSellIn, int postQuality) {
        Item item = new Item(itemName, preSellIn, preQuality);
        engine.process(item);

        assertEquals(itemName, item.name);
        assertEquals(postSellIn, item.sellIn);
        assertEquals(postQuality, item.quality);
    }
}
