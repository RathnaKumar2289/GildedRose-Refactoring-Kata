package com.gildedrose.factory;

import static com.gildedrose.constants.GlidedRoseConstants.AGED_BRIE;
import static com.gildedrose.constants.GlidedRoseConstants.BACKSTAGE_PASSES;
import static com.gildedrose.constants.GlidedRoseConstants.CONJURED_ITEM;

import com.gildedrose.service.QualityUpdater;
import com.gildedrose.service.impl.AgedBrieUpdater;
import com.gildedrose.service.impl.BackstagePassesUpdater;
import com.gildedrose.service.impl.CommonItemUpdater;
import com.gildedrose.service.impl.ConjuredItemUpdater;

public class QualityUpdaterFactory {
	
	public static QualityUpdater getUpdater(String name) {
		if (AGED_BRIE.equalsIgnoreCase(name)) {
			return new AgedBrieUpdater();
		}else if (BACKSTAGE_PASSES.equalsIgnoreCase(name)) {
			return new BackstagePassesUpdater();
		}else if(CONJURED_ITEM.equalsIgnoreCase(name)) {
			return new ConjuredItemUpdater();
		}else {
			return new CommonItemUpdater();
		}
	}

}
