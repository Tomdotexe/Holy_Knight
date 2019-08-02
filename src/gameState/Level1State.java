package gameState;

import HeroAndMobsAndThings.Enemies.Knight;
import mapping.Map;
import objects.Block;

import java.awt.*;

public class Level1State extends GameState {

    private Knight knight;
    private Map map;
    //private Block[] b;

    public Level1State(GameStateManager gsm){
        super(gsm);
    }

    public void init() {
        knight = new Knight(25, 25);
        map = new Map("/map1.map");

        xOffset = -200;
        yOffset = -400;
    }

    public void tick() {
        knight.tick(map.getBlocks());
    }

    public void draw(Graphics graphics) {
        knight.draw(graphics);
        map.draw(graphics);
    }

    public void keyPressed(int k) {
        knight.keyPressed(k);
    }

    public void keyReleased(int k) {
        knight.keyReleased(k);
    }
}
//b = new Block[3];

//        b[0] = new Block(100, 370);
//        b[1] = new Block(200, 370);
//        b[2] = new Block(330, 370);