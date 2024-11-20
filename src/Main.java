
import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner s = new Scanner(System.in);
        Map m = new Map();
        Rooms r = new Rooms();
        Player p = new Player();
        Boss b = new Boss();
        Inventory inventory = new Inventory();
        System.out.println("------------");
        System.out.println("Welcome to the Huanted House " + "\uD83C\uDF83" + "\uD83C\uDFDA");
        System.out.println("The thunder outside is booming! " + "⚡\uFE0F" + "\uD83C\uDFDA");
        System.out.println("Hurry up and enter the house " + "\uD83D\uDC79");
        System.out.println("Type Enter to enter the house " + "\uD83D\uDC79");
        String enter = s.nextLine();

        boolean gameOver = false;

        if (enter.equals("ed")) {
            System.out.println("HAHAHA ready to get the party started?");
            System.out.println("Goal: escape this haunted house by reaching BF(Final Boss) on the map!");
            System.out.println("Player Stats: ");
            System.out.println("❤\uFE0F\u200D\uD83E\uDE79 Health points: " + p.getHealth());
            System.out.println("⚔\uFE0F Attack points: " + p.getAttack());

            while (gameOver != true) {
                int tries = 3;
                boolean tick = false;

                System.out.println("----------------------");
                System.out.println("Type n(north), e(East), w(West) to navigate through the house!");
                System.out.println("Type s to see your player stats!");
                System.out.println("Type p to see your position on the map or type m to see the whole map!");
                System.out.println("Type i to see your inventory! ");
                String direction = s.nextLine();


                //North Direction
                if (direction.equals("n")) {
                    m.updatePosition("n");

                    // Final BOSS
                    if ( m.getPlayerPosition().equals("BF")) {
                        System.out.println("YOU MET THE FINAL BOSS!");
                        b.bossHealth(m.getPlayerPosition());
                        System.out.println("SO EXCITING!!!");
                        System.out.println("Aight lets get to it");
                        System.out.println("Aim: Win when the boss has no health points ");
                        System.out.println("Game Over: Your health points hit zero or is below zero.");
                        while (b.getHealthPoints() >= 0 && p.getHealth() >= 0) {
                            System.out.println("---------------");
                            System.out.println("Boss Stats:");

                            System.out.println("❤\uFE0F\u200D\uD83E\uDE79 Health points: " + b.getHealthPoints());
                            System.out.println("⚔\uFE0F Attack points: " + b.getAttackPoints());
                            System.out.println("---------------");
                            TimeUnit.SECONDS.sleep(1 / 2);
                            System.out.println("Player Stats: ");
                            System.out.println("❤\uFE0F\u200D\uD83E\uDE79 Health points: " + p.getHealth());
                            System.out.println("⚔\uFE0F Attack points: " + p.getAttack());
                            TimeUnit.SECONDS.sleep(1 / 2);
                            System.out.println("---------------");
                            System.out.println("Players Turn");

                            if (tick == true) {

                                System.out.println("Boss got poisoned");
                                b.getHit(1);
                                System.out.println("❤\uFE0F\u200D\uD83E\uDE79 Boss Health points: " + b.getHealthPoints());
                                System.out.println();

                            }
                            System.out.println("Type a(attack) or click enter if you don't want to attack: ");
                            System.out.println("Type u(use) to use an item from your inventory");
                            String a = s.nextLine();
                            if (a.equals("a")) {
                                b.getHit(p.getAttack());
                                System.out.println("❤\uFE0F\u200D\uD83E\uDE79 Boss Health points: " + b.getHealthPoints());
                            } else if (a.equals("u")) {
                                System.out.println(inventory.items());
                                if (inventory.items().equals("No Items!")) {
                                    System.out.println("You just lost a turn because you have no items \uD83D\uDE2D");
                                } else {
                                    System.out.println("Poison potion = Boss health ticks by one every player turn. \uD83D\uDC9A");
                                    System.out.println("Healing potion = Heal your own health by 5 points. \uD83D\uDC96 ");
                                    System.out.println("Enter your potion (don't add the word potion after): ");
                                    String u = s.nextLine();
                                    u = u.toLowerCase();
                                    inventory.useItem(u + " Potion");
                                    u = u + " Potion";

                                    if (u.equals("poison Potion")) {
                                        System.out.println("Poison Potion used! \uD83D\uDC9A ");
                                        tick = true;
                                        System.out.println(inventory.items());
                                    }

                                    if (u.equals("healing Potion")) {
                                        System.out.println("Healing Potion used! \uD83D\uDC9A");
                                        p.updateHealthPotion();
                                        System.out.println("❤\uFE0F\u200D\uD83E\uDE79 Player Health points: " + p.getHealth());
                                        TimeUnit.SECONDS.sleep(1 / 2);
                                        System.out.println(inventory.items());
                                    }
                                }

                            }
                            TimeUnit.SECONDS.sleep(1 / 2);

                            if (b.getHealthPoints() > 0) {
                                System.out.println("Boss Turn: ");
                                System.out.println("The boss attacks!");
                                TimeUnit.SECONDS.sleep(1);
                                p.getHit(b.getAttackPoints());
                                System.out.println("❤\uFE0F\u200D\uD83E\uDE79 Player Health points: " + p.getHealth());
                            }

                            TimeUnit.SECONDS.sleep(2);
                        }

                        if (p.getHealth() <= 0) {
                            System.out.println("Close one");
                            System.out.println("GAME OVER");
                            gameOver = true;
                        }

                        else {
                            System.out.println();
                            System.out.println("---------");
                            System.out.println("You won!");
                            System.out.println();
                            gameOver = true;

                            System.out.println("You escaped the haunted house!!");
                            System.out.println("How do you feel? (Don't answer) ");
                            System.out.println("Come Back next time! We will have more riddles and Bosses for you!");

                        }

                    }

                    else if (m.getPlayerPosition().substring(0, 1).equals("B")) {
                        System.out.println("YOU MET A BOSS!");
                        b.bossHealth(m.getPlayerPosition());
                        System.out.println("SO EXCITING!!!");
                        System.out.println("Aight lets get to it");
                        System.out.println("Aim: Win when the boss has no health points ");
                        System.out.println("Game Over: Your health points hit zero or is below zero.");
                        while (b.getHealthPoints() >= 0 && p.getHealth() >= 0) {
                            System.out.println("---------------");
                            System.out.println("Boss Stats:");

                            System.out.println("❤\uFE0F\u200D\uD83E\uDE79 Health points: " + b.getHealthPoints());
                            System.out.println("⚔\uFE0F Attack points: " + b.getAttackPoints());
                            System.out.println("---------------");
                            TimeUnit.SECONDS.sleep(1 / 2);
                            System.out.println("Player Stats: ");
                            System.out.println("❤\uFE0F\u200D\uD83E\uDE79 Health points: " + p.getHealth());
                            System.out.println("⚔\uFE0F Attack points: " + p.getAttack());
                            TimeUnit.SECONDS.sleep(1 / 2);
                            System.out.println("---------------");
                            System.out.println("Players Turn");

                            if (tick == true) {

                                System.out.println("Boss got poisoned");
                                b.getHit(1);
                                System.out.println("❤\uFE0F\u200D\uD83E\uDE79 Boss Health points: " + b.getHealthPoints());
                                System.out.println();

                            }
                            System.out.println("Type a(attack) or click enter if you don't want to attack: ");
                            System.out.println("Type u(use) to use an item from your inventory");
                            String a = s.nextLine();

                            if (a.equals("a")) {
                                b.getHit(p.getAttack());
                                System.out.println("❤\uFE0F\u200D\uD83E\uDE79 Boss Health points: " + b.getHealthPoints());
                            } else if (a.equals("u")) {

                                System.out.println(inventory.items());
                                if (inventory.items().equals("No Items!")) {
                                    System.out.println("You just lost a turn because you have no items \uD83D\uDE2D");
                                } else {
                                    System.out.println("Poison potion = Boss health ticks by one every player turn. \uD83D\uDC9A");
                                    System.out.println("Healing potion = Heal your own health by 5 points. \uD83D\uDC96 ");
                                    System.out.println("Type poison for Poison Potion and healing for Healing Potion");
                                    System.out.println("Enter your potion (don't add the word potion after): ");
                                    String u = s.nextLine();
                                    u = u.toLowerCase();
                                    inventory.useItem(u + " Potion");
                                    u = u + " Potion";

                                    if (u.equals("poison Potion")) {
                                        System.out.println("Poison Potion used! \uD83D\uDC9A ");
                                        tick = true;
                                        System.out.println(inventory.items());
                                    }

                                    if (u.equals("healing Potion")) {
                                        System.out.println("Healing Potion used! \uD83D\uDC9A");
                                        p.updateHealthPotion();
                                        System.out.println("❤\uFE0F\u200D\uD83E\uDE79 Player Health points: " + p.getHealth());
                                        TimeUnit.SECONDS.sleep(1 / 2);
                                        System.out.println(inventory.items());
                                    }
                                }

                            }
                            TimeUnit.SECONDS.sleep(1 / 2);

                            if (b.getHealthPoints() > 0) {
                                System.out.println("Boss Turn: ");
                                System.out.println("The boss attacks!");
                                TimeUnit.SECONDS.sleep(1);
                                p.getHit(b.getAttackPoints());
                                System.out.println("❤\uFE0F\u200D\uD83E\uDE79 Player Health points: " + p.getHealth());
                            }
                            TimeUnit.SECONDS.sleep(2);
                        }

                        if (p.getHealth() <= 0) {
                            System.out.println("Close one");
                            String RESET = "\u001B[0m";
                            String RED = "\u001B[31m";
                            System.out.println(RED + "GAME OVER" + RESET);
                            gameOver = true;
                        } else {
                            System.out.println();
                            System.out.println("---------");
                            System.out.println("You won!");
                            p.updateHealthAttackBoss(m.getPlayerPosition());

                        }
                        System.out.println("Player Stats: ");
                        System.out.println("❤\uFE0F\u200D\uD83E\uDE79 Health points: " + p.getHealth());
                        System.out.println("⚔\uFE0F Attack points: " + p.getAttack());

                    }

                    if (m.getPlayerPosition().substring(0, 1).equals("R")) {
                        System.out.println("You entered a riddle room!");

                        System.out.println("----------------------");
                        System.out.println("Number of Tries: " + tries);
                        System.out.println("----------------------");
                        System.out.println(r.getRoom(m.getPlayerPosition()));
                        String n = s.nextLine();

                        if (r.check(m.getPlayerPosition(), n)) {
                            System.out.println("Correct! You may keep going.");
                            p.updateHealthAttackRoom(m.getPlayerPosition());

                            int getPotion = (int) (Math.random()*(5-1+1))+ 1;

                            if (getPotion == 3) {
                                System.out.println("Rare Drop a Healing Potion! \uD83D\uDC96 ");
                                inventory.addInventory("healing Potion");
                            }
                            if (getPotion == 2) {
                                System.out.println("Rare Drop Poison Potion! \uD83D\uDC9A ");
                                inventory.addInventory("poison Potion");
                            }

                        } else {
                            System.out.println("Incorrect!");
                            tries--;
                            System.out.println("Number of Tries: " + tries);
                            System.out.println("Enter the code number: ");
                            n = s.nextLine();

                            while (!r.check(m.getPlayerPosition(), n) && tries > 0) {
                                System.out.println("Incorrect!");
                                tries--;
                                System.out.println("Number of Tries: " + tries);
                                if (tries != 0) {
                                    System.out.println("Enter the code number: ");
                                    n = s.nextLine();
                                }


                            }
                            if (r.check(m.getPlayerPosition(), n)) {
                                System.out.println("Correct! You may keep going.");

                                p.updateHealthAttackRoom(m.getPlayerPosition());

                                int getPotion = (int) (Math.random() * (5 - 1 + 1)) + 1;

                                if (getPotion == 1) {
                                    System.out.println("Rare Drop a Healing Potion! \uD83D\uDC96 ");
                                    inventory.addInventory("healing Potion");
                                }
                                if (getPotion == 2) {
                                    System.out.println("Rare Drop Poison Potion! \uD83D\uDC9A ");
                                    inventory.addInventory("poison Potion");
                                }
                            } else {
                                System.out.println("Incorrect your back at your previous position.");
                                m.failedRoom("n");
                            }
                        }
                        System.out.println("Player Stats: ");
                        System.out.println("❤\uFE0F\u200D\uD83E\uDE79 Health points: " + p.getHealth());
                        System.out.println("⚔\uFE0F Attack points: " + p.getAttack());
                    }


                    if (m.getPlayerPosition().substring(0, 1).equals("W") || m.getPlayerPosition().equals("")) {
                        System.out.println("You bumped into a wall!");
                        m.failedRoom("n");
                    }

                    System.out.println();
                }

                // East Direction
                if (direction.equals("e")) {
                    m.updatePosition("e");

                    if (m.getPlayerPosition().substring(0, 1).equals("R")) {
                        System.out.println("You entered a riddle room!");

                        System.out.println("----------------------");
                        System.out.println("Number of Tries: " + tries);
                        System.out.println("----------------------");
                        System.out.println(r.getRoom(m.getPlayerPosition()));
                        String n = s.nextLine();
                        if (r.check(m.getPlayerPosition(), n)) {
                            System.out.println("Correct! You may keep going.");
                            p.updateHealthAttackRoom(m.getPlayerPosition());
                            // the player gets a potion if the random number is 1 or 2
                            int getPotion = (int) (Math.random() * (5 - 1 + 1)) + 1;

                            if (getPotion == 1) {
                                System.out.println("Rare Drop a Healing Potion! \uD83D\uDC96 ");
                                inventory.addInventory("healing Potion");
                            }
                            if (getPotion == 2) {
                                System.out.println("Rare Drop Poison Potion! \uD83D\uDC9A ");
                                inventory.addInventory("poison Potion");
                            }
                        } else {
                            System.out.println("Incorrect!");
                            tries--;
                            System.out.println("Number of Tries: " + tries);
                            System.out.println("Enter the code number: ");
                            n = s.nextLine();

                            while (!r.check(m.getPlayerPosition(), n) && tries > 0) {
                                System.out.println("Incorrect!");
                                tries--;
                                System.out.println("Number of Tries: " + tries);
                                if (tries != 0) {
                                    System.out.println("Enter the code number: ");
                                    n = s.nextLine();
                                }
                            }

                            if (r.check(m.getPlayerPosition(), n)) {
                                System.out.println("Correct! You may keep going.");
                                p.updateHealthAttackRoom(m.getPlayerPosition());
                                // the player gets a potion if the random number is 1 or 2
                                int getPotion = (int) (Math.random() * (5 - 1 + 1)) + 1;

                                if (getPotion == 1) {
                                    System.out.println("Rare Drop a Healing Potion! \uD83D\uDC96 ");
                                    inventory.addInventory("healing Potion");
                                }
                                if (getPotion == 2) {
                                    System.out.println("Rare Drop Poison Potion! \uD83D\uDC9A ");
                                    inventory.addInventory("poison Potion");
                                }

                            } else {
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
                        System.out.println("Game Over: Your health points hit zero or is below zero.");
                        while (b.getHealthPoints() > 0 && p.getHealth() > 0) {
                            System.out.println("---------------");
                            System.out.println("Boss Stats:");

                            System.out.println("❤\uFE0F\u200D\uD83E\uDE79 Health points: " + b.getHealthPoints());
                            System.out.println("⚔\uFE0F Attack points: " + b.getAttackPoints());
                            System.out.println("---------------");
                            TimeUnit.SECONDS.sleep(1 / 2);
                            System.out.println("Player Stats: ");
                            System.out.println("❤\uFE0F\u200D\uD83E\uDE79 Health points: " + p.getHealth());
                            System.out.println("⚔\uFE0F Attack points: " + p.getAttack());
                            TimeUnit.SECONDS.sleep(1 / 2);
                            System.out.println("---------------");
                            System.out.println("Players Turn");

                            if (tick == true) {

                                System.out.println("Boss got poisoned");
                                b.getHit(1);
                                System.out.println("❤\uFE0F\u200D\uD83E\uDE79 Boss Health points: " + b.getHealthPoints());
                                System.out.println();

                            }

                            System.out.println("Type a(attack) or click enter if you don't want to attack: ");
                            System.out.println("Type u(use) to use an item from your inventory");
                            String a = s.nextLine();
                            if (a.equals("a")) {
                                b.getHit(p.getAttack());
                                System.out.println("❤\uFE0F\u200D\uD83E\uDE79 Boss Health points: " + b.getHealthPoints());

                            } else if (a.equals("u")) {
                                System.out.println(inventory.items());
                                if (inventory.items().equals("No Items!")) {
                                    System.out.println("You just lost a turn because you have no items \uD83D\uDE2D");
                                } else {
                                    System.out.println("Poison potion = Boss health ticks by one every player turn. \uD83D\uDC9A");
                                    System.out.println("Healing potion = Heal your own health by 5 points. \uD83D\uDC96 ");
                                    System.out.println("Enter your potion (don't add the word potion after): ");
                                    String u = s.nextLine();
                                    u = u.toLowerCase();
                                    inventory.useItem(u + " Potion");
                                    u = u + " Potion";


                                    if (u.equals("poison Potion")) {
                                        System.out.println("Poison Potion used! \uD83D\uDC9A ");
                                        tick = true;
                                        System.out.println(inventory.items());
                                    }

                                    if (u.equals("healing Potion")) {
                                        System.out.println("Healing Potion used! \uD83D\uDC9A");
                                        p.updateHealthPotion();
                                        System.out.println("❤\uFE0F\u200D\uD83E\uDE79 Player Health points: " + p.getHealth());
                                        TimeUnit.SECONDS.sleep(1 / 2);
                                        System.out.println(inventory.items());
                                    }
                                }

                            }
                            TimeUnit.SECONDS.sleep(1 / 2);

                            if (b.getHealthPoints() > 0) {
                                System.out.println("Boss Turn: ");
                                System.out.println("The boss attacks!");
                                TimeUnit.SECONDS.sleep(1);
                                p.getHit(b.getAttackPoints());
                                System.out.println("❤\uFE0F\u200D\uD83E\uDE79 Player Health points: " + p.getHealth());
                            }
                            TimeUnit.SECONDS.sleep(2);

                        }

                        if (p.getHealth() <= 0) {
                            System.out.println("Close one");
                            String RESET = "\u001B[0m";
                            String RED = "\u001B[31m";
                            System.out.println(RED + "GAME OVER" + RESET);
                            gameOver = true;

                        }
                        else {
                            System.out.println();
                            System.out.println("---------");
                            System.out.println("You won!");
                            p.updateHealthAttackBoss(m.getPlayerPosition());

                        }
                        System.out.println("Player Stats: ");
                        System.out.println("❤\uFE0F\u200D\uD83E\uDE79 Health points: " + p.getHealth());
                        System.out.println("⚔\uFE0F Attack points: " + p.getAttack());

                    }

                    if (m.getPlayerPosition().substring(0, 1).equals("W")) {
                        System.out.println("You bumped into a wall!");
                        m.failedRoom("e");
                    }

                }


                // West direction
                if (direction.equals("w")) {

                    m.updatePosition("w");
                    if (m.getPlayerPosition().substring(0, 1).equals("R")) {
                        System.out.println("You entered a riddle room!");

                        System.out.println("----------------------");
                        System.out.println("Number of Tries: " + tries);
                        System.out.println("----------------------");
                        System.out.println(r.getRoom(m.getPlayerPosition()));
                        String n = s.nextLine();
                        if (r.check(m.getPlayerPosition(), n)) {
                            System.out.println("Correct! You may keep going.");
                            p.updateHealthAttackRoom(m.getPlayerPosition());
                            // the player gets a potion if the random number is 1 or 2
                            int getPotion = (int) (Math.random() * (5 - 1 + 1)) + 1;

                            if (getPotion == 1) {
                                System.out.println("Rare Drop a Healing Potion! \uD83D\uDC96 ");
                                inventory.addInventory("healing Potion");
                            }
                            if (getPotion == 2) {
                                System.out.println("Rare Drop Poison Potion! \uD83D\uDC9A ");
                                inventory.addInventory("poison Potion");
                            }
                        } else {
                            System.out.println("Incorrect!");
                            tries--;
                            System.out.println("Number of Tries: " + tries);
                            System.out.println("Enter the code number: ");
                            n = s.nextLine();

                            while (!r.check(m.getPlayerPosition(), n) && tries > 0) {
                                System.out.println("Incorrect!");
                                tries--;
                                System.out.println("Number of Tries: " + tries);
                                if (tries != 0) {
                                    System.out.println("Enter the code number: ");
                                    n = s.nextLine();
                                }
                            }

                            if (r.check(m.getPlayerPosition(), n)) {
                                System.out.println("Correct! You may keep going.");
                                p.updateHealthAttackRoom(m.getPlayerPosition());
                                // the player gets a potion if the random number is 1 or 2
                                int getPotion = (int) (Math.random() * (5 - 1 + 1)) + 1;

                                if (getPotion == 1) {
                                    System.out.println("Rare Drop a Healing Potion! \uD83D\uDC96 ");
                                    inventory.addInventory("healing Potion");
                                }
                                if (getPotion == 2) {
                                    System.out.println("Rare Drop Poison Potion! \uD83D\uDC9A ");
                                    inventory.addInventory("poison Potion");
                                }

                            } else {
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
                        System.out.println("Game Over: Your health points hit zero or is below zero.");
                        while (b.getHealthPoints() >= 0 && p.getHealth() >= 0) {
                            System.out.println("---------------");
                            System.out.println("Boss Stats:");

                            System.out.println("❤\uFE0F\u200D\uD83E\uDE79 Health points: " + b.getHealthPoints());
                            System.out.println("⚔\uFE0F Attack points: " + b.getAttackPoints());
                            System.out.println("---------------");
                            TimeUnit.SECONDS.sleep(1 / 2);
                            System.out.println("Player Stats: ");
                            System.out.println("❤\uFE0F\u200D\uD83E\uDE79 Health points: " + p.getHealth());
                            System.out.println("⚔\uFE0F Attack points: " + p.getAttack());
                            TimeUnit.SECONDS.sleep(1 / 2);
                            System.out.println("---------------");
                            System.out.println("Players Turn");

                            if (tick == true) {

                                System.out.println("Boss got poisoned");
                                b.getHit(1);
                                System.out.println("❤\uFE0F\u200D\uD83E\uDE79 Boss Health points: " + b.getHealthPoints());
                                System.out.println();

                            }
                            System.out.println("Type a(attack) or click enter if you don't want to attack: ");
                            System.out.println("Type u(use) to use an item from your inventory");
                            String a = s.nextLine();
                            if (a.equals("a")) {
                                b.getHit(p.getAttack());
                                System.out.println("❤\uFE0F\u200D\uD83E\uDE79 Boss Health points: " + b.getHealthPoints());
                            } else if (a.equals("u")) {
                                System.out.println(inventory.items());
                                if (inventory.items().equals("No Items!")) {
                                    System.out.println("You just lost a turn because you have no items \uD83D\uDE2D");
                                } else {
                                    System.out.println("Poison potion = Boss health ticks by one every player turn. \uD83D\uDC9A");
                                    System.out.println("Healing potion = Heal your own health by 5 points. \uD83D\uDC96 ");
                                    System.out.println("Enter your potion (don't add the word potion after): ");
                                    String u = s.nextLine();
                                    u = u.toLowerCase();
                                    inventory.useItem(u + " Potion");
                                    u = u + " Potion";

                                    if (u.equals("poison Potion")) {
                                        System.out.println("Poison Potion used! \uD83D\uDC9A ");
                                        tick = true;
                                        System.out.println(inventory.items());
                                    }

                                    if (u.equals("healing Potion")) {
                                        System.out.println("Healing Potion used! \uD83D\uDC9A");
                                        p.updateHealthPotion();
                                        System.out.println("❤\uFE0F\u200D\uD83E\uDE79 Player Health points: " + p.getHealth());
                                        TimeUnit.SECONDS.sleep(1 / 2);
                                        System.out.println(inventory.items());
                                    }
                                }

                            }
                            TimeUnit.SECONDS.sleep(1 / 2);

                            if (b.getHealthPoints() > 0) {
                                System.out.println("Boss Turn: ");
                                System.out.println("The boss attacks!");
                                TimeUnit.SECONDS.sleep(1);
                                p.getHit(b.getAttackPoints());
                                System.out.println("❤\uFE0F\u200D\uD83E\uDE79 Player Health points: " + p.getHealth());
                            }

                            TimeUnit.SECONDS.sleep(2);

                            if (p.getHealth() <= 0) {
                                System.out.println("Close one");
                                String RESET = "\u001B[0m";
                                String RED = "\u001B[31m";
                                System.out.println(RED + "GAME OVER" + RESET);
                                gameOver = true;
                            } else {
                                System.out.println();
                                System.out.println("---------");
                                System.out.println("You won!");
                                p.updateHealthAttackBoss(m.getPlayerPosition());

                            }
                            System.out.println("Player Stats: ");
                            System.out.println("❤\uFE0F\u200D\uD83E\uDE79 Health points: " + p.getHealth());
                            System.out.println("⚔\uFE0F Attack points: " + p.getAttack());

                        }

                        if (m.getPlayerPosition().substring(0, 1).equals("W")) {
                            System.out.println("You bumped into a wall!");
                            m.failedRoom("w");
                        }
                    }
                }

                    if (direction.equals("s")) {
                        System.out.println("-----------------");
                        System.out.println("Player Stats: ");
                        System.out.println("❤\uFE0F\u200D\uD83E\uDE79 Health points: " + p.getHealth());
                        System.out.println("⚔\uFE0F Attack points: " + p.getAttack());

                    }

                    // position on the map
                    if (direction.equals("p")) {
                        System.out.println(m.getPlayerPosition());
                    }

                    // Inventory
                    if (direction.equals("i")) {
                        System.out.println(inventory.items());
                    }

                    if (direction.equals("m")) {
                        System.out.println(m.mapInformation());
                        System.out.println("Key:");
                        System.out.println("S = Starting Position");
                        System.out.println("R = Riddle Room");
                        System.out.println("W = Wall");
                        System.out.println("B = Boss Fight");
                        System.out.println("Have fun! ");
                    }


                }


            }

        }
    }
