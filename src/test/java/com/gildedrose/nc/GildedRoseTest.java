package com.gildedrose.nc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.gildedrose.nc.AgedBrieGildedRoseItem;
import com.gildedrose.nc.BackstageGildedRoseItem;
import com.gildedrose.nc.ConjuredGildedRoseItem;
import com.gildedrose.nc.GildedRose;
import com.gildedrose.nc.GildedRoseItem;
import com.gildedrose.nc.SulfurasGildedRoseItem;

public class GildedRoseTest {

    @Test
    public void foo() {
        List<GildedRoseItem> items = new ArrayList<GildedRoseItem>();
        items.add( new GildedRoseItem("foo", 0, 0));
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.getItems().get(0).name);
    }
    
    @Test
    public void qualityDegradesTwiceAsFastOnceSellByDatePassed() {
    	GildedRoseItem item = new GildedRoseItem("+5 Dexterity Vest", -1, 20);
    	List<GildedRoseItem> items = new ArrayList<GildedRoseItem>();
    	items.add(item);
    	GildedRose app = new GildedRose(items);
    	app.updateQuality();
    	assertEquals("quality degrades twice as fast after sell by date", 20-2, item.getQuality());
    }

    @Test
    public void qualityOfAnItemIsNeverNegative() {
    	GildedRoseItem item = new GildedRoseItem("+5 Dexterity Vest", -1, 0);
    	List<GildedRoseItem> items = new ArrayList<GildedRoseItem>();
    	items.add(item);
    	GildedRose app = new GildedRose(items);
    	app.updateQuality();
    	assertTrue("quality is never negative", item.getQuality() >= 0);
    }
    
    @Test
    public void agedBrieIncreasesInQualityTheOlderItGets() {
    	int brieQuality = 4;
    	GildedRoseItem item = new AgedBrieGildedRoseItem("Aged Brie", 2, brieQuality);
    	List<GildedRoseItem> items = new ArrayList<GildedRoseItem>();
    	items.add(item);
    	GildedRose app = new GildedRose(items);
    	app.updateQuality();
    	assertEquals("Aged brie increases in quality", brieQuality + 1, item.getQuality());    	
    }
    
    @Test
    public void qualityOfAnItemIsNeverMoreThanFifty() {
    	int maxQuality =50;
    	GildedRoseItem item = new AgedBrieGildedRoseItem("Aged Brie", 5, maxQuality);
    	List<GildedRoseItem> items = new ArrayList<GildedRoseItem>();
    	items.add(item);
    	GildedRose app = new GildedRose(items);
    	app.updateQuality();
    	assertEquals("quality will not exceed 50", maxQuality, item.getQuality());    	
    }

    @Test
    public void sulfurasNeverDecreasesInQuality() {
    	int sulfurasQuality = 80;
    	int sulfurasSellByDate = 0;
    	GildedRoseItem item = new SulfurasGildedRoseItem("Sulfuras, Hand of Ragnaros",0);
    	List<GildedRoseItem> items = new ArrayList<GildedRoseItem>();
    	items.add(item);
    	GildedRose app = new GildedRose(items);
    	app.updateQuality();
    	assertEquals("sulfura quality never decreases", sulfurasQuality, item.getQuality());
    	assertEquals("sulfura is never sold", sulfurasSellByDate, item.getSellIn());
    	app.updateQuality();
    	assertEquals("sulfura quality never decreases", sulfurasQuality, item.getQuality());
    }
    
    @Test
    public void backStageQualityIncreasesInValueAsSellbyDateApproaches() {
    	int sellBy = 13;
    	int quality = 30;
    	GildedRoseItem item = new BackstageGildedRoseItem("Backstage passes to a TAFKAL80ETC concert", sellBy, quality);
    	List<GildedRoseItem> items = new ArrayList<GildedRoseItem>();
    	items.add(item);
    	GildedRose app = new GildedRose(items);
    	app.updateQuality();
    	assertEquals("Backstage increases in quality as sell by approaches", quality + 1, item.getQuality());    	
    }

    @Test
    public void backStageQualityIncreasesByTwoWhenSellbyIsLessThan10Days() {
    	int sellBy = 8;
    	int quality = 30;
    	GildedRoseItem item = new BackstageGildedRoseItem("Backstage passes to a TAFKAL80ETC concert", sellBy, quality);
    	List<GildedRoseItem> items = new ArrayList<GildedRoseItem>();
    	items.add(item);
    	GildedRose app = new GildedRose(items);
    	app.updateQuality();
    	assertEquals("Backstage increases in quality by 2 when less than 10 days left", quality + 2, item.getQuality());    	
    }
    
    @Test
    public void backStageQualityIncreasesByThreeWhenSellbyIsLessThan5Days() {
    	int sellBy = 4;
    	int quality = 30;
    	GildedRoseItem item = new BackstageGildedRoseItem("Backstage passes to a TAFKAL80ETC concert", sellBy, quality);
    	List<GildedRoseItem> items = new ArrayList<GildedRoseItem>();
    	items.add(item);
    	GildedRose app = new GildedRose(items);
    	app.updateQuality();
    	assertEquals("Backstage increases in quality by 2 when less than 10 days left", quality + 3, item.getQuality());    	
    }

    @Test
    public void backStageQualityDropsToZeroAfterConcert() {
    	int sellBy = -2;
    	int quality = 30;
    	GildedRoseItem item = new BackstageGildedRoseItem("Backstage passes to a TAFKAL80ETC concert", sellBy, quality);
    	List<GildedRoseItem> items = new ArrayList<GildedRoseItem>();
    	items.add(item);
    	GildedRose app = new GildedRose(items);
    	app.updateQuality();
    	assertEquals("Backstage quality drops to zero after concert", 0, item.getQuality());    	
    }

    @Test
    public void conjuredItemsDegradeTwiceAsFast() {
    	int sellBy = 4;
    	int quality = 30;
    	GildedRoseItem item = new ConjuredGildedRoseItem("Conjured Item", sellBy, quality);
    	List<GildedRoseItem> items = new ArrayList<GildedRoseItem>();
    	items.add(item);
    	GildedRose app = new GildedRose(items);
    	app.updateQuality();
    	assertEquals("Conjured drop in quality twice as fast", quality - 2, item.getQuality());    	    	
    }
    
    @Test
    public void conjuredItemsQualityShouldHaveAQuadrupleDecreasePastSellbyDate() {
    	int sellBy = -5;
    	int quality = 30;
    	GildedRoseItem item = new ConjuredGildedRoseItem("Conjured Item", sellBy, quality);
    	List<GildedRoseItem> items = new ArrayList<GildedRoseItem>();
    	items.add(item);
    	GildedRose app = new GildedRose(items);
    	app.updateQuality();
    	assertEquals("Conjured quality should be zero on sell by date", quality - 4, item.getQuality());
    	app.updateQuality();
    	assertEquals("Conjured quality should be zero on sell by date", quality - 8, item.getQuality());
    }
    
}
