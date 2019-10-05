package Project2Point0;

/**
 * COFFEEDRINK ITEM
 * CoffeeDrink extends DrinkItem
 * Contains price and base
 * Contains String[] for menu options
 */
public class CoffeeDrink extends DrinkItem {
    private double price;
    private String base;

    private static String[] SizeOptions = {"Size", "Small", "Medium", "Large"};
    private static String[] BaseOptions = {"Base", "Water", "Whole Milk", "Almond Milk", "Coconut Milk"};
    private static String[] SweetnessOptions = {"No sugar", "1 tsp", "2 tsps", "3 tsps", "4 tsps", "5 tsps"};

    public CoffeeDrink() {
        super("Coffee", "N/A", "N/A");
        base = "N/A";
        price = -1;
    }

    /**
     * Overloaded Constructor
     * @param name
     * @param sugarSpoons
     * @param size
     * @param base
     */
    public CoffeeDrink(String name, String sugarSpoons, String size, String base) {
        super(name, sugarSpoons, size);
        this.base = base;
    }

    /**
     * Getter method for cost
     * @return price
     */
    public double getCost() {
        price = 0;
        switch (super.getSize()) {
            case("Small"):
                price += 3.50;
                break;
            case("Medium"):
                price += 4.00;
                break;
            case("Large"):
                price += 4.50;
                break;
        }
        return price;
    }

    /**
     * Getter method for SizeOptions
     * @return SizeOptions
     */
    public static String[] getSizeOptions() {return SizeOptions;}
    /**
     * Getter method for BaseOptions
     * @return BaseOptions
     */
    public static String[] getBaseOptions() {return BaseOptions;}
    /**
     * Getter method for SweetnessOptions
     * @return SweetnessOptions
     */
    public static String[] getSweetnessOptions() {return SweetnessOptions;}

    /**
     * compareTo method
     * @param drink
     * @return if this is larger, 1; if less, -1;  if equal, 0
     */
    public int compareTo(DrinkItem drink) {
        if(getCost() > drink.getCost()) return 1;
        else if(getCost() == drink.getCost()) return 0;
        else return -1;
    }

    /**
     * toString method
     * @return String: Drink name \nPrice \nBase \nSugar
     */
    public String toString() {
        return super.toString() + "Base: " + base + "\nSugar: " + super.getSweetness() + "\n\n" ;
    }
}

