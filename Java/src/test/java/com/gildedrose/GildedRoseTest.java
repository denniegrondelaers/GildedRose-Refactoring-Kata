package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
    public static final String DEXTERITY_VEST = "+5 Dexterity Vest";
    public static final String AGED_BRIE = "Aged Brie";
    public static final String ELIXIR_OF_THE_MONGOOSE = "Elixir of the Mongoose";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

    private GildedRose app;

    @BeforeEach
    void setUp() {
        Item[] items = new Item[]{
            new Item(DEXTERITY_VEST, 10, 20),
            new Item(AGED_BRIE, 2, 0),
            new Item(ELIXIR_OF_THE_MONGOOSE, 5, 7),
            new Item(SULFURAS, 0, 80),
            new Item(SULFURAS, -1, 80),
            new Item(BACKSTAGE_PASSES, 15, 20),
            new Item(BACKSTAGE_PASSES, 10, 49),
            new Item(BACKSTAGE_PASSES, 5, 49),
            // this conjured item does not work properly yet
            // new Item("Conjured Mana Cake", 3, 6)
        };

        app = new GildedRose(items);
    }

    @Test
    void givenListOfItems_whenProgressingOneDay_thenUpdatePropertiesCorrectly() {
        app.updateQuality();

        assertEqualsOverItemFields(app.items[0], DEXTERITY_VEST, 9, 19);
        assertEqualsOverItemFields(app.items[1], AGED_BRIE, 1, 1);
        assertEqualsOverItemFields(app.items[2], ELIXIR_OF_THE_MONGOOSE, 4, 6);
        assertEqualsOverItemFields(app.items[3], SULFURAS, 0, 80);
        assertEqualsOverItemFields(app.items[4], SULFURAS, -1, 80);
        assertEqualsOverItemFields(app.items[5], BACKSTAGE_PASSES, 14, 21);
        assertEqualsOverItemFields(app.items[6], BACKSTAGE_PASSES, 9, 50);
        assertEqualsOverItemFields(app.items[7], BACKSTAGE_PASSES, 4, 50);
    }

    @Test
    void givenListOfItems_whenProgressingTenDays_thenUpdatePropertiesCorrectly() {
        for (int i = 0; i < 10; i++) {
            app.updateQuality();
        }

        assertEqualsOverItemFields(app.items[0], DEXTERITY_VEST, 0, 10);
        assertEqualsOverItemFields(app.items[1], AGED_BRIE, -8, 18);
        assertEqualsOverItemFields(app.items[2], ELIXIR_OF_THE_MONGOOSE, -5, 0);
        assertEqualsOverItemFields(app.items[3], SULFURAS, 0, 80);
        assertEqualsOverItemFields(app.items[4], SULFURAS, -1, 80);
        assertEqualsOverItemFields(app.items[5], BACKSTAGE_PASSES, 5, 35);
        assertEqualsOverItemFields(app.items[6], BACKSTAGE_PASSES, 0, 50);
        assertEqualsOverItemFields(app.items[7], BACKSTAGE_PASSES, -5, 0);
    }


    @Test
    void givenListOfItems_whenProgressingTwentyDays_thenUpdatePropertiesCorrectly() {
        for (int i = 0; i < 20; i++) {
            app.updateQuality();
        }

        assertEqualsOverItemFields(app.items[0], DEXTERITY_VEST, -10, 0);
        assertEqualsOverItemFields(app.items[1], AGED_BRIE, -18, 38);
        assertEqualsOverItemFields(app.items[2], ELIXIR_OF_THE_MONGOOSE, -15, 0);
        assertEqualsOverItemFields(app.items[3], SULFURAS, 0, 80);
        assertEqualsOverItemFields(app.items[4], SULFURAS, -1, 80);
        assertEqualsOverItemFields(app.items[5], BACKSTAGE_PASSES, -5, 0);
        assertEqualsOverItemFields(app.items[6], BACKSTAGE_PASSES, -10, 0);
        assertEqualsOverItemFields(app.items[7], BACKSTAGE_PASSES, -15, 0);
    }

    private void assertEqualsOverItemFields(Item item, String name, int sellIn, int quality) {
        assertEquals(name, item.name);
        assertEquals(sellIn, item.sellIn);
        assertEquals(quality, item.quality);
    }
}
