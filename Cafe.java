/**
 * A class representing a cafe, which extends the building class. 
 */
public class Cafe extends Building {
    
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    /*Default constructor */
    public Cafe(){
        this("<Name Unknown>", "<Address Unknown>", 1, 0, 0,0,0);
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
     *If the cafe has more than the specified amount of coffee, sugar, and cream, and more than one cup, 
      then the specified amounts are removed from the cafe's inventory. 
      If the Cafe does not have enough inventory, it attempts to restock and throws a RuntimeException.
     * @param size The size of the drink in coffee ounces
     * @param nSugarPackets The number of sugar packets to be used
     * @param nCreams The number of nCreams to be used
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        if (this.nCoffeeOunces >= size && this.nSugarPackets >= nSugarPackets && this.nCreams >= nCreams && this.nCups >= 1){
            this.nCoffeeOunces -= size;
            this.nSugarPackets -= nSugarPackets;
            this.nCreams -= nCreams;
            this.nCups -= 1;
        }else{
            restock(size, nSugarPackets, nCreams, 10);
            throw new RuntimeException("Don't have enough supply for your coffee.");
        }
    }

    /** 
     *If the cafe has more than the specified amount of coffee, sugar, and cream, and cups, 
      then the specified amounts multiplied by the number of cups are removed from the cafe's inventory.
      If the Cafe does not have enough inventory, it attempts to restock and throws a RuntimeException.
     * @param size The size of the drink in coffee ounces
     * @param nSugarPackets The number of sugar packets to be used
     * @param nCreams The number of nCreams to be used
     * @param nCups The number of cups being used.
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams, int nCups){
        if (this.nCoffeeOunces >= (nCups*size) && this.nSugarPackets >= (2*nSugarPackets) && this.nCreams >= (2*nCreams) && (this.nCups - nCups) >= 0){
            this.nCoffeeOunces -= (nCups*size);
            this.nSugarPackets -= (nCups*nSugarPackets);
            this.nCreams -= (nCups*nCreams);
            this.nCups -= nCups;
        } else {
            restock(size, nSugarPackets, nCreams, 10);
            throw new RuntimeException("Don't have enough supply for your coffee(s).");
        }
    }

    /** 
     *If the cafe has more than the specified amount of coffee, sugar, and cream, and more than one cup, 
      then the specified amounts are removed from the cafe's inventory. 
      If the Cafe does not have enough inventory, it attempts to restock and throws a RuntimeException.
     * @param nCups
     */
    public void sellCoffee(int nCups){
        if (this.nCoffeeOunces >= (nCups*8) && this.nSugarPackets >= (nCups*2) && this.nCreams >= (nCups*2) && this.nCups >= nCups){
            this.nCoffeeOunces -= (nCups*8);
            this.nSugarPackets -= (nCups*2);
            this.nCreams -= (nCups*2);
            this.nCups -= nCups;
        } else {
            restock((nCups*8), (nCups*2), (nCups*2), 10);
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
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }

    /**
     * Method that stops user from moving floors.
     */
    public void goToFloor(int floorNum){
        throw new RuntimeException("Cannot move floors. The cafe only has one floor.");
    }

    /**
     * Prints out options for the cafe. 
     */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + sellCoffee(coffee size, sugar packets, creams)");
    }
    
}
