package com.josephvuoto.customdialog.list;

public class ListItemModel {
    private int imgResourceId;
    private String itemString;

    public ListItemModel(int imgResourceId, String itemString) {
        this.imgResourceId = imgResourceId;
        this.itemString = itemString;
    }

    public ListItemModel(String itemString) {
        this.itemString = itemString;
        this.imgResourceId = -1;
    }

    public int getImgResourceId() {
        return imgResourceId;
    }

    public void setImgResourceId(int imgResourceId) {
        this.imgResourceId = imgResourceId;
    }

    public String getItemString() {
        return itemString;
    }

    public void setItemString(String itemString) {
        this.itemString = itemString;
    }
}
