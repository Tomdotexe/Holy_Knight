package gameState;

import gameState.GameState;

import java.awt.*;
import java.util.Stack;

public class GameStateManager {

    public Stack<GameState> states;

    public GameStateManager(){
        states = new Stack<GameState>();
        states.push(new MenuState(this));
    }

    public void tick(){
        states.peek().tick();
    }

    public void draw(Graphics graphics){
        states.peek().draw(graphics);
    }

    public void keyPressed(int k){
        states.peek().keyPressed(k);
    }

    public void keyReleased(int k){
        states.peek().keyReleased(k);
    }
}
