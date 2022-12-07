package com.gildedrose.factory

import com.gildedrose.config.ItemConfig
import com.gildedrose.item.Item
import com.gildedrose.strategy.DefaultQualityUpdateStrategy
import com.gildedrose.strategy.DefaultSellInUpdateStrategy
import com.gildedrose.strategy.UpdateStrategy

object UpdateStrategyFactory {

    fun getStrategy(item: Item): UpdateStrategy =
        ItemConfig().itemMap[item.name] ?: UpdateStrategy(DefaultQualityUpdateStrategy, DefaultSellInUpdateStrategy)

}