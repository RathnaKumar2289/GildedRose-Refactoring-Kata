package com.gildedrose.service.impl;

import static com.gildedrose.constants.GlidedRoseConstants.COMMON_DECREMENT;
import static com.gildedrose.constants.GlidedRoseConstants.DECREMENT_AFTER_SELLBY;

import com.gildedrose.constants.GlidedRoseConstants;
import com.gildedrose.dto.Item;
import com.gildedrose.service.QualityUpdater;

public class ConjuredItemUpdater implements QualityUpdater {

	@Override
	public Item updateQuality(Item item) {
		item.setSellIn(item.getSellIn() - 1);
		int decreaseBy = item.getSellIn() < 0?DECREMENT_AFTER_SELLBY*2:COMMON_DECREMENT*2;
		int updatedQuality = Math.max(item.getQuality() - decreaseBy, GlidedRoseConstants.MIN_QUALITY);
		item.setQuality(updatedQuality);
		return item;
	}

}
