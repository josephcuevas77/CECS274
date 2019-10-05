package JustinProject3;

/**
 * COFFEEDRINK ITEM
 * CoffeeDrink extends DrinkItem
 * Contains price and base
 * Contains String[] for menu options
 */
public class CoffeeDrink extends DrinkItem {
    private double price;
    private String flavor;
    private String milk;
    private String type;
    private String specialInstructions = "N/A";

    public CoffeeDrink() {
        super("Coffee", "N/A", "N/A");
        flavor = "N/A";
        price = -1;
    }

    /**
     * Overloaded Constructor
     * @param name
     * @param sugarSpoons
     * @param size
     * @param milk
     */
    public CoffeeDrink(String name, String sugarSpoons, String size, String milk, String type) {
        super("Coffee", sugarSpoons, size);
        this.flavor = name;
        this.milk = milk;
        this.type = type;
    }

    /**
     * Getter method for cost
     * @return price
     */
    public double getCost() {
        price = 0;
        switch (super.getSize()) {
            case("S"):
                price += 1.00;
                break;
            case("M"):
                price += 1.50;
                break;
            case("L"):
                price += 2.00;
                break;
        }
        if(type.equals("Blended")) price += 0.25;
        return price;
    }

    public void setSpecialInstructions(String s) {specialInstructions = s;}

    /**
     * toString method
     * @return String: Drink name \nPrice \nBase \nSugar
     */
    public String toString() {
        return super.toString() + "Size: " + getSize() + "\nFlavor: " + flavor + "\nMilk: " + milk + "\nSugar: " + super.getSweetness() + "\nSpecial Instructions: " + specialInstructions + "\n\n" ;
    }
}

