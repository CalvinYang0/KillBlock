package com.Shark.Paint;

import java.awt.*;

public abstract class ImageAndLevel{
    public int getImageLevel() {
        return imageLevel;
    }

    public void setImageLevel(int imageLevel) {
        this.imageLevel = imageLevel;
    }

    private int imageLevel;



    public ImageAndLevel() {
        setImageLevel(0);
    }
    public ImageAndLevel(int newImageLevel) {
        setImageLevel(newImageLevel);
    }
    public  abstract void nextLevel();

}

