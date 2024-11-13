public class Boss {

  private int healthPoints = 0;
  private int attackPoints = 0;

  public Boss(){
    this.healthPoints =0;
    this.attackPoints = 0;
  }

  public void bossHealth(String n){
    // (int)( math.random() * max - min +1 ) + min
    if (n.equals("B1")) {
      healthPoints = (int) (Math.random()*(12-10+1))+ 10;
      attackPoints = (int) (Math.random()* (2-1+1))+ 1;
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
