package gameState;

import gameMain.*;
import gameState.GameState;
import gameState.GameStateManager;

import java.awt.*;
import java.awt.event.KeyEvent;

public class MenuState extends GameState {

    private String[] options = {"Start", "Help", "Quit"};
    private int currentSelection = 0;
    public MenuState(GameStateManager gsm){
        super(gsm);
    }

    public void init() {

    }

    public void tick() {

    }

    public void draw(Graphics graphics) {

        graphics.setColor(new Color(200, 250, 100));
        graphics.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);

        for (int i = 0; i < options.length; i++) {
            if (i == currentSelection) {
                graphics.setColor(Color.GREEN);
            } else {
                graphics.setColor(Color.RED);
            }
            graphics.drawLine(GamePanel.WIDTH / 2, 0, GamePanel.WIDTH / 2, GamePanel.HEIGHT);
            graphics.setFont(new Font("Arial", Font.PLAIN, 72));
            graphics.drawString(options[i], GamePanel.WIDTH /2 - 75, 150 + i * 150);
        }
    }

    public void keyPressed(int k) {
        if(k == KeyEvent.VK_DOWN){
            currentSelection++;
            if(currentSelection >= options.length){
                currentSelection = 0;
            }
        } else if (k == KeyEvent.VK_UP){
            currentSelection--;
            if(currentSelection < 0) {
                currentSelection = options.length - 1;
            }
        } if(k == KeyEvent.VK_ENTER){
            if(currentSelection <= 0){
                //play
            } else if(currentSelection == 1){
                //help
            } else if(currentSelection == 2){
                System.exit(0);
            }
        }

    }

    public void keyReleased(int k) {

    }
}
