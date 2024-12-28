package entity;

import java.awt.image.BufferedImage;

public class Entity {

    public int x,y;
    public int speed;

    public BufferedImage
            stand_up1, stand_up2, stand_down1, stand_down2,
            stand_left1, stand_left2, stand_right1, stand_right2,
            walk_up1, walk_up2, walk_up3, walk_up4,
            walk_down1, walk_down2, walk_down3, walk_down4,
            walk_left1, walk_left2, walk_left3, walk_left4,
            walk_right1, walk_right2, walk_right3, walk_right4;
    public String direction;

    int frameRate = 30; //20frames in 90fps, 2/9 seconds

    int spriteNum = 1;
    int spriteCounter = 0;
}
