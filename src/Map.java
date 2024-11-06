import java.util.ArrayList;

public class Map {

    private int [][] mapDetail = {
            {1, 1, 2, 0},
            {1, 1, 0, 0},
            {0, 1, 2, 0},
            {1, 2, 2, 0}, // first
            {0, 2, 0, 0}, // out of the cave
    };

    private int xRow;
    private int yColumn ;
    private int position;

    public Map(){
        this.position = mapDetail[xRow][yColumn];
        this.xRow = 0;
        this.yColumn = 0;
    }

    public int getXPosition(){
        return xRow;
    }

    public int getYPosition(){
        return yColumn;
    }

    public ArrayList<Integer> getMapPass(int level){
        ArrayList<Integer> show = new ArrayList<>();
        for(int i : mapDetail[0]) {
            show.add(i);
        }
        return show;
    }


    public void updatePosition(String direction) {
        if(direction.equals("n")){
            position = mapDetail [xRow + 1] [yColumn];
        }

        if(direction.equals("s")){
            position = mapDetail [xRow - 1] [yColumn];
        }

        if(direction.equals("w")) {
            position = mapDetail[xRow][yColumn - 1];
        }

        if(direction.equals("e")) {
            position = mapDetail[xRow][yColumn + 1];
        }

    }
}
