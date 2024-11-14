public class Boss {

  private int healthPoints = 0;
  private int attackPoints = 0;

  public Boss(){
    this.healthPoints =0;
    this.attackPoints = 0;
  }

  public void bossHealth(String n){
    // (int)( math.random() * max - min +1 ) + min
    // B1 health max = 12 min = 10
    // B1 attack max = 2 min = 1
    if (n.equals("B1")) {
      healthPoints = (int) (Math.random()*(12-10+1))+ 10;
      attackPoints = (int) (Math.random()* (2-1+1))+ 1;
    }
    // B2 health max = 15 min = 12
    // B2 attack max = 5 min = 3
    if (n.equals("B2")) {
      healthPoints = (int) (Math.random()*(15-12+1))+ 12;
      attackPoints = (int) (Math.random()* (5-3+1))+ 3;
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

  public int getHealthPoints(){
    return healthPoints;
  }

  public int getAttackPoints() {
    return attackPoints;
  }

  public void getHit(int attack){
    healthPoints -= attack;
  }

}
