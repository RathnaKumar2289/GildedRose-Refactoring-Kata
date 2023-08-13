package com.gildedrose.service.impl;

import com.gildedrose.constants.GlidedRoseConstants;
import com.gildedrose.dto.Item;
import com.gildedrose.service.QualityUpdater;

public class BackstagePassesUpdater implements QualityUpdater{

	@Override
	public Item updateQuality(Item item) {
		int increaseBy = getIncreaseBy(item);
		int updatedQuality = Math.min(item.getQuality()+increaseBy,  GlidedRoseConstants.MAX_QUALITY);
		item.setQuality(updatedQuality);
		item.setSellIn(item.getSellIn()-1);
		if (item.getSellIn() < 0) {
			item.setQuality(0);
		}
		return item;
	}

	private int getIncreaseBy(Item item) {
		int increaseBy = 0;
		if(item.getSellIn() < 6) {
			increaseBy = 3;
		}else if(item.getSellIn() < 11) {
			increaseBy = 2;
		}else {
			increaseBy = 1;
		}
		
		return increaseBy;
	}

}
