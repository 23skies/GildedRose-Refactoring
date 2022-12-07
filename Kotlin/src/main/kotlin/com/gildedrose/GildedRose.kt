package com.gildedrose

import com.gildedrose.factory.ItemWrapperFactory
import com.gildedrose.item.Item

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        items
            .map { ItemWrapperFactory.getItemWrapper(it) }
            .forEach { it.updateItem() }
    }

}