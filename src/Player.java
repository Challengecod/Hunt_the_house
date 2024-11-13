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
//
//    if(r.equals("R3")){
//
//    }
//
//    if(r.equals("R4")){
//
//    }
  }

  public void updateHealthAttackBoss(String b) {
    if (b.equals("B1")) {
      healthPoints += 9;
      attackPoints += 5;

    }

    if (b.equals("B2")) {

      healthPoints += 9;
      attackPoints += 6;

    }
  }

  public void getHit(int attack){
    healthPoints -= attack;
  }

}
