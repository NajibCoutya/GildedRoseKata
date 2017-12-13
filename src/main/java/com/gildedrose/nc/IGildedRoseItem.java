package com.gildedrose.nc;

public interface IGildedRoseItem {
	
	void appreciate(int appreciation);
	void depreciate(int depreciation);
	void adjustSellIn(int adjustment);
	void adjustQuality(int adjustment);
	void pastSellbyAdjustment();
	void dailyUpdate();
}
