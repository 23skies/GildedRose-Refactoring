package com.gildedrose

class ItemWrapper(
    private val item: Item,
    private val strategy: UpdateStrategy,
) {

    fun updateItem() {
        item.quality = strategy.qualityUpdateStrategy.updatedQuality(item.quality, item.sellIn)
        item.sellIn = strategy.sellInUpdateStrategy.updatedSellIn(item.sellIn)
    }

}