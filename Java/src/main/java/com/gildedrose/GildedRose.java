package com.gildedrose;

import java.util.Arrays;
import java.util.Objects;

import static com.gildedrose.constants.GlidedRoseConstants.LEGENDARY_ITEM;

import com.gildedrose.dto.Item;
import com.gildedrose.factory.QualityUpdaterFactory;

class GildedRose {
   private Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

	public void updateQuality() {
		Arrays.asList(items).stream()
		.filter(Objects::nonNull)
		.filter(item -> !LEGENDARY_ITEM.equalsIgnoreCase(item.getName()))
		.forEach(filteredItem -> QualityUpdaterFactory.getUpdater(filteredItem.getName())
				.updateQuality(filteredItem));
	}

}