package com.Shark.Paint;

import java.awt.*;

public class MovableBlock extends Block {

    public ImageAndLevel imageAndLevel=new ImageAndLevel() {
        @Override

        public void nextLevel(){
            setImageLevel(getImageLevel()+1);
        }
    };

    @Override
    public Image getImage() {
        return RawData.getMovableBlockImage(imageAndLevel.getImageLevel());
    }

}
