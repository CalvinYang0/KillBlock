package com.Shark.Paint;

import java.awt.*;

public class Barrier extends Block {
    public Barrier() {

    }
    public  int getTouchTimes() {
        return touchTimes;
    }

    public  void setTouchTimes(int newTouchTimes) {
        touchTimes = newTouchTimes;
    }

    private  int touchTimes=0;
    public  ImageAndLevel imageAndLevel=new ImageAndLevel() {




        public void nextLevel(){

            setImageLevel((int)(Math.random()*RawData.getMaxLevel()));
            setTouchTimes(getTouchTimes()+1);
        }
    };
    public Image getImage() {
        return RawData.getBarrierImage(imageAndLevel.getImageLevel());
    }

}
