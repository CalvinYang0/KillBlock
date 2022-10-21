package com.Shark.Client;

import com.Shark.Paint.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Client implements KeyListener, Runnable {



    public Client() {
        super();


    }

    private void randomBlock() {
        if (RawData.getBlockNum() >= RawData.getBlockWidth() * RawData.getBlockHeight()) {
            RawData.setIfLose(true);
            return;
        }
        int x = (int) (Math.random() * RawData.getBlockWidth());
        int y = (int) (Math.random() * RawData.getBlockHeight());
        if (RawData.getGameMap(x, y) == null) {
            RawData.setGameMap(x, y, new MovableBlock());
            RawData.getGameMap(x, y).setX(x);
            RawData.getGameMap(x, y).setY(y);
        } else {
            randomBlock();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE&&RawData.isIfStart()==false){
            RawData.setIfStart(true);
            GameFrame.mapPaint.repaint();
        }
        if (RawData.isIfStart() == false) {
            return;
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            moveAllMovableBlock("up");

        } else if (e.getKeyCode() == KeyEvent.VK_D) {

            moveAllMovableBlock("right");

        } else if (e.getKeyCode() == KeyEvent.VK_S) {

            moveAllMovableBlock("down");

        } else if (e.getKeyCode() == KeyEvent.VK_A) {

            moveAllMovableBlock("left");

        }else {
            return ;

        }
        boolean barrierFlag = false;
        for (int i = 0; i < RawData.getBlockWidth(); i++) {
            for (int j = 0; j < RawData.getBlockHeight(); j++) {
               if (RawData.getGameMap(i,j) instanceof Barrier){
                   barrierFlag = true;
               }
            }
        }
        if (barrierFlag == false){
            RawData.setIfWin(true);
        }
        randomBlock();
        GameFrame.mapPaint.repaint();


    }


    @Override
    public void run() {


    }

    private boolean movable(MovableBlock movableBlock, int x, int y) {
        if (x < 0 || x >= RawData.getBlockWidth() || y < 0 || y >= RawData.getBlockHeight()) {
            return false;
        }
        if (RawData.getGameMap(x, y) == null) {
            return true;
        }
        if (RawData.getGameMap(x,y) instanceof Barrier)
        {
            if (((Barrier) RawData.getGameMap(x,y)).imageAndLevel.getImageLevel()==movableBlock.imageAndLevel.getImageLevel())
            {
                return true;
            }
        }
        if (RawData.getGameMap(x, y) instanceof Wall) {

                return false;
        }
        if (RawData.getGameMap(x, y) instanceof MovableBlock) {
            if (((MovableBlock) RawData.getGameMap(x, y)).imageAndLevel.getImageLevel() == movableBlock.imageAndLevel.getImageLevel()) {
                return true;
            }

        }
        return false;
    }

    private boolean swapBlock(int x1, int y1, int x2, int y2) {
        if (RawData.getGameMap(x2,y2) instanceof Barrier)
        {

            ((Barrier)RawData.getGameMap(x2,y2)).imageAndLevel.nextLevel();


            if (((Barrier)RawData.getGameMap(x2,y2)).getTouchTimes()>=RawData.getNeedTouchTimes())
            {
                RawData.setGameMap(x2, y2, null);
            }

            RawData.setGameMap(x1, y1, null);
            return false;
        }
        else {
            if (RawData.getGameMap(x2, y2) instanceof MovableBlock) {


                ((MovableBlock) RawData.getGameMap(x1, y1)).imageAndLevel. setImageLevel(((MovableBlock) RawData.getGameMap(x1, y1)).imageAndLevel.getImageLevel()+ 1);
            }
            RawData.setGameMap(x2, y2, RawData.getGameMap(x1, y1));
            RawData.setGameMap(x1, y1, null);
            RawData.getGameMap(x2, y2).setX(x2);
            RawData.getGameMap(x2, y2).setY(y2);
            if (((MovableBlock) RawData.getGameMap(x2, y2)).imageAndLevel.getImageLevel() == RawData.getMaxLevel()) {
                RawData.setGameMap(x2, y2, new Wall());
                return false;
            }
            return true;
        }

    }

    private void tryToMove(MovableBlock movableBlock, int directionX, int directionY) {
        if (movable(movableBlock, movableBlock.getX() + directionX, movableBlock.getY() + directionY)) {

            boolean swapFlag = swapBlock(movableBlock.getX(), movableBlock.getY(), movableBlock.getX() + directionX, movableBlock.getY() + directionY);
            if (swapFlag)
                tryToMove(movableBlock, directionX, directionY);

        }
    }

    private void moveAllMovableBlock(String direction) {
        if (direction.equals("up")) {
            for (int i = 0; i < RawData.getBlockHeight(); i++) {
                for (int j = 0; j < RawData.getBlockWidth(); j++) {
                    if (RawData.getGameMap(j, i) instanceof MovableBlock) {

                        tryToMove((MovableBlock) RawData.getGameMap(j, i), 0, -1);
                    }
                }
            }
        }
        if (direction.equals("down")) {
            for (int i = RawData.getBlockHeight() - 1; i >= 0; i--) {
                for (int j = 0; j < RawData.getBlockWidth(); j++) {
                    if (RawData.getGameMap(j, i) instanceof MovableBlock) {
                        tryToMove((MovableBlock) RawData.getGameMap(j, i), 0, 1);
                    }
                }
            }
        }
        if (direction.equals("left")) {
            for (int i = 0; i < RawData.getBlockWidth(); i++) {
                for (int j = 0; j < RawData.getBlockHeight(); j++) {
                    if (RawData.getGameMap(i, j) instanceof MovableBlock) {
                        tryToMove((MovableBlock) RawData.getGameMap(i, j), -1, 0);
                    }
                }
            }
        }
        if (direction.equals("right")) {
            for (int i = RawData.getBlockWidth() - 1; i >= 0; i--) {
                for (int j = 0; j < RawData.getBlockHeight(); j++) {
                    if (RawData.getGameMap(i, j) instanceof MovableBlock) {
                        tryToMove((MovableBlock) RawData.getGameMap(i, j), 1, 0);
                    }
                }
            }
        }

    }
}

