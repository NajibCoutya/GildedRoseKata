package com.gildedrose.nc;

public class BackstageGildedRoseItem extends GildedRoseItem{
	
	public BackstageGildedRoseItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	@Override
	public void appreciate(int appreciation) {		
		super.appreciate(appreciation);
		
        if (this.getSellIn() < 11) {
        	super.appreciate(appreciation);
        }

        if (this.getSellIn() < 6) {
        	super.appreciate(appreciation);
        }
	}
	
	@Override
	public void adjustQuality(int adjustment) {
		this.appreciate(adjustment);
	}
	
	@Override
	public void pastSellbyAdjustment() {
		if(this.getSellIn() < 0) {
			this.depreciate(this.getQuality());
		}
	}

}
