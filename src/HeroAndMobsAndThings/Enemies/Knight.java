package HeroAndMobsAndThings.Enemies;

import gameMain.Game;
import gameState.GameState;
import objects.Block;
import physics.Collision;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Knight {
    //private static final long serialVersionUID = 1L;
    //movement
    private boolean right = false, left = false, jumping = false, falling = false, topCollision = false;
    //knight dimensions
    private double x, y;
    private int width, height;
    //jump Speed
    private double jumpSpeed = 5;
    private double currentJumpSpeed = jumpSpeed;
    //moveSpeed
    private double moveSpeed = 2.75;
    //fall speed
    private double maxFallSpeed = 4;
    private double currentFallSpeed = 0.1;

    public Knight(int width, int height){
        //setBounds(375, 300, width, height);
        x = 375;
        y = 300;
        this.width = width;
        this.height = height;
    }

    public void tick(Block[][] b) {
        int iX = (int) x;
        int iY = (int) y;

        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {

                //right
                if (Collision.knightBlock(new Point(iX + width + (int) GameState.xOffset, iY + (int) GameState.yOffset + 2), b[i][j]) ||
                        Collision.knightBlock(new Point(iX + width + (int) GameState.xOffset, iY + height + (int) GameState.yOffset - 1), b[i][j])) {
                    right = false;
                }
                //left
                if (Collision.knightBlock(new Point(iX + (int) GameState.xOffset - 1, iY + (int) GameState.yOffset + 2), b[i][j]) ||
                        Collision.knightBlock(new Point(iX + (int) GameState.xOffset - 1, iY + height + (int) GameState.yOffset - 1), b[i][j])) {
                    left = false;
                }
                //top
                if (Collision.knightBlock(new Point(iX + (int) GameState.xOffset + 1, iY + (int) GameState.yOffset), b[i][j]) ||
                        Collision.knightBlock(new Point(iX + +width + (int) GameState.xOffset - 1, iY + (int) GameState.yOffset), b[i][j])) {
                    jumping = false;
                    falling = true;
                }
                //bottom
                if (Collision.knightBlock(new Point(iX + (int) GameState.xOffset + 2, iY + height + (int) GameState.yOffset + 1), b[i][j]) ||
                        Collision.knightBlock(new Point(iX + width + (int) GameState.xOffset - 1, iY + height + (int) GameState.yOffset + 1), b[i][j])) {
                    y = b[i][j].getY() - height - GameState.yOffset;
                    falling = false;
                    topCollision = true;
                } else {
                    if (!topCollision && !jumping) {
                        falling = true;
                    }
                }
            }

        }

        topCollision = false;

        if (right == true) {
            GameState.xOffset += moveSpeed;
        }
        if (left == true) {
            GameState.xOffset -= moveSpeed;
        }
        if (jumping == true) {
            GameState.yOffset -= currentJumpSpeed;
            currentJumpSpeed -= 0.1;
            if (currentJumpSpeed <= 0) {
                currentJumpSpeed = jumpSpeed;
                jumping = false;
                falling = true;
            }
        }
        if (falling == true) {
            GameState.yOffset += currentFallSpeed;
            if (currentFallSpeed < maxFallSpeed) {
                currentFallSpeed += 0.1;
            }
        }
        if (!falling) {
            currentFallSpeed = 0.1;
        }
    }

    public void draw(Graphics  graphics){
        graphics.setColor(Color.LIGHT_GRAY);
        graphics.fillRect((int)x, (int)y, width, height);
    }

    public void keyPressed(int k){
        if(k == KeyEvent.VK_D) right = true;
        if(k == KeyEvent.VK_A) left = true;
        if(k == KeyEvent.VK_W && !jumping && !falling) jumping = true;
    }

    public void keyReleased(int k){
        if(k == KeyEvent.VK_D) right = false;
        if(k == KeyEvent.VK_A) left = false;
    }

}
