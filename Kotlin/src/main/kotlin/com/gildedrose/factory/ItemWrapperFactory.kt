package com.gildedrose.factory

import com.gildedrose.item.Item
import com.gildedrose.item.ItemWrapper
import com.gildedrose.strategy.*

object ItemWrapperFactory {

    private val legendaryItems = listOf("Sulfuras, Hand of Ragnaros")
    private val agingItems = listOf("Aged Brie")
    private val incrementallyAgingItems = listOf("Backstage passes to a TAFKAL80ETC concert")

    fun getItemWrapper(item: Item) = when (item.name) {
        in agingItems -> ItemWrapper(item,
            UpdateStrategy(AgingQualityUpdateStrategy, DefaultSellInUpdateStrategy)
        )

        in incrementallyAgingItems -> ItemWrapper(
            item,
            UpdateStrategy(IncrementallyAgingQualityUpdateStrategy, DefaultSellInUpdateStrategy)
        )

        in legendaryItems -> ItemWrapper(
            item,
            UpdateStrategy(LegendaryQualityUpdateStrategy, NeverExpireSellInUpdateStrategy)
        )

        else -> ItemWrapper(
            item,
            UpdateStrategy(DefaultQualityUpdateStrategy, DefaultSellInUpdateStrategy)
        )
    }
}