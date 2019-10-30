package com.example.destinationfinder;

public class resturant {
    private String Title;
    private String Category;
    private String Description;
    private int thumbnail;

    public resturant() {

    }

    public resturant(String title, String category, String description, int thumbnail) {
        Title = title;
        Category = category;
        Description = description;
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
