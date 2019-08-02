package physics;

import java.awt.*;
import objects.Block;

public class Collision {

    public static boolean knightBlock(Point p, Block b){
        return b.contains(p);
    }

}
