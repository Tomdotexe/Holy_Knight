package gameMain;

import gameState.GameStateManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//Use this class to draw
public class GamePanel extends JPanel implements Runnable, KeyListener {
    private static final long serialVersionUID = 1L;

    public static final int WIDTH = 800;
    public static final int LENGTH = 550;

    private Thread thread;
    private boolean isRunning = false;

    private int FPS = 60;
    private long targetTime = 1000 / FPS;

    private GameStateManager gsm;

    public GamePanel(){
        setPreferredSize(new Dimension(WIDTH, LENGTH));

        addKeyListener(this);
        setFocusable(true);

        start();
    }

    private void start(){
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }

    public void run(){
        gsm = new GameStateManager();
        long start, elapsed, wait;
        while(isRunning){
            start = System.nanoTime();

            tick();
            repaint();

            elapsed = System.nanoTime() - start;
            wait = targetTime - elapsed/1000000;

            if(wait <= 0){
                wait = 5;
            }

            try{
                Thread.sleep(wait);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    //Makes gameMain.Game Loop
    public void tick(){
        gsm.tick();
    }

    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);

        graphics.clearRect(0, 0, WIDTH, HEIGHT);

        gsm.draw(graphics);
    }

    public void keyTyped(KeyEvent keyEvent) {
    }

    public void keyPressed(KeyEvent keyEvent) {
        gsm.keyPressed(keyEvent.getKeyCode());
    }

    public void keyReleased(KeyEvent keyEvent) {
        gsm.keyReleased(keyEvent.getKeyCode());
    }
}
