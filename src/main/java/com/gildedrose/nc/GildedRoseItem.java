package com.gildedrose.nc;

public class GildedRoseItem extends Item implements IGildedRoseItem {
	
	private int sellIn;
	private int quality;
	
	public GildedRoseItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
		this.sellIn = sellIn;
		this.quality = quality;
	}

	@Override
	public void dailyUpdate() {
    	this.adjustQuality(1);
    	
        this.adjustSellIn(1);
        
        this.pastSellbyAdjustment();		
	}
	
	@Override
	public void appreciate(int appreciation) {
        if (this.quality < 50) {
            this.quality = this.quality + appreciation;
        }		
	}

	@Override
	public void depreciate(int depreciation) {
		if((this.quality - depreciation) < 0) {
			this.quality = 0;			
		} else {
			this.quality = this.quality - depreciation;
		}
		
	}

	@Override
	public void adjustSellIn(int adjustment) {
		this.sellIn = this.sellIn - 1;
	}

	@Override
	public void adjustQuality(int adjustment) {
		this.depreciate(adjustment);
	}

	@Override
	public void pastSellbyAdjustment() {
        if (this.sellIn < 0) {
            this.depreciate(1);
        }		
	}
	
	public int getQuality() {
		return this.quality;
	}

	public int getSellIn() {
		return this.sellIn;
	}

	public void setSellIn(int sellIn) {
		this.sellIn = sellIn;
	}	
}
