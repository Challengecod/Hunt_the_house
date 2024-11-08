import java.util.ArrayList;

public class Map {

    private String[][] mapDetail = {
            {"S", "R1" , "B1", "W"},
            {"R2", "R3",  "W", "W"},
            {"W", "R4", "R5", "W"},
            {"W", "B3", "B4", "W"},
            {"W", "BF", "W", "W"},
            // Key: S = Starting, R = Riddle Rx = specific riddle B = Boss Bx = specific boss
    };

    private int rowSize = mapDetail.length;
    private int columnSize = mapDetail[0].length;

    private int xRow;
    private int yColumn;
    private String position;

    public Map() {
        this.position = mapDetail[xRow][yColumn];
        this.xRow = 0;
        this.yColumn = 0;
    }

    public int getXPosition() {
        return xRow;
    }

    public int getYPosition() {
        return yColumn;
    }

    public String getPlayerPosition() {
        return position;
    }


    public void updatePosition(String direction) {
        if (direction.equals("n")) {
            if (xRow + 1 <= rowSize) {
                xRow += 1;
                position = mapDetail[xRow][yColumn];

            }
        }
        if (direction.equals("w")) {
                if (yColumn - 1 >= 0) {
                    yColumn -= 1;
                    position = mapDetail[xRow][yColumn];

                }
            }
            //[0][1]
        if (direction.equals("e")) {
                if (yColumn + 1 <= columnSize) {
                    yColumn += 1;
                    position = mapDetail[0][1];

                }
        }
    }

    public void eneterRoom(){
        if(getPlayerPosition().equals("R2")){


        }
    }
}
