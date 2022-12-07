package com.gildedrose.strategy

class UpdateStrategy(
    val qualityUpdateStrategy: QualityUpdateStrategy,
    val  sellInUpdateStrategy: SellInUpdateStrategy,
)

sealed interface QualityUpdateStrategy {

    fun updatedQuality(currentQuality: Int, sellInDays: Int): Int

}

sealed interface SellInUpdateStrategy {

    fun updatedSellIn(sellInDays: Int): Int

}