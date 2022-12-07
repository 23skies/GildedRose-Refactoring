package com.gildedrose.factory

import com.gildedrose.item.Item
import com.gildedrose.item.ItemWrapper

object ItemWrapperFactory {

    fun getItemWrapper(item: Item) = ItemWrapper(item, UpdateStrategyFactory.getStrategy(item))

}