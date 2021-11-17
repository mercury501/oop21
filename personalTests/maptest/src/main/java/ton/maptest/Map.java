package ton.maptest;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class Map {
    int map[][];
    int x,y;
    int numRooms;
    int maxRooms;

    List<Room> roomList = new ArrayList<>();

    public Map(int x, int y, int mr){
        this.map = new int[x][y];
        for (int i = 0; i < x; i++) 
            for (int j = 0; j < y; j++)
                map[i][j] = 0;

        this.numRooms = 0;
        this.maxRooms = mr;
        this.x = x;
        this.y = y;
    }
    /*
    _____________> y
    |
    |   .
    |
    |
    V
    X

    */

    private boolean checkRoomSpace(int x, int y, int h, int w){
        if (((x + h) > this.x) || ((y + w) > this.y))
            return false;
        
        for (int i = x; i < x + h; i++) 
            for (int j = y; j < y + w ; j++)
                if(this.map[i][j] != 0)
                    return false;

        return true;

    }

    private void createRoom(int x, int y, int height, int width){
        this.roomList.add(new Room(x, y, height, width));

        for (int i = x; i < x + height; i++) 
            for (int j = y; j < y + width ; j++)
                this.map[i][j] = 1;

        
    }

    public void addRoom(){
        if (this.numRooms == this.maxRooms)
            return;
        
        Random gen = new Random();
        Boolean createdRoom = false;

        while(!createdRoom){
        int vertexX =  gen.nextInt(this.x);
        int vertexY = gen.nextInt(this.y);

        int height = 3 + gen.nextInt(5);
        int width = 3 + gen.nextInt(8);
        
        createdRoom = checkRoomSpace(vertexX, vertexY, height, width);
        if (createdRoom)    
            createRoom(vertexX, vertexY, height, width);

        
    }

}
    
    public void printMap(){
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++)
                temp.append(map[i][j] + " ");
        System.out.println(temp);
        temp.setLength(0);
        }
            
    }
}
