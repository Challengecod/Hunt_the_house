/**
 * The Player class represents the player. A player has health points and
 * attack points
 */

public class Player {
  private int healthPoints = 0;
  private int attackPoints = 0;

  /**
   * Constructor for the Player class. This creates a new instance of a
   * player with two health points and one attack points
   *
   */

  public Player(){
    this.healthPoints = 2;
    this.attackPoints = 1;
  }

  /**
   * getHealthPoints method for the Player class. This method will return
   * player health points.
   *
   * @return returns an Integer of the player health points.
   *
   */


  public int getHealth(){
    return healthPoints;
  }

  /**
   * getAttackPoints method for the Player class. This method will return
   * player attack points.
   *
   * @return returns an Integer of the player attack points.
   *
   */

  public int getAttack(){
    return attackPoints;
  }

  /**
   * updateHealthAttackRoom method for the Player class. This method will
   * update the player’s health and attack points randomly according to the room
   *
   * @param r represents the specific room number.
   *
   */

  public void updateHealthAttackRoom(String r){
    if(r.equals("R1")){
      healthPoints += 8;
      attackPoints += 3;

    }

    if(r.equals("R2")){

      healthPoints += 6;
      attackPoints += 5;

    }

    if(r.equals("R3")){

      healthPoints += 4;
      attackPoints += 1;

    }

    if(r.equals("R4")){
      healthPoints += 3;
      attackPoints += 2;
    }

    if(r.equals("R5")){
      healthPoints += 3;
      attackPoints += 1;
    }

  }

  /**
   * updateHealthAttackBoss method for the Player class. This method will
   * update the player’s health and attack points randomly according to the boss won
   *
   * @param b represents the specific Boss number.
   *
   */


  public void updateHealthAttackBoss(String b) {
    if (b.equals("B1")) {
      healthPoints += 10;
      attackPoints += 4;

    }

    if (b.equals("B2")) {

      healthPoints += 8;
      attackPoints += 4;

    }

    if (b.equals("B3")) {

      healthPoints += 12;
      attackPoints += 4;

    }
    if (b.equals("BF")) {

      healthPoints += 100;
      attackPoints += 100;

    }
  }

  /**
   * getHealthPotion method for the Player class. This method will update
   * players health points based on the use of the health potion
   *
   *
   */

  public void updateHealthPotion(){
    healthPoints += 5;
  }

  /**
   * getHit method for the Player class. This method will subtract
   * players health points based on the boss attack points.
   *
   * @param attack an integer representing the boss’s attack points
   *
   *
   */

  public void getHit(int attack){
    healthPoints -= attack;
  }

}
