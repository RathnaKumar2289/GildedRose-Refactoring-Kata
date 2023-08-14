package com.gildedrose.service.impl;

import static com.gildedrose.constants.GlidedRoseConstants.DEGRADE_VALUE_AFTER_SELLBY;
import static com.gildedrose.constants.GlidedRoseConstants.DEGRADE_VALUE;

import com.gildedrose.constants.GlidedRoseConstants;
import com.gildedrose.dto.Item;
import com.gildedrose.service.QualityUpdater;

public class ConjuredItemUpdater implements QualityUpdater {

	@Override
	public Item updateQuality(Item item) {
		item.setSellIn(item.getSellIn() - 1);
		int decreaseBy = item.getSellIn() < 0?DEGRADE_VALUE_AFTER_SELLBY*2:DEGRADE_VALUE*2;
		int updatedQuality = Math.max(item.getQuality() - decreaseBy, GlidedRoseConstants.MIN_QUALITY);
		item.setQuality(updatedQuality);
		return item;
	}

}
