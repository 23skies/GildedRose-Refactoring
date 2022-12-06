package com.gildedrose

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

object DefaultQualityUpdateStrategy: QualityUpdateStrategy {

    override fun updatedQuality(currentQuality: Int, sellInDays: Int): Int {
        if (sellInDays < 1)
            return (currentQuality - 2).coerceAtLeast(0)
        return (currentQuality - 1).coerceAtLeast(0)
    }

}

object DefaultSellInUpdateStrategy: SellInUpdateStrategy {

    override fun updatedSellIn(sellInDays: Int): Int {
        return sellInDays - 1
    }

}

object LegendaryQualityUpdateStrategy: QualityUpdateStrategy {

    override fun updatedQuality(currentQuality: Int, sellInDays: Int) = currentQuality

}

object LegendarySellInUpdateStrategy: SellInUpdateStrategy {

    override fun updatedSellIn(sellInDays: Int): Int {
        return (sellInDays - 1).coerceAtLeast(1)
    }

}

object AgingQualityUpdateStrategy: QualityUpdateStrategy {

    override fun updatedQuality(currentQuality: Int, sellInDays: Int) =
        (currentQuality + 1).coerceAtMost(50)

}

object AgingSellInUpdateStrategy: SellInUpdateStrategy {

    override fun updatedSellIn(sellInDays: Int): Int {
        return sellInDays - 1
    }

}

object IncrementallyAgingQualityUpdateStrategy: QualityUpdateStrategy {

    override fun updatedQuality(currentQuality: Int, sellInDays: Int) = when {
        sellInDays > 10 -> currentQuality + 1
        sellInDays > 5 -> currentQuality + 2
        sellInDays > 0 -> currentQuality + 3
        else -> 0
    }

}

object IncrementallyAgingSellInUpdateStrategy: SellInUpdateStrategy {

    override fun updatedSellIn(sellInDays: Int): Int {
        return sellInDays - 1
    }

}