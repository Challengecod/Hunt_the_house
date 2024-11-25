/**
 * The Boss class represents a Boss. A Boss has health points and
 * attack points
 */

public class Boss {

  private int healthPoints = 0;
  private int attackPoints = 0;

  /**
   * Constructor for the Boss class. This creates a new instance of a boss
   * with zero health points and zero attack points
   *
   */

  public Boss(){
    this.healthPoints =0;
    this.attackPoints = 0;
  }

  /**
   * bossHealth method for the Boss class. This method will update the
   * boss health and attack points randomly according to the Boss number.
   * sentence.
   *
   * @param n represents the specific Boss number.
   *
   */

  public void bossHealth(String n){
    // (int)( math.random() * max - min +1 ) + min
    // B1 health max = 10 min = 7
    // B1 attack max = 2 min = 1
    if (n.equals("B1")) {
      healthPoints = (int) (Math.random()*(10-7+1))+ 7;
      attackPoints = (int) (Math.random()* (2-1+1))+ 1;
    }
    // B2 health max = 15 min = 12
    // B2 attack max = 4 min = 2
    if (n.equals("B2")) {
      healthPoints = (int) (Math.random()*(15-12+1))+ 12;
      attackPoints = (int) (Math.random()* (4-2+1))+ 3;
    }
    // B3 health max = 20 min = 15
    // B3 attack max = 8 min = 5
    if (n.equals("B3")) {
      healthPoints = (int) (Math.random()*(20 - 15 + 1))+ 15;
      attackPoints = (int) (Math.random()* (8-5+1))+ 5;
    }
    // BF health max = 30 min = 25
    // BF attack max = 12 min = 10
    if (n.equals("BF")) {
      healthPoints = (int) (Math.random()*(30-25+1))+ 25;
      attackPoints = (int) (Math.random()* (12-10+1))+ 10;
    }
  }

  /**
   * getHealthPoints method for the Boss class. This method will return
   * boss health points.
   *
   * @return returns an Integer of the Boss health points.
   *
   */

  public int getHealthPoints(){
    return healthPoints;
  }
  /**
   * getAttackPoints method for the Boss class. This method will return
   * boss attack points.
   *
   * @return returns an Integer of the Boss attack points.
   *
   */

  public int getAttackPoints() {
    return attackPoints;
  }

  /**
   * getHit method for the Boss class. This method will subtract
   * boss health points based on the players attack points.
   *
   * @param attack an integer representing the player’s attack points
   *
   *
   */

  public void getHit(int attack){
    healthPoints -= attack;
  }

}
