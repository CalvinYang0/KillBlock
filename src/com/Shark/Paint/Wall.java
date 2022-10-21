package com.Shark.Paint;

import java.awt.*;

public class Wall extends Block {
    public Wall() {
        super();

    }

    @Override
    public Image getImage() {
        return RawData.getWallImage();
    }
}

