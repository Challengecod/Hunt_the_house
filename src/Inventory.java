import java.util.ArrayList;

/**
 * The Inventory class represents the Inventory. A inventory is a list with
 * items
 */

public class Inventory {
  private ArrayList<String> inventory = new ArrayList<>();

  /**
   * Constructor for the Inventory class. This creates a new instance of a
   * Inventory given there is no variables to initialize
   */

  public Inventory(){
  }

  /**
   * addInventory method for the Inventory class. This method will update
   * inventory adding potions
   *
   * @param potion represents the specific potion.
   */

  public void addInventory(String potion){
    inventory.add(potion);
  }

  /**
   * item method for the Inventory class. This method will list out the
   * elements in the list.
   *
   * @return returns a String of the items in the inventory list
   */


  public String items(){
    String s = "Your items: ";
    if (inventory.isEmpty()){
      return "No Items!";
    }
    for(int i =0; i < inventory.size(); i++){
      s += inventory.get(i)+" ";
    }
    return s;
  }

  /**
   * useItem method for the Inventory class. This method remove a specific
   * potion once from the list
   *
   * @param potion represents the potion needed to be removed.
   */

  public void useItem(String potion){
    inventory.remove(potion);

  }
}
