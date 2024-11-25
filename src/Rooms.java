/**
 * The Room class represents a Riddle Room.
 * and a hobby
 */

public class Rooms {

    /**
     * Constructor for the Room class. This creates a new instance of a Room given
     * there is no variables to initialize
     */

    public Rooms(){

    }

    /**
     * getRoom method for the Room class. This method will return a String
     * containing the riddle problem. This is according to the string
     * variable r for which Room number
     *
     * @param r a String representing the position of the player at a
     * specific room number.
     *
     * @return returns a String in a containing a riddle question.
     *
     * the riddle of a specific Room according to the String r.
     */


    public String getRoom(String r){
        if(r.equals("R1")){
            String s = "A grandfather, two fathers and two sons went to the movie theater together and everyone bought one movie ticket each.\n" +
                    "How many tickets did they buy in total?\n" + "Enter your code number: ";
            return s;
        }

        if(r.equals("R2")){
            String s = "A little boy goes shopping and purchases 12 tomatoes.\n" +
                    "On the way home, all but 9 get mushed and ruined.\n" +
                    "How many tomatoes are left in a good condition?\n" +  "Enter your code number: ";
            return s;
        }

        if(r.equals("R3")){
            String s = "I’m an odd number.\n" + "But if you take away a letter from my name, I will become even. What number am I?\n" + "Enter your code number (In number form) : " ;
            return s;
        }

        if(r.equals("R4")){
            String s = "When David was eight, his little brother Alex was half his age.\n"+ "David is 30 now. How old is Alex?\n" + "Enter your code number: ";
            return s;
        }

        if(r.equals("R5")){
            String s = " I add six to eleven what do I get? (Hint: clock) "  + "Enter your code number: ";
            return s;
        }

        return "nothing";
    }

    /**
     * The check method will check the answer of the user given the riddle.
     *
     *
     * @param r a String representing the Room number
     * @param answer a String representing the user’s answer towards a
     *                   riddle
     * @return a boolean to true or false according to the answer matched with the specified room     */


    public boolean check(String r, String answer){
        if(r.equals("R1")){
            if(answer.equals("3")){
                return true;
            }
            else{
                return false;
            }

        }

        if(r.equals("R2")){
            if(answer.equals("9")){
                return true;
            }
            else{
                return false;
            }
        }

        if(r.equals("R3")){
            if(answer.equals("7")){
                return true;
            }
            else{
                return false;
            }
        }

        if(r.equals("R4")){
            if(answer.equals("26")){
                return true;
            }

            else{
                return false;
            }
        }

        if(r.equals("R5")){
            if(answer.equals("5")){
                return true;
            }
            else{
                return false;
            }
        }

        return false;
    }

}


