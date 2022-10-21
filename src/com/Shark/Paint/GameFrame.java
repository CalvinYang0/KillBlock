package com.Shark.Paint;

import javax.swing.*;

public class GameFrame extends JFrame {
    public static MapPaint mapPaint;
    public GameFrame() {
        mapPaint = new MapPaint();
        this.setTitle("KillBlock");
        //设置frame 的size，考虑边框大小,visible后有效
        this.setVisible(true);
        this.setSize(RawData.getBlockWidth()*RawData.getBlockLength()+this.getInsets().left+this.getInsets().right, RawData.getBlockHeight()*RawData.getBlockLength()+this.getInsets().top+this.getInsets().bottom);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(mapPaint);
        //输出边框大小



    }
}
