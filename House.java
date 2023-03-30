import java.util.ArrayList;

/**
 * A class representing a house which extends the building class. 
 */
public class House extends Building {

  private ArrayList<String> residents;
  private boolean hasDiningRoom;

  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = hasDiningRoom;
  }

  /**
   * Returns a string representing the house, including the number of residents and whether or not it has a dining room.
   * @return Returns a string representation of the house
   */
  public String toString(){
    String description = super.toString();
    description += ". This house currently has " + this.residents.size() + " residents.";
    description += " It ";
    if (this.hasDiningRoom){
      description += "has";
    } else {
      description += "does not have";
    }
    description += " a dining room.";
    return description;
  }

  /**
   * Accessor for residents.
   * @return Return an arraylist of the residents of the house
   */
  public ArrayList getResidents(){
    return this.residents;
  }

  /**
   * Accessor for hasDiningRoom
   * @return Returns true if the house has a dining room, otherwise returns false
   */
  public boolean getHasDiningRoom(){
    return hasDiningRoom;
  }

  /**
   * Moves in a resident with a given name.
   * @param name The name of the resident that is moving in
   */
  public void moveIn(String name){
    if (!isResident(name)){
      System.out.println("Added "+ name + " to " + this.getName());
      this.residents.add(name);
    } else {
      System.out.println(name + " is already in "+ this.getName());
    }
  }

  /**
   * Moves out a resident with a given name. 
   * @param name The name of the resident that is moving out
   * @return Returns the name of the resident
   */
  public String moveOut(String name){
    if (isResident(name)){
      this.residents.remove(name);
    } else {
      System.out.println(name + " is not in "+ this.getName());
    }
    return name;
  }

  /**
   * Returns whether or not the given person is a resident.
   * @param person The person to search for
   * @return True if the person is a resident, false otherwise
   */
  public boolean isResident(String person){
    return this.residents.contains(person);
  }

  public static void main(String[] args) {
    House ziskind = new House("Ziskind", "1 Henshaw Ave", 3, true);
    House capen = new House("Capen", "26 prospect st", 3, false);
  }

}