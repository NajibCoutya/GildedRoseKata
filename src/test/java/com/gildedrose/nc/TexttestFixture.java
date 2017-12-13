package com.gildedrose.nc;

import java.util.ArrayList;
import java.util.List;

import com.gildedrose.nc.AgedBrieGildedRoseItem;
import com.gildedrose.nc.BackstageGildedRoseItem;
import com.gildedrose.nc.GildedRose;
import com.gildedrose.nc.GildedRoseItem;
import com.gildedrose.nc.Item;
import com.gildedrose.nc.SulfurasGildedRoseItem;

public class TexttestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        List<GildedRoseItem> items = new ArrayList<GildedRoseItem>();
             items.add(   new GildedRoseItem("+5 Dexterity Vest", 10, 20)); //
             items.add(    new AgedBrieGildedRoseItem("Aged Brie", 2, 0)); //
             items.add(   new GildedRoseItem("Elixir of the Mongoose", 5, 7)); //
             items.add(   new SulfurasGildedRoseItem("Sulfuras, Hand of Ragnaros", 0)); //
             items.add(   new SulfurasGildedRoseItem("Sulfuras, Hand of Ragnaros", -1));
             items.add(   new BackstageGildedRoseItem("Backstage passes to a TAFKAL80ETC concert", 15, 20));
             items.add(   new BackstageGildedRoseItem("Backstage passes to a TAFKAL80ETC concert", 10, 49));
            items.add(   new BackstageGildedRoseItem("Backstage passes to a TAFKAL80ETC concert", 5, 49));
                // this conjured item does not work properly yet
            items.add(    new GildedRoseItem("Conjured Mana Cake", 3, 6));

        GildedRose app = new GildedRose(items);

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality();
        }
    }

}
