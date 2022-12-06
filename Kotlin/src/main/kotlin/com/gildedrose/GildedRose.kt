package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        items
            .map { ItemWrapperFactory.getItemWrapper(it) }
            .forEach { it.updateItem() }
    }

}