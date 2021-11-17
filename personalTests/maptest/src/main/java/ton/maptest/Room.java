package ton.maptest;

import java.util.HashMap;
import java.util.List;

public class Room {
    int x;
    int y;

    int height;
    int width;

    HashMap<String, List> Things;
    
    public Room(int x, int y, int height, int width){
        this.x = x;
        this.y = y;
        
        this.height = height;
        this.width = width;

        this.Things = new HashMap<>();
    }
    
}
