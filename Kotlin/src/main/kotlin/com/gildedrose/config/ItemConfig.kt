package com.gildedrose.config

import com.gildedrose.strategy.*

class ItemConfig {

    val itemMap: Map<String, UpdateStrategy> = mapOf(
        "Sulfuras, Hand of Ragnaros" to UpdateStrategy(
            NeverDecreaseQualityUpdateStrategy,
            NeverExpireSellInUpdateStrategy
        ),
        "Aged Brie" to UpdateStrategy(
            AgingQualityUpdateStrategy,
            DefaultSellInUpdateStrategy
        ),
        "Backstage passes to a TAFKAL80ETC concert" to UpdateStrategy(
            IncrementallyAgingQualityUpdateStrategy,
            DefaultSellInUpdateStrategy
        ),
    )

}