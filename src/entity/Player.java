package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player extends Entity{

    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH) {

        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {

        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {

        try {

            stand_up1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/prototype_character_stand_up_01.png")));
            stand_up2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/prototype_character_stand_up_02.png")));
            stand_down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/prototype_character_stand_down_01.png")));
            stand_down2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/prototype_character_stand_down_02.png")));
            stand_left1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/prototype_character_stand_left_01.png")));
            stand_left2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/prototype_character_stand_left_02.png")));
            stand_right1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/prototype_character_stand_right_01.png")));
            stand_right2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/prototype_character_stand_right_02.png")));

            walk_up1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/prototype_character_walk_up_01.png")));
            walk_up2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/prototype_character_walk_up_02.png")));
            walk_up3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/prototype_character_walk_up_03.png")));
            walk_up4 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/prototype_character_walk_up_04.png")));

            walk_down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/prototype_character_walk_down_01.png")));
            walk_down2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/prototype_character_walk_down_02.png")));
            walk_down3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/prototype_character_walk_down_03.png")));
            walk_down4 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/prototype_character_walk_down_04.png")));

            walk_left1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/prototype_character_walk_left_01.png")));
            walk_left2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/prototype_character_walk_left_02.png")));
            walk_left3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/prototype_character_walk_left_03.png")));
            walk_left4 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/prototype_character_walk_left_04.png")));

            walk_right1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/prototype_character_walk_right_01.png")));
            walk_right2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/prototype_character_walk_right_02.png")));
            walk_right3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/prototype_character_walk_right_03.png")));
            walk_right4 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/prototype_character_walk_right_04.png")));

        } catch (IOException e) {
            System.out.println("Image Not Working");
        }
    }

    public void update() {

        if (keyH.upPressed) {
            y -= speed;
            direction = "up";
        } else if (keyH.downPressed) {
            y += speed;
            direction ="down";
        } else if (keyH.leftPressed) {
            x -= speed;
            direction = "left";
        } else if (keyH.rightPressed) {
            x += speed;
            direction = "right";
        }

        spriteCounter ++;

        if (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {
            if (spriteCounter > frameRate) {
                if(spriteNum == 5 || spriteNum == 6) {
                    spriteNum = 1;
                } else if(spriteNum == 1) {
                    spriteNum = 2;
                } else if(spriteNum == 2) {
                    spriteNum = 3;
                } else if(spriteNum == 3) {
                    spriteNum = 4;
                } else if(spriteNum == 4) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        } else {
            if (spriteCounter > frameRate) {
                if(spriteNum == 1 || spriteNum ==2 || spriteNum ==3 || spriteNum ==4 || spriteNum == 6) {
                    spriteNum = 5;
                } else if(spriteNum == 5) {
                    spriteNum = 6;
                }
                spriteCounter = 0;
            }
        }
    }

    public void draw(Graphics2D g2) {

        BufferedImage image = null;

        switch (direction) {
            case "up":
                if (spriteNum == 1) {
                    image = walk_up1;
                }
                if (spriteNum == 2) {
                    image = walk_up2;
                }
                if (spriteNum == 3) {
                    image = walk_up3;
                }
                if (spriteNum == 4) {
                    image = walk_up4;
                }
                if (spriteNum == 5) {
                    image = stand_up1;
                }
                if (spriteNum == 6) {
                    image = stand_up2;
                }
                break;
            case "down":
                if (spriteNum == 1) {
                    image = walk_down1;
                }
                if (spriteNum == 2) {
                    image = walk_down2;
                }
                if (spriteNum == 3) {
                    image = walk_down3;
                }
                if (spriteNum == 4) {
                    image = walk_down4;
                }
                if (spriteNum == 5) {
                    image = stand_down1;
                }
                if (spriteNum == 6) {
                    image = stand_down2;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    image = walk_left1;
                }
                if (spriteNum == 2) {
                    image = walk_left2;
                }
                if (spriteNum == 3) {
                    image = walk_left3;
                }
                if (spriteNum == 4) {
                    image = walk_left4;
                }
                if (spriteNum == 5) {
                    image = stand_left1;
                }
                if (spriteNum == 6) {
                    image = stand_left2;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    image = walk_right1;
                }
                if (spriteNum == 2) {
                    image = walk_right2;
                }
                if (spriteNum == 3) {
                    image = walk_right3;
                }
                if (spriteNum == 4) {
                    image = walk_right4;
                }
                if (spriteNum == 5) {
                    image = stand_right1;
                }
                if (spriteNum == 6) {
                    image = stand_right2;
                }
                break;
        }

        g2.drawImage(image, x, y, gp.tileSize,gp.tileSize, null);
    }
}
