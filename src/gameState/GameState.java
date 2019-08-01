package gameState;

import java.awt.*;

public abstract class GameState {

    protected GameStateManager gsm;

    public GameState(GameStateManager gsm){
        this.gsm = gsm;
        init();
    }

    public abstract void init();
    public abstract void tick();
    public abstract void draw(Graphics graphics);
    public abstract void keyPressed(int k);
    public abstract void keyReleased(int k);

}
