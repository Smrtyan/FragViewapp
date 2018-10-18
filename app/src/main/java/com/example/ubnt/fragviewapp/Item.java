package com.example.ubnt.fragviewapp;

public class Item {

    String Name;
    int Image;

    public Item(String Name, int Image)
    {
        this.Image = Image;
        this.Name = Name;
    }
    public String getName()
    {
        return Name;
    }
    public int getImage()
    {
        return Image;
    }

    @Override
    public String toString() {
        return Name;
    }

    @Override
    public boolean equals(Object obj) {
        return Name.equals(obj.toString());
    }
}