package com.gildedrose.strategy

object DefaultQualityUpdateStrategy: QualityUpdateStrategy {

    override fun updatedQuality(currentQuality: Int, sellInDays: Int): Int {
        if (sellInDays < 1)
            return (currentQuality - 2).coerceAtLeast(0)
        return (currentQuality - 1).coerceAtLeast(0)
    }

}



object LegendaryQualityUpdateStrategy: QualityUpdateStrategy {

    override fun updatedQuality(currentQuality: Int, sellInDays: Int) = currentQuality

}



object AgingQualityUpdateStrategy: QualityUpdateStrategy {

    override fun updatedQuality(currentQuality: Int, sellInDays: Int) =
        (currentQuality + 1).coerceAtMost(50)

}



object IncrementallyAgingQualityUpdateStrategy: QualityUpdateStrategy {

    override fun updatedQuality(currentQuality: Int, sellInDays: Int) = when {
        sellInDays > 10 -> currentQuality + 1
        sellInDays > 5 -> currentQuality + 2
        sellInDays > 0 -> currentQuality + 3
        else -> 0
    }

}