package com.gildedrose.service.impl;

import com.gildedrose.constants.GlidedRoseConstants;
import com.gildedrose.dto.Item;
import com.gildedrose.service.QualityUpdater;

public class AgedBrieUpdater implements QualityUpdater{

	@Override
	public Item updateQuality(Item item) {
		
		item.setSellIn(item.getSellIn()-1);
		int increaseBy = item.getSellIn()<0?2:1;
		int updatedQuality = Math.min(item.getQuality()+increaseBy, GlidedRoseConstants.MAX_QUALITY);
		item.setQuality(updatedQuality);
		return item;
	}

}
