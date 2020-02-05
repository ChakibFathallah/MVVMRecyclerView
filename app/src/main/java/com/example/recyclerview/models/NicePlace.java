package com.example.recyclerview.models;

public class NicePlace {

    private String name;

    private String image;

    public NicePlace(String name, String images) {
        this.name = name;
        this.image = images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImages(String images) {
        this.image = images;
    }
}
