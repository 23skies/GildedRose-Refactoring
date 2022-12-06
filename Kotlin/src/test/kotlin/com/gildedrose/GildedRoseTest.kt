package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun `simple item decreases SellIn`() {
        // Given
        val items = arrayOf(Item("item1", 11, 20))
        val app = GildedRose(items)

        // When
        app.updateQuality()

        // Then
        assertEquals("item1", app.items[0].name)
        assertEquals(10, app.items[0].sellIn)
    }

    @Test
    fun `simple item decreases quality`() {
        // Given
        val items = arrayOf(Item("item1", 11, 20))
        val app = GildedRose(items)

        // When
        app.updateQuality()

        // Then
        assertEquals("item1", app.items[0].name)
        assertEquals(19, app.items[0].quality)
    }

    @Test
    fun `simple item decreases quality twice as fast once sellIn has passed`() {
        // Given
        val items = arrayOf(Item("item1", 0, 20))
        val app = GildedRose(items)

        // When
        app.updateQuality()

        // Then
        assertEquals("item1", app.items[0].name)
        assertEquals(18, app.items[0].quality)
    }

    @Test
    fun `simple item with 0 quality stays at 0`() {
        // Given
        val items = arrayOf(Item("item1", 3, 0))
        val app = GildedRose(items)

        // When
        app.updateQuality()

        // Then
        assertEquals("item1", app.items[0].name)
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun `incremental item increases in quality`() {
        // Given
        val items = arrayOf(Item("Aged Brie", 3, 30))
        val app = GildedRose(items)

        // When
        app.updateQuality()

        // Then
        assertEquals("Aged Brie", app.items[0].name)
        assertEquals(31, app.items[0].quality)
    }

    @Test
    fun `aging item doesn't pass 50 quality`() {
        // Given
        val items = arrayOf(Item("Aged Brie", 3, 50))
        val app = GildedRose(items)

        // When
        app.updateQuality()

        // Then
        assertEquals("Aged Brie", app.items[0].name)
        assertEquals(50, app.items[0].quality)
    }

    @Test
    fun `legendary item doesn't have to be sold`() {
        // Given
        val items = arrayOf(Item("Sulfuras, Hand of Ragnaros", 1, 20))
        val app = GildedRose(items)

        // When
        app.updateQuality()

        // Then
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name)
        assertEquals(1, app.items[0].sellIn)
    }

    @Test
    fun `legendary item doesn't decrease in quality`() {
        // Given
        val items = arrayOf(Item("Sulfuras, Hand of Ragnaros", 1, 20))
        val app = GildedRose(items)

        // When
        app.updateQuality()

        // Then
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name)
        assertEquals(20, app.items[0].quality)
    }

    @Test
    fun `legendary item can have a quality of 80 at most`() {
        // Given
        val items = arrayOf(Item("Sulfuras, Hand of Ragnaros", 1, 80))
        val app = GildedRose(items)

        // When
        app.updateQuality()

        // Then
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name)
        assertEquals(80, app.items[0].quality)
    }

    @Test
    fun `incrementallyAging item increases in quality + 1 when SellIn is greater than 10`() {
        // Given
        val items = arrayOf(Item("Backstage passes to a TAFKAL80ETC concert", 20, 30))
        val app = GildedRose(items)

        // When
        app.updateQuality()

        // Then
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name)
        assertEquals(31, app.items[0].quality)
    }

    @Test
    fun `incrementallyAging item increases in quality + 2 when SellIn is less than 11 and greater than 5`() {
        // Given
        val items = arrayOf(Item("Backstage passes to a TAFKAL80ETC concert", 10, 30))
        val app = GildedRose(items)

        // When
        app.updateQuality()

        // Then
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name)
        assertEquals(32, app.items[0].quality)
    }

    @Test
    fun `incrementallyAging item increases in quality + 3 when SellIn is less than 6`() {
        // Given
        val items = arrayOf(Item("Backstage passes to a TAFKAL80ETC concert", 5, 30))
        val app = GildedRose(items)

        // When
        app.updateQuality()

        // Then
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name)
        assertEquals(33, app.items[0].quality)
    }

    @Test
    fun `incrementallyAging item drops quality to 0 on expiry`() {
        // Given
        val items = arrayOf(Item("Backstage passes to a TAFKAL80ETC concert", 0, 30))
        val app = GildedRose(items)

        // When
        app.updateQuality()

        // Then
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name)
        assertEquals(0, app.items[0].quality)
    }

}