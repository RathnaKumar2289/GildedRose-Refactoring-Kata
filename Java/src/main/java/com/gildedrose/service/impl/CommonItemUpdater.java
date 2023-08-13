package com.gildedrose.service.impl;


import static com.gildedrose.constants.GlidedRoseConstants.MIN_QUALITY;
import static com.gildedrose.constants.GlidedRoseConstants.COMMON_DECREMENT;
import static com.gildedrose.constants.GlidedRoseConstants.DECREMENT_AFTER_SELLBY;
import com.gildedrose.dto.Item;
import com.gildedrose.service.QualityUpdater;

public class CommonItemUpdater implements QualityUpdater {

	@Override
	public Item updateQuality(Item item) {
		item.setSellIn(item.getSellIn()-1);
		int decreaseBy = item.getSellIn() < 0?DECREMENT_AFTER_SELLBY:COMMON_DECREMENT;
		int updatedQuality = Math.max(item.getQuality()-decreaseBy, MIN_QUALITY);
		item.setQuality(updatedQuality);
		return item;
	}

}
