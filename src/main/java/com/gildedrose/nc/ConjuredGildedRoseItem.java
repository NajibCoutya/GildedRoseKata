package com.gildedrose.nc;

public class ConjuredGildedRoseItem extends GildedRoseItem {

	public ConjuredGildedRoseItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	@Override
	public void depreciate(int depreciation) {
		super.depreciate(2*depreciation);
	}
}
