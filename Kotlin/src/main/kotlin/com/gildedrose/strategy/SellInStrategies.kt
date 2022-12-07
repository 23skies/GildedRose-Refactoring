package com.gildedrose.strategy


object DefaultSellInUpdateStrategy: SellInUpdateStrategy {

    override fun updatedSellIn(sellInDays: Int): Int {
        return sellInDays - 1
    }

}

object NeverExpireSellInUpdateStrategy: SellInUpdateStrategy {

    override fun updatedSellIn(sellInDays: Int): Int {
        return (sellInDays - 1).coerceAtLeast(1)
    }

}