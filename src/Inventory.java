import java.util.ArrayList;

public class Inventory {
  private ArrayList<String> inventory = new ArrayList<>();

  public Inventory(){
  }

  public void addInventory(String potion){
    inventory.add(potion);
  }

  public String items(){
    String s = "Your items: ";
    if (inventory.isEmpty()){
      return "No Items yet!";
    }
    for(int i =0; i < inventory.size(); i++){
      s += inventory.get(i)+" ";
    }
    return s;
  }

  public void useItem(String potion){
    inventory.remove(potion);

  }
}
