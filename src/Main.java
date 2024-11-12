import java.io.File;
import java.io.RandomAccessFile;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Map m = new Map();
        Rooms r = new Rooms();
        System.out.println("------------");
        System.out.println("Welcome to the Huanted House " + "\uD83C\uDF83" + "\uD83C\uDFDA");
        System.out.println("The thunder outside is booming! " + "⚡\uFE0F" + "\uD83C\uDFDA");
        System.out.println("Hurry up and enter the house " + "\uD83D\uDC79");
        System.out.println("Type Enter to enter the house " + "\uD83D\uDC79" );
        String enter = s.nextLine();

        boolean gameOver = false;

        if(enter.equals("ed")){
            System.out.println("HAHAHA ready to get the party started?");
            System.out.println("Goal: escape this haunted house");
            while(gameOver != true){
                int tries = 3;
                boolean done = false;
                System.out.println("----------------------");
                System.out.println("Type n(north), e(East), w(West) to navigate through the house!");
                String direction = s.nextLine();
                if(direction.equals("n")){
                    m.updatePosition("n");
                    if(m.getPlayerPosition().substring(0,1).equals("R")){
                        System.out.println("You entered a riddle room!");

                        System.out.println("----------------------");
                        System.out.println("Number of Tries:" + tries);
                        System.out.println("----------------------");
                        System.out.println( r.getRoom(m.getPlayerPosition()));
                        String n = s.nextLine();
                        if(r.check(m.getPlayerPosition(), n)){
                            System.out.println("Correct! You may keep going.");
                        }

                        else {
                            System.out.println("Incorrect!");
                            tries --;
                            System.out.println("Number of Tries:" + tries);
                            System.out.println("Enter the code number: ");
                            n = s.nextLine();

                            while (!r.check(m.getPlayerPosition(), n) && tries > 0) {
                                System.out.println("Incorrect!");
                                tries --;
                                System.out.println("Number of Tries:" + tries);
                                if(tries !=0) {
                                    System.out.println("Enter the code number: ");
                                    n = s.nextLine();
                                }


                        }
                        if(r.check(m.getPlayerPosition(), n)){
                            System.out.println("Correct! You may keep going.");
                        }
                        else{
                            System.out.println("Incorrect your back at your previous position.");
                            m.failedRoom("n");
                        }

                     }
                    }
                    System.out.println();
                }

                if(direction.equals("e")){
                    m.updatePosition("e");

                    if(m.getPlayerPosition().substring(0,1).equals("R")){
                        System.out.println("You entered a riddle room!");

                        System.out.println("----------------------");
                        System.out.println("Number of Tries:" + tries);
                        System.out.println("----------------------");
                        System.out.println( r.getRoom(m.getPlayerPosition()));
                        String n = s.nextLine();
                        if(r.check(m.getPlayerPosition(), n)){
                            System.out.println("Correct! You may keep going.");
                        }

                        else {
                            System.out.println("Incorrect!");
                            tries --;
                            System.out.println("Number of Tries:" + tries);
                            System.out.println("Enter the code number: ");
                            n = s.nextLine();

                            while (!r.check(m.getPlayerPosition(), n) && tries > 0) {
                                System.out.println("Incorrect!");
                                tries --;
                                System.out.println("Number of Tries:" + tries);
                                if(tries !=0) {
                                    System.out.println("Enter the code number: ");
                                    n = s.nextLine();
                                }


                            }
                            if(r.check(m.getPlayerPosition(), n)){
                                System.out.println("Correct! You may keep going.");
                            }
                            else{
                                System.out.println("Incorrect your back at your previous position.");
                                m.failedRoom("n");
                            }

                        }

                    }

                }

                if(direction.equals("w")){

                    m.updatePosition("w");
                    if(!m.getPlayerPosition().substring(0,1).equals("R") || !m.getPlayerPosition().substring(0,1).equals("B")){
                        System.out.println("You bumped into a wall!");
                    }
                    System.out.println(m.getPlayerPosition());

                }

                if(m.getPlayerPosition().equals("BF")){
                    gameOver = true;
                }

            }
        }



    }



}