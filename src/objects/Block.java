package objects;

import gameState.GameState;

import java.awt.*;

public class Block extends Rectangle {
    private static final long serialVersionUID = 1L;

    public static final int blockSize = 64;
    private int id;

    public Block(int x, int y, int id){
        setBounds(x , y, blockSize, blockSize);
        this.id = id;
    }

    public void tick(){

    }

    public void draw(Graphics graphics){
        graphics.setColor(Color.ORANGE);
        if(id != 0) {
            graphics.fillRect(x - (int) GameState.xOffset, y - (int) GameState.yOffset, width, height);
            }
    }

    public void setId() {
        this.id = id;
    }

    public int getId(){
        return id;
    }
}
