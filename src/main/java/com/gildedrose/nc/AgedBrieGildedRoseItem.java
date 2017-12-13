package com.gildedrose.nc;

public class AgedBrieGildedRoseItem extends GildedRoseItem{

	public AgedBrieGildedRoseItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}
	
	@Override
	public void adjustQuality(int adjustment) {
		this.appreciate(adjustment);
	}
	
	@Override
	public void pastSellbyAdjustment() {
		if(this.getSellIn() < 0) {
			this.appreciate(1);
		}
	}
}
