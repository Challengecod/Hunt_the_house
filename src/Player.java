public class Player {
  private int healthPoints = 0;
  private int attackPoints = 0;

  public Player(){
    this.healthPoints = 2;
    this.attackPoints = 1;
  }

  public int getHealth(){
    return healthPoints;
  }

  public int getAttack(){
    return attackPoints;
  }

  public void updateHealthAttackRoom(String r){
    if(r.equals("R1")){
      healthPoints += 5;
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
      healthPoints += 1;
      attackPoints += 1;
    }

  }

  public void updateHealthAttackBoss(String b) {
    if (b.equals("B1")) {
      healthPoints += 5;
      attackPoints += 4;

    }

    if (b.equals("B2")) {

      healthPoints += 5;
      attackPoints += 4;

    }

    if (b.equals("B3")) {

      healthPoints += 5;
      attackPoints += 4;

    }
    if (b.equals("BF")) {

      healthPoints += 100;
      attackPoints += 100;

    }
  }

  public void updateHealthPotion(){
    healthPoints += 5;
  }

  public void getHit(int attack){
    healthPoints -= attack;
  }

}
