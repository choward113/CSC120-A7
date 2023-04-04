/**
 * A class representing a cafe, which extends the building class. 
 */
public class Cafe extends Building {

    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory
  
    /*Default constructor */
    public Cafe() {
      this("<Name Unknown>", "<Address Unknown>", 1, 0, 0, 0, 0);
    }

    /*Constructor with only name and address*/
    public Cafe(String name, String address) {
      this(name, address, 1, 0, 0, 0, 0);
    }
  
    /* Full constructor */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
      super(name, address, nFloors);
      this.nCoffeeOunces = nCoffeeOunces;
      this.nSugarPackets = nSugarPackets;
      this.nCreams = nCreams;
      this.nCups = nCups;
    }
  
    /** 
     * Lets user get one cup of a standard coffee.
     */
    public void sellCoffee() {
      if (this.nCoffeeOunces >= (nCups * 8) && this.nSugarPackets >= (nCups * 2) && this.nCreams >= (nCups * 2) && this.nCups >= 1) {
        this.nCoffeeOunces -= (nCups * 8);
        this.nSugarPackets -= (nCups * 2);
        this.nCreams -= (nCups * 2);
        this.nCups -= 1;
      } else {
        restock((nCups * 8), (nCups * 2), (nCups * 2), 10);
        throw new RuntimeException("Don't have enough supply for your coffee.");
      }
    }

    /** 
     * Lets user get one customized coffee.
     * @param size The size of the drink in coffee ounces
     * @param nSugarPackets The number of sugar packets to be used
     * @param nCreams The number of nCreams to be used
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
      if (this.nCoffeeOunces >= size && this.nSugarPackets >= nSugarPackets && this.nCreams >= nCreams && this.nCups >= 1) {
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;
      } else {
        restock(size, nSugarPackets, nCreams, 10);
        throw new RuntimeException("Don't have enough supply for your coffee.");
      }
    }
  
    /** 
     * Sells a standard coffee with a custom size.
     * @param size The size of the drink in coffee ounces
     */
    public void sellCoffee(int size) {
      if (this.nCoffeeOunces >= (size) && this.nSugarPackets >= 2 && this.nCreams >= 2 && (this.nCups - 1) >= 0) {
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= 2;
        this.nCreams -= 2;
        this.nCups -= 1;
      } else {
        restock(size, nSugarPackets, nCreams, 10);
        throw new RuntimeException("Don't have enough supply for your coffee.");
      }
    }
  
    /**
     * Restocks with the specified number of coffee ounces, sugar packets, creams, and cups.
     * @param nCoffeeOunces The number of coffee ounces that will be added to the inventory
     * @param nSugarPackets The number of sugar packets that will be added to the inventory
     * @param nCreams The number of creams that will be added to the inventory
     * @param nCups The number of cups that will be added to the inventory
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
      this.nCoffeeOunces += nCoffeeOunces;
      this.nSugarPackets += nSugarPackets;
      this.nCreams += nCreams;
      this.nCups += nCups;
    }
  
    /**
     * Method that stops user from moving floors.
     */
    public void goToFloor(int floorNum) {
      throw new RuntimeException("Cannot move floors. The cafe only has one floor.");
    }
  
    /**
     * Prints out options for the cafe. 
     */
    public void showOptions() {
      System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + sellCoffee()");
    }
  
  }