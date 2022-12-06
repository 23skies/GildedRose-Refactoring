package com.gildedrose

object ItemWrapperFactory {

    private val legendaryItems = listOf("Sulfuras, Hand of Ragnaros")
    private val agingItems = listOf("Aged Brie")
    private val incrementallyAgingItems = listOf("Backstage passes to a TAFKAL80ETC concert")

    fun getItemWrapper(item: Item) = when (item.name) {
        in agingItems -> ItemWrapper(item,
            UpdateStrategy(AgingQualityUpdateStrategy, AgingSellInUpdateStrategy)
        )

        in incrementallyAgingItems -> ItemWrapper(
            item,
            UpdateStrategy(IncrementallyAgingQualityUpdateStrategy, IncrementallyAgingSellInUpdateStrategy)
        )

        in legendaryItems -> ItemWrapper(
            item,
            UpdateStrategy(LegendaryQualityUpdateStrategy, LegendarySellInUpdateStrategy)
        )

        else -> ItemWrapper(item,
            UpdateStrategy(DefaultQualityUpdateStrategy, DefaultSellInUpdateStrategy)
        )
    }
}