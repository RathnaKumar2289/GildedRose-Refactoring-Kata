package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.gildedrose.dto.Item;

import static com.gildedrose.constants.GlidedRoseConstants.*;

class GildedRoseTest {
	private static final String ELIXIR = "Elixir";
	
	@Test
	void testSulfuras() {
		Item[] items = new Item[] { new Item(LEGENDARY_ITEM, -1, 80) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		
		assertEquals(LEGENDARY_ITEM, items[0].getName());
		assertEquals(-1, items[0].getSellIn());
		assertEquals(80, items[0].getQuality());
	}
	
	@Test
	void testCommonItemBeforeSellByDate() {
		Item[] items = new Item[] { new Item(ELIXIR, 1, 40) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		
		assertEquals(ELIXIR, items[0].getName());
		assertEquals(0, items[0].getSellIn());
		assertEquals(39, items[0].getQuality());
	}
	
	@Test
	void testCommonItemAfterSellBy() {
		Item[] items = new Item[] { new Item(ELIXIR, 0, 40) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		
		assertEquals(ELIXIR, items[0].getName());
		assertEquals(-1, items[0].getSellIn());
		assertEquals(38, items[0].getQuality());
	}
	
	@Test
	void testCommonItemWithMinQuantityAfterSellBy() {
		Item[] items = new Item[] { new Item(ELIXIR, 0, MIN_QUALITY) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		
		assertEquals(ELIXIR, items[0].getName());
		assertEquals(-1, items[0].getSellIn());
		assertEquals(MIN_QUALITY, items[0].getQuality());
	}

	@Test
	void testAgeBrieBeforeSellBy() {
		Item[] items = new Item[] { new Item(AGED_BRIE, 2, 2) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		
		assertEquals(AGED_BRIE, items[0].getName());
		assertEquals(1, items[0].getSellIn());
		assertEquals(3, items[0].getQuality());
	}	

	@Test
	void testAgeBrieAfterSellBy() {
		Item[] items = new Item[] { new Item(AGED_BRIE, 0, 2) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		
		assertEquals(AGED_BRIE, items[0].getName());
		assertEquals(-1, items[0].getSellIn());
		assertEquals(4, items[0].getQuality());
	}

	@Test
	void testAgeBrieWithMaxQualityAfterSellBy() {
		Item[] items = new Item[] { new Item(AGED_BRIE, 0, 49) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		
		assertEquals(AGED_BRIE, items[0].getName());
		assertEquals(-1, items[0].getSellIn());
		assertEquals(MAX_QUALITY, items[0].getQuality());
	}
	
	@Test
	void testBackstagePassesSellByMoreThanTenDays() {
		Item[] items = new Item[] { new Item(BACKSTAGE_PASSES, 11, 2) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		
		assertEquals(BACKSTAGE_PASSES, items[0].getName());
		assertEquals(10, items[0].getSellIn());
		assertEquals(3, items[0].getQuality());
	}	
	
	@Test
	void testBackstagePassesSellByTenDays() {
		Item[] items = new Item[] { new Item(BACKSTAGE_PASSES, 10, 2) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		
		assertEquals(BACKSTAGE_PASSES, items[0].getName());
		assertEquals(9, items[0].getSellIn());
		assertEquals(4, items[0].getQuality());
	}
	
	@Test
	void testBackstagePassesSellByLessThanTenDays_GreaterThanFive() {
		Item[] items = new Item[] { new Item(BACKSTAGE_PASSES, 6, 2) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		
		assertEquals(BACKSTAGE_PASSES, items[0].getName());
		assertEquals(5, items[0].getSellIn());
		assertEquals(4, items[0].getQuality());
	}
	
	@Test
	void testBackstagePassesSellByFiveDays() {
		Item[] items = new Item[] { new Item(BACKSTAGE_PASSES, 5, 2) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		
		assertEquals(BACKSTAGE_PASSES, items[0].getName());
		assertEquals(4, items[0].getSellIn());
		assertEquals(5, items[0].getQuality());
	}
	
	@Test
	void testBackstagePassesSellByLessThanFiveDays() {
		Item[] items = new Item[] { new Item(BACKSTAGE_PASSES, 4, 2) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		
		assertEquals(BACKSTAGE_PASSES, items[0].getName());
		assertEquals(3, items[0].getSellIn());
		assertEquals(5, items[0].getQuality());
	}
	
	@Test
	void testBackstagePassesAfterSellBy() {
		Item[] items = new Item[] { new Item(BACKSTAGE_PASSES, 0, 10) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		
		assertEquals(BACKSTAGE_PASSES, items[0].getName());
		assertEquals(-1, items[0].getSellIn());
		assertEquals(0, items[0].getQuality());
	}
	
	@Test
	void testConjuredItemBeforeSellByDate() {
		Item[] items = new Item[] { new Item(CONJURED_ITEM, 1, 40) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		
		assertEquals(CONJURED_ITEM, items[0].getName());
		assertEquals(0, items[0].getSellIn());
		assertEquals(38, items[0].getQuality());
	}
	
	@Test
	void testConjuredItemAfterSellBy() {
		Item[] items = new Item[] { new Item(CONJURED_ITEM, 0, 40) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		
		assertEquals(CONJURED_ITEM, items[0].getName());
		assertEquals(-1, items[0].getSellIn());
		assertEquals(36, items[0].getQuality());
	}
	
	@Test
	void testConjuredItemWithMinQuantityAfterSellBy() {
		Item[] items = new Item[] { new Item(CONJURED_ITEM, 0, 2) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		
		assertEquals(CONJURED_ITEM, items[0].getName());
		assertEquals(-1, items[0].getSellIn());
		assertEquals(MIN_QUALITY, items[0].getQuality());
	}
}
