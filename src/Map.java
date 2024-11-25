/**
 * The Map class represents the map. The map is a 2D String Array that
 * contains the position of the player and the layout of the map.
 */

public class Map {

    private String[][] mapDetail = {
            {"S", "R1", "B1", "W"}, //[0][1]
            {"R2", "R3", "W", "W"}, //[1]
            {"W", "B2", "R5", "W"}, //[2]
            {"W", "R4", "B3", "W"}, //[3]
            {"W", "BF", "W", "W"}, //[4]
            // Key: S = Starting, R = Riddle Rx = specific riddle B = Boss Bx = specific boss
    };


    private int rowSize = mapDetail.length;
    private int columnSize = mapDetail[0].length;

    private int xRow;
    private int yColumn;
    private String position;

    /**
     * Constructor for the Map class. This creates a new instance of a position
     * starting at zero xRow row index set to zero and
     * yColumn column index set to zero
     *
     */


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

    /**
     * getPlayerPosition method for the Map class. This method will return
     * player’s position based on their row and column number.
     *
     * @return returns a String of the player position.
     *
     */

    public String getPlayerPosition() {
        return position;
    }

    /**
     * updatePosition method for the Map class. This method will update
     * player’s position based on their direction. North the row will
     * increase, East the column would increase, West the column would decrease
     *
     * @param direction represents a String of the direction.
     *
     */

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
                    position = mapDetail[xRow][yColumn];

                }
        }
    }

    /**
     * failedRoom method for the Map class. This method will update
     * player’s position to their previous position based on their
     * direction they input before. North the row will decrease
     * East the column would decrease, West the column would increase
     *
     * @param direction represents a String of the direction.
     *
     */

    public void failedRoom(String direction){


        if (direction.equals("n")) {
                xRow -= 1;
                position = mapDetail[xRow][yColumn];
        }

        if (direction.equals("w")) {
                yColumn += 1;
                position = mapDetail[xRow][yColumn];
        }


        if (direction.equals("e")) {
                yColumn -= 1;
                position = mapDetail[xRow][yColumn];

        }

    }

    /**
     * mapInformation method for the Map class. This method will add all
     * the map positions to a string for the user to see the whole map
     *
     * @return returns a String of the values in the 2D String Array
     *
     */


    public String mapInformation(){
        String map = "";
        for(int i = 0; i  < rowSize; i++){
            for(int j = 0; j < columnSize; j ++){
                if(mapDetail[i][j].length()!= 2){
                    map +=  mapDetail[i][j] + "  ";
                }
                else {
                    map += mapDetail[i][j] + " ";
                }
            }
            map += "\n";
        }

        return map;
    }
}
