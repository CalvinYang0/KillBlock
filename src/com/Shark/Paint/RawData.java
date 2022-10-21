package com.Shark.Paint;



import java.awt.*;

import static java.lang.Math.pow;

public class RawData {
    private static Color colorBackground = Color.BLUE;

    public static int getBlockNum() {
        return BlockNum;
    }

    public static int getNeedTouchTimes() {
        return NeedTouchTimes;
    }

    public static void setNeedTouchTimes(int needTouchTimes) {
        NeedTouchTimes = needTouchTimes;
    }

    private static int NeedTouchTimes=4;
    private  static int BlockNum=0;
    private  static int blockLength=100;
    private static int blockWidth=4;
    private static  int blockHeight=4;
    private static Image startImage=Toolkit.getDefaultToolkit().getImage(MapPaint.class.getResource("start.jpg" ));

    public static Image getStartImage() {
        return startImage;
    }

    public static Image getWinImage() {
        return winImage;
    }

    public static Image getLoseImage() {
        return loseImage;
    }

    private static Image winImage=Toolkit.getDefaultToolkit().getImage(MapPaint.class.getResource("win.jpg" ));
    private static Image loseImage=Toolkit.getDefaultToolkit().getImage(MapPaint.class.getResource("lose.jpg" ));
    public static Image getBackgroundImage() {
        return backgroundImage;
    }

    private static Image backgroundImage=Toolkit.getDefaultToolkit().getImage(MapPaint.class.getResource("background.jpg" ));
    public static Image getMovableBlockImage(int level) {
        if (level<MaxLevel)
        return movableBlockImages[level];
        else return null;
    }

    public static Image[] getMovableBlockImages() {
        return movableBlockImages;
    }

    public static Image getWallImage() {
        return wallImage;
    }

    private final static int MaxLevel=3;
    public static int getMaxLevel() {
        return MaxLevel;
    }
    private static Image[] movableBlockImages =new Image[MaxLevel];
    private static Image wallImage =Toolkit.getDefaultToolkit().getImage(MapPaint.class.getResource("Wall.png"));
    static{
        for (int i=0;i<MaxLevel;i++){
            movableBlockImages[i]=Toolkit.getDefaultToolkit().getImage(MapPaint.class.getResource(((int)pow(2,i+1))+".png"));
        }


    }

    public static Image getBarrierImage(int level) {
        return barrierImages[level];
    }

    private static Image[] barrierImages=new Image[NeedTouchTimes];
    static {
        for (int i=0;i<MaxLevel;i++){
            barrierImages[i]=Toolkit.getDefaultToolkit().getImage(MapPaint.class.getResource((i+1)+".jpg"));
        }
    }

    private static Block[][] gameMap;
    public static int getBlockLength() {

        return blockLength;
    }
    public static int getBlockWidth() {
        return blockWidth;
    }
    public static int getBlockHeight() {
        return blockHeight;
    }
    public static void setBlockLength(int blockLength) {
        RawData.blockLength = blockLength;
    }
    public static void setBlockWidth(int blockWidth) {
        RawData.blockWidth = blockWidth;
    }
    public static void setBlockHeight(int blockHeight) {
        RawData.blockHeight = blockHeight;
    }

    public static Color getColorBackground() {
        return colorBackground;
    }

    public static void setColorBackground(Color colorBackground) {
        RawData.colorBackground = colorBackground;
    }



    public static Block[][] getGameMap() {
        return gameMap;
    }

    public static void setGameMap(int row,int column,Block value) {
        if (value!=null&&gameMap[row][column]==null)
            BlockNum++;
        else if (value==null&&gameMap[row][column]!=null)
            BlockNum--;
        RawData.gameMap[row][column] = value;
    }
    public static void setGameMap(Block[][] newGameMap){
        RawData.gameMap = newGameMap;
    }
    public static  Block getGameMap(int row,int column){
        if (row>=0&&row<blockWidth&&column>=0&&column<blockHeight)
        {
            return gameMap[row][column];
        }
        else
        {
            return null;
        }

    }

    public static boolean isIfStart() {
        return ifStart;
    }

    public static void setIfStart(boolean ifStart) {
        RawData.ifStart = ifStart;
    }

    public static boolean isIfWin() {
        return ifWin;
    }

    public static void setIfWin(boolean ifWin) {
        RawData.ifWin = ifWin;
    }

    private static boolean ifStart=false;
    private static boolean ifWin=false;

    public static boolean isIfLose() {
        return ifLose;
    }

    public static void setIfLose(boolean ifLose) {
        RawData.ifLose = ifLose;
    }

    private static boolean ifLose=false;

}
