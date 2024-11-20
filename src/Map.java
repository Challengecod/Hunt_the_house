public class Map {

    private String[][] mapDetail = {
            {"S", "R1", "W", "W"}, //[0][1]
            {"R2", "R3", "B1", "W"}, //[1]
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
                    position = mapDetail[xRow][yColumn];

                }
        }
    }

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

    public String mapInformation(){
        String map = "";
        for(int i = 0; i  < rowSize; i++){
            for(int j = 0; j < columnSize; j ++){
                map += mapDetail[i][j] + " ";
            }
            map += "\n";
        }

        return map;
    }
}
