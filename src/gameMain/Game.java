package gameMain;

import gameMain.GamePanel;

import javax.swing.*;
import java.awt.*;

public class Game {
    public static void main(String[] args){
        JFrame frame = new JFrame("Jumpman Jumpman Jumpman, These Boys Up To Somethin’");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        frame.add(new GamePanel(), BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
