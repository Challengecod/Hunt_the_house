import java.io.File;
import java.io.RandomAccessFile;
import java.io.IOException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Map m = new Map();
        System.out.println("------------");
        System.out.println("Welcome to the Huanted House " + "\uD83C\uDF83" + "\uD83C\uDFDA");
        System.out.println("The thunder outside is booming! " + "⚡\uFE0F" + "\uD83C\uDFDA");
        System.out.println("Hurry up and enter the house " + "\uD83D\uDC79");
        System.out.println("Type Enter to enter the house " + "\uD83D\uDC79" );
        String enter = s.nextLine();

        boolean gameOver = false;
        int level = 1;

        if(enter.equals("enter")){
            System.out.println("HAHAHA ready to get the party started?");
            System.out.println("Goal: escape this haunted house");
            while(gameOver != true){
                System.out.println("Currently to the North of you is a door");
                System.out.println("To the East there is also a door");
                System.out.println("Type n to go North and e to go East");
                String direction = s.nextLine();
                if(direction.equals("n")){
                    System.out.println("You entered your first room!");

                    System.out.println();
                }
                gameOver = true;

            }
        }

        System.out.println(m.getMapPass(1));

    }



}