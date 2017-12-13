package com.gildedrose.nc;

import java.util.List;

class GildedRose {
    private List<GildedRoseItem> items;

	public GildedRose(List<GildedRoseItem> items) {
        this.items = items;
    }

    public void updateQuality() {
        for (GildedRoseItem item: items) {
        	
        	item.dailyUpdate();        	
        }
    }
    public List<GildedRoseItem> getItems() {
		return items;
	}

	public void setItems(List<GildedRoseItem> items) {
		this.items = items;
	}
    
}