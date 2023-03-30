/**
 * A class representing a cafe, which extends the building class. 
 */
public class Cafe extends Building {
    
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams; 
        this.nCups = nCups;
    }

    /** 
     *If the machine has more than the specified amount of coffee, sugar, and cream, and one cup, 
then the specified amount of coffee, sugar, and cream, and one cup is removed from the machine's inventory and one cup is sold.
If the Cafe does not have enough inventory, it attempts to restock and throws a RuntimeException if restocking fails.
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
            throw new RuntimeException("Don't have enough for a cup");
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

    public static void main(String[] args) {
        Cafe cafe = new Cafe("Name", "Address", 1, 0,0,0,0);
        cafe.sellCoffee(12, 4, 5);
    }
    
}
