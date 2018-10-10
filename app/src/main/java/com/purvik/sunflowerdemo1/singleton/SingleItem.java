package com.purvik.sunflowerdemo1.singleton;

/**
 * Created by Purvik Rana on 10-10-2018.
 */
public class SingleItem {

    private int item_id;
    private int item;

    public SingleItem() {
    }

    public SingleItem(int item_id, int item) {
        this.item_id = item_id;
        this.item = item;
    }



    public SingleItem(int item) {
        this.item = item;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }
}
