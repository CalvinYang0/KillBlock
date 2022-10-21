package com.Shark.Paint;

import javax.swing.*;
import java.awt.*;
public  class MapPaint extends JPanel {
    public MapPaint() {
        initGameMap();
    }

    public void initGameMap() {
        RawData.setGameMap(new Block[RawData.getBlockWidth()][RawData.getBlockHeight()]);
        for (int i = 0; i < RawData.getBlockWidth(); i++) {
            for (int j = 0; j < RawData.getBlockHeight(); j++) {
                RawData.setGameMap(i,j,null);
            }
        }
        RawData.setGameMap(0,0,new Barrier());
        RawData.setGameMap(0,3,new Barrier());
        RawData.setGameMap(3,3,new Barrier());
        RawData.setGameMap(3,0,new Barrier());


    }



    public void paint(Graphics g) {
        super.paint(g);


        if (RawData.isIfStart()){
            g.drawImage(RawData.getBackgroundImage(),0,0,this);
            if (RawData.isIfWin()){
                g.drawImage(RawData.getWinImage(),0,0,this);
                return ;
            }
            if (RawData.isIfLose()){
                g.drawImage(RawData.getLoseImage(),0,0,this);
                return ;
            }
        }
        else {
            g.drawImage(RawData.getStartImage(),0,0,this);
        }
        if (RawData.isIfStart()){
            for (int i = 0; i < RawData.getBlockWidth(); i++) {
                for (int j = 0; j < RawData.getBlockHeight(); j++) {
                    if (RawData.getGameMap(i,j) != null) {
                        g.drawImage(RawData.getGameMap(i,j).getImage(), i * RawData.getBlockLength(), j * RawData.getBlockLength(), RawData.getBlockLength(), RawData.getBlockLength(), this);
                    }



                }
            }
        }



    }

}
