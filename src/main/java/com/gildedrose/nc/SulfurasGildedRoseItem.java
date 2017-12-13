package com.gildedrose.nc;

public class SulfurasGildedRoseItem extends GildedRoseItem{

	public SulfurasGildedRoseItem(String name, int sellIn) {
		super(name, sellIn, 80);
	}
	
	@Override
	public void depreciate(int depreciation) {
		//no depreciation for this item!
	}
	
	@Override
	public void adjustSellIn(int adjustment) {
		//no sell in adjustment for this item!
	}
	
	@Override
	public void adjustQuality(int adjustment) {
		//no quality adjustment for Sulfuras
	}

	

}
