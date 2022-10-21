package com.Shark.Paint;

import java.awt.*;

public abstract class Block {
    private int x;
    private int y;


    public Block(){
        super();
    }
    public abstract Image  getImage();








    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
