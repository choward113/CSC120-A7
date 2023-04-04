import java.util.ArrayList;

/**
 * A class representing a house which extends the building class. 
 */
public class House extends Building {

  private ArrayList < String > residents;
  private boolean hasDiningRoom;
  private boolean hasElevator;

  /*Default constructor */
  public House() {
    this("<Name Unknown>", "<Address Unknown>", 1, false, false);
  }

  /* Full constructor */
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, nFloors);
    this.residents = new ArrayList < String > ();
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
  }

  /**
   * Returns a string representing the house, including the number of residents and whether or not it has a dining room.
   * @return Returns a string representation of the house
   */
  public String toString() {
    String description = super.toString();
    description += " This house currently has " + this.residents.size() + " residents.";
    description += " It ";
    if (this.hasDiningRoom) {
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
  public ArrayList getResidents() {
    return this.residents;
  }

  /**
   * Accessor for hasDiningRoom
   * @return Returns true if the house has a dining room, otherwise returns false
   */
  public boolean getHasDiningRoom() {
    return hasDiningRoom;
  }

  /**
   * Moves in a resident with a given name.
   * @param name The name of the resident that is moving in
   */
  public void moveIn(String name) {
    if (!isResident(name)) {
      System.out.println("Added " + name + " to " + this.getName());
      this.residents.add(name);
    } else {
      System.out.println(name + " is already in " + this.getName());
    }
  }

  /**
   * Moves in a resident with a given name and room type.
   * @param name The name of the resident that is moving in
   * @param roomNum The number of the room that the resident is moving into.
   */
  public void moveIn(String name, int roomNum) {
    if (!isResident(name)) {
      System.out.println("Added " + name + " to room " + roomNum + " in " + this.getName() + ".");
      this.residents.add(name);
    } else {
      System.out.println(name + " is already in " + this.getName());
    }
  }

  /**
   * Moves in a resident with a given name, room type, and year.
   * @param name The name of the resident that is moving in.
   * @param roomNum The number of the room that the resident is moving into.
   * @param floorNum The floor that the resident is moving onto.
   */
  public void moveIn(String name, int roomNum, int floorNum) {
    if (!isResident(name)) {
      System.out.println("Added " + name + " to room " + roomNum + " on " + floorNum + " in " + this.getName() + ".");
      this.residents.add(name);
    } else {
      System.out.println(name + " is already in " + this.getName());
    }
  }

  /**
   * Moves out a resident with a given name. 
   * @param name The name of the resident that is moving out
   * @return Returns the name of the resident
   */
  public String moveOut(String name) {
    if (isResident(name)) {
      this.residents.remove(name);
    } else {
      System.out.println(name + " is not in " + this.getName());
    }
    return name;
  }

  /**
   * Returns whether or not the given person is a resident.
   * @param person The person to search for
   * @return True if the person is a resident, false otherwise
   */
  public boolean isResident(String person) {
    return this.residents.contains(person);
  }

  /**
   * Allows user to move floors if in the building.
   * @param floorNum The floor to go to. 
   * @throws RuntimeException If the user is not in the building.
   * @throws RuntimeException If the floor is not within the range of the building.
   * @throws RuntimeException If the floor is not adjacent and the building does not have an elevator.
   */
  public void goToFloor(int floorNum) {
    if (this.activeFloor == -1) {
      throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
    }
    if (floorNum < 1 || floorNum > this.nFloors) {
      throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors + ".");
    }
    if ((this.activeFloor - 1) > floorNum || (this.activeFloor + 1) < floorNum && !this.hasElevator) {
      throw new RuntimeException("Cannot move to non-adjacent floor without an elevator.");
    }
    System.out.println("You are now on floor #" + floorNum + " of " + this.name);
    this.activeFloor = floorNum;
  }

  /**
   * Prints out options for House. 
   */
  public void showOptions() {
    super.showOptions();
    System.out.print(" + moveIn() \n + moveOut()");
  }

}