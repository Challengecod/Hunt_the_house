
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner s = new Scanner(System.in);
        Map m = new Map();
        Rooms r = new Rooms();
        Player p = new Player();
        Boss b = new Boss();
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
            System.out.println("Player Stats: ");
            System.out.println("❤\uFE0F\u200D\uD83E\uDE79 Health points: " + p.getHealth());
            System.out.println("⚔\uFE0F Attack points: " + p.getAttack());
            while(gameOver != true){
                int tries = 3;

                System.out.println("----------------------");
                System.out.println("Type n(north), e(East), w(West) to navigate through the house!");
                System.out.println("Type s to see your player stats!");
                System.out.println("Type m to see your position on the map!");
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
                            p.updateHealthAttackRoom(m.getPlayerPosition());

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
                            p.updateHealthAttackRoom(m.getPlayerPosition());
                        }

                        else{
                            System.out.println("Incorrect your back at your previous position.");
                            m.failedRoom("n");
                        }
                     }
                        System.out.println("Player Stats: ");
                        System.out.println("❤\uFE0F\u200D\uD83E\uDE79 Health points: " + p.getHealth());
                        System.out.println("⚔\uFE0F Attack points: " + p.getAttack());
                    }

                    if (m.getPlayerPosition().substring(0, 1).equals("B")) {
                        System.out.println("YOU MET A BOSS!");
                        b.bossHealth(m.getPlayerPosition());
                        System.out.println("SO EXCITING!!!");
                        System.out.println("Aight lets get to it");
                        System.out.println("Aim: Win when the boss has no health points ");
                        while(b.getHealthPoints() >= 0 && p.getHealth() >= 0) {
                            System.out.println("---------------");
                            System.out.println("Boss Stats:");

                            System.out.println("❤\uFE0F\u200D\uD83E\uDE79 Health points: " + b.getHealthPoints());
                            System.out.println("⚔\uFE0F Attack points: " + b.getAttackPoints());
                            System.out.println("---------------");
                            System.out.println("Player Stats: ");
                            System.out.println("❤\uFE0F\u200D\uD83E\uDE79 Health points: " + p.getHealth());
                            System.out.println("⚔\uFE0F Attack points: " + p.getAttack());
                            System.out.println("---------------");
                            System.out.println("Type a(attack) or click enter if you don't want to attack: ");
                            String a = s.nextLine();
                            if(a.equals("a")){
                                b.getHit(p.getAttack());
                                System.out.println("❤\uFE0F\u200D\uD83E\uDE79 Boss Health points: " + b.getHealthPoints());
                            }
                            TimeUnit.SECONDS.sleep(1/2);

                            System.out.println("The boss attacks!");
                            TimeUnit.SECONDS.sleep(1);
                            p.getHit(b.getAttackPoints());
                            System.out.println("❤\uFE0F\u200D\uD83E\uDE79 Player Health points: " + p.getHealth());
                            TimeUnit.SECONDS.sleep(2);
                        }

                        if(p.getHealth() <= 0){
                            System.out.println("Close one");
                            System.out.println("GAME OVER");
                            gameOver = true;
                        }

                        else{
                            System.out.println();
                            System.out.println("---------");
                            System.out.println("You won!");
                            p.updateHealthAttackBoss(m.getPlayerPosition());

                        }
                        System.out.println("Player Stats: ");
                        System.out.println("❤\uFE0F\u200D\uD83E\uDE79 Health points: " + p.getHealth());
                        System.out.println("⚔\uFE0F Attack points: " + p.getAttack());

                    }

                    if(m.getPlayerPosition().substring(0,1).equals("W") || m.getPlayerPosition().equals("")){
                        System.out.println("You bumped into a wall!");
                        m.failedRoom("n");
                    }

                    System.out.println();
                }

                if(direction.equals("e")) {
                    m.updatePosition("e");

                    if (m.getPlayerPosition().substring(0, 1).equals("R")) {
                        System.out.println("You entered a riddle room!");

                        System.out.println("----------------------");
                        System.out.println("Number of Tries:" + tries);
                        System.out.println("----------------------");
                        System.out.println(r.getRoom(m.getPlayerPosition()));
                        String n = s.nextLine();
                        if (r.check(m.getPlayerPosition(), n)) {
                            System.out.println("Correct! You may keep going.");
                            p.updateHealthAttackRoom(m.getPlayerPosition());
                        }

                        else {
                            System.out.println("Incorrect!");
                            tries--;
                            System.out.println("Number of Tries:" + tries);
                            System.out.println("Enter the code number: ");
                            n = s.nextLine();

                            while (!r.check(m.getPlayerPosition(), n) && tries > 0) {
                                System.out.println("Incorrect!");
                                tries--;
                                System.out.println("Number of Tries:" + tries);
                                if (tries != 0) {
                                    System.out.println("Enter the code number: ");
                                    n = s.nextLine();
                                }
                            }

                            if (r.check(m.getPlayerPosition(), n)) {
                                System.out.println("Correct! You may keep going.");
                                p.updateHealthAttackRoom(m.getPlayerPosition());

                            }
                            else {
                                System.out.println("Incorrect your back at your previous position.");
                                m.failedRoom("e");
                            }

                        }

                        System.out.println("Player Stats: ");
                        System.out.println("❤\uFE0F\u200D\uD83E\uDE79 Health points: " + p.getHealth());
                        System.out.println("⚔\uFE0F Attack points: " + p.getAttack());

                    }

                    if (m.getPlayerPosition().substring(0, 1).equals("B")) {
                        System.out.println("YOU MET A BOSS!");
                        b.bossHealth(m.getPlayerPosition());
                        System.out.println("SO EXCITING!!!");
                        System.out.println("Aight lets get to it");
                        System.out.println("Aim: Win when the boss has no health points ");
                        while(b.getHealthPoints() >= 0 && p.getHealth() >= 0) {
                            System.out.println("---------------");
                            System.out.println("Boss Stats:");

                            System.out.println("❤\uFE0F\u200D\uD83E\uDE79 Health points: " + b.getHealthPoints());
                            System.out.println("⚔\uFE0F Attack points: " + b.getAttackPoints());
                            System.out.println("---------------");
                            System.out.println("Player Stats: ");
                            System.out.println("❤\uFE0F\u200D\uD83E\uDE79 Health points: " + p.getHealth());
                            System.out.println("⚔\uFE0F Attack points: " + p.getAttack());
                            System.out.println("---------------");
                            System.out.println("Type a(attack) or click enter if you don't want to attack: ");
                            String a = s.nextLine();
                            if(a.equals("a")){
                                b.getHit(p.getAttack());
                                System.out.println("❤\uFE0F\u200D\uD83E\uDE79 Boss Health points: " + b.getHealthPoints());
                            }
                            TimeUnit.SECONDS.sleep(1/2);

                            System.out.println("The boss attacks!");
                            TimeUnit.SECONDS.sleep(1);
                            p.getHit(b.getAttackPoints());
                            System.out.println("❤\uFE0F\u200D\uD83E\uDE79 Player Health points: " + p.getHealth());
                            TimeUnit.SECONDS.sleep(2);
                        }

                        if(p.getHealth() <= 0){
                            System.out.println("Close one");
                            System.out.println("GAME OVER");
                            gameOver= true;
                        }

                        else{
                            System.out.println();
                            System.out.println("---------");
                            System.out.println("You won!");
                            p.updateHealthAttackBoss(m.getPlayerPosition());

                        }

                        System.out.println("Player Stats: ");
                        System.out.println("❤\uFE0F\u200D\uD83E\uDE79 Health points: " + p.getHealth());
                        System.out.println("⚔\uFE0F Attack points: " + p.getAttack());

                    }

                    if(m.getPlayerPosition().substring(0,1).equals("W")){
                        System.out.println("You bumped into a wall!");
                        m.failedRoom("e");
                    }

                }

                if(direction.equals("w")){

                    m.updatePosition("w");
                    if (m.getPlayerPosition().substring(0, 1).equals("R")) {
                        System.out.println("You entered a riddle room!");

                        System.out.println("----------------------");
                        System.out.println("Number of Tries:" + tries);
                        System.out.println("----------------------");
                        System.out.println(r.getRoom(m.getPlayerPosition()));
                        String n = s.nextLine();
                        if (r.check(m.getPlayerPosition(), n)) {
                            System.out.println("Correct! You may keep going.");
                            p.updateHealthAttackRoom(m.getPlayerPosition());
                        }

                        else {
                            System.out.println("Incorrect!");
                            tries--;
                            System.out.println("Number of Tries:" + tries);
                            System.out.println("Enter the code number: ");
                            n = s.nextLine();

                            while (!r.check(m.getPlayerPosition(), n) && tries > 0) {
                                System.out.println("Incorrect!");
                                tries--;
                                System.out.println("Number of Tries:" + tries);
                                if (tries != 0) {
                                    System.out.println("Enter the code number: ");
                                    n = s.nextLine();
                                }
                            }

                            if (r.check(m.getPlayerPosition(), n)) {
                                System.out.println("Correct! You may keep going.");
                                p.updateHealthAttackRoom(m.getPlayerPosition());

                            }
                            else {
                                System.out.println("Incorrect your back at your previous position.");
                                m.failedRoom("w");
                            }

                        }

                        System.out.println("Player Stats: ");
                        System.out.println("❤\uFE0F\u200D\uD83E\uDE79 Health points: " + p.getHealth());
                        System.out.println("⚔\uFE0F Attack points: " + p.getAttack());

                    }

                    if (m.getPlayerPosition().substring(0, 1).equals("B")) {
                        System.out.println("YOU MET A BOSS!");
                        b.bossHealth(m.getPlayerPosition());
                        System.out.println("SO EXCITING!!!");
                        System.out.println("Aight lets get to it");
                        System.out.println("Aim: Win when the boss has no health points ");
                        while(b.getHealthPoints() >= 0 && p.getHealth() >= 0) {
                            System.out.println("---------------");
                            System.out.println("Boss Stats:");

                            System.out.println("❤\uFE0F\u200D\uD83E\uDE79 Health points: " + b.getHealthPoints());
                            System.out.println("⚔\uFE0F Attack points: " + b.getAttackPoints());
                            System.out.println("---------------");
                            System.out.println("Player Stats: ");
                            System.out.println("❤\uFE0F\u200D\uD83E\uDE79 Health points: " + p.getHealth());
                            System.out.println("⚔\uFE0F Attack points: " + p.getAttack());
                            System.out.println("---------------");
                            System.out.println("Type a(attack) or click enter if you don't want to attack: ");
                            String a = s.nextLine();
                            if(a.equals("a")){
                                b.getHit(p.getAttack());
                                System.out.println("❤\uFE0F\u200D\uD83E\uDE79 Boss Health points: " + b.getHealthPoints());
                            }
                            TimeUnit.SECONDS.sleep(1/2);

                            System.out.println("The boss attacks!");
                            TimeUnit.SECONDS.sleep(1);
                            p.getHit(b.getAttackPoints());
                            System.out.println("❤\uFE0F\u200D\uD83E\uDE79 Player Health points: " + p.getHealth());
                            TimeUnit.SECONDS.sleep(2);
                        }

                        if(p.getHealth() <= 0){
                            System.out.println("Close one");
                            System.out.println("GAME OVER");
                            gameOver= true;
                        }

                        else{
                            System.out.println();
                            System.out.println("---------");
                            System.out.println("You won!");
                            p.updateHealthAttackBoss(m.getPlayerPosition());

                        }

                        System.out.println("Player Stats: ");
                        System.out.println("❤\uFE0F\u200D\uD83E\uDE79 Health points: " + p.getHealth());
                        System.out.println("⚔\uFE0F Attack points: " + p.getAttack());

                    }

                    if(m.getPlayerPosition().substring(0,1).equals("W")){
                        System.out.println("You bumped into a wall!");
                        m.failedRoom("w");
                    }
                }

                if(direction.equals("s")){
                    System.out.println("-----------------");
                    System.out.println("Player Stats: ");
                    System.out.println("❤\uFE0F\u200D\uD83E\uDE79 Health points: " + p.getHealth());
                    System.out.println("⚔\uFE0F Attack points: " + p.getAttack());

                }

                if(direction.equals("m")){
                    System.out.println(m.getPlayerPosition());
                }

                if(m.getPlayerPosition().equals("BF")){
                    gameOver = true;
                }


            }
        }



    }



}