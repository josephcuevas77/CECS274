package Project2Point0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * BOBADRINK CLASS
 * BobaDrink extends DrinkItem
 * Contains a list of Toppings, a price, and a miltype
 * Contains String[]'s for menu options
 * Contains ArrayList<String> for Toppings
 * @author Justin Mabutas 2/21/2019
 */
public class BobaDrink extends DrinkItem {
    private List<String> Toppings;
    private double price;
    private String milkType;

    private static String[] SizeOptions = {"Size", "Small", "Medium", "Large"};
    private static String[] BaseTeaOptions = {"Base Tea", "Green Tea", "Black Tea", "Jasmine Green Tea", "Rose Tea", "Oolong Tea"};
    private static String[] SweetnessOptions = {"Sweetness", "Unsweetened", "1/4 Sweet", "1/2 Sweet", "3/4 Sweet", "Full Sweet"};
    private static String[] MilkOptions = {"Milk", "Whole milk", "Half-and-half", "Almond milk", "Coconut milk", "No milk"};
    private static ArrayList<String> ToppingOptions = new ArrayList<String>(Arrays.asList("Boba", "Popping boba", "Grass jelly", "Lychee jelly", "Coconut jelly", "Mini mochi"));

    public BobaDrink() {
        super("Boba", "N/A", "N/A");
        milkType = "N/A";
        price = -1;
    }

    /**
     * Overloaded Constructor
     * @param name
     * @param sweetness
     * @param size
     */
    public BobaDrink(String name, String sweetness, String size) {
        super(name, sweetness, size);

        Toppings = new ArrayList<String>();
    }

    /**
     * Getter method for cost
     * @return price
     */
    public double getCost() {
        price = 0;
        switch (super.getSize()) {
            case("Small"):
                price += 4.50;
                break;
            case("Medium"):
                price += 5.00;
                break;
            case("Large"):
                price += 5.50;
                break;
        }
        price += Toppings.size() * 0.50;
        return price;
    }

    /**
     * Getter method for SizeOptions
     * @return SizeOptions
     */
    public static String[] getSizeOptions() {return SizeOptions;}
    /**
     * Getter method for BaseTeaOptions
     * @return BaseTeaOptions
     */
    public static String[] getBaseTeaOptions() {return BaseTeaOptions;}
    /**
     * Getter method for SweetnessOptions
     * @return SweetnessOptions
     */
    public static String[] getSweetnessOptions() {return SweetnessOptions;}
    /**
     * Getter method for MilkOptions
     * @return MilkOptions
     */
    public static String[] getMilkOptions() {return MilkOptions;}
    /**
     * Getter method for ToppingOptions
     * @return ToppingOptions
     */
    public static ArrayList<String> getToppingOptions() {return ToppingOptions;}

    /**
     * Getter method for milkType
     * @return milkType
     */
    public String getMilk() {return milkType;}

    /**
     * addTopping method
     * adds topping to Toppings if it's not contained yet
     * @param topping
     * @return
     */
    public Boolean addTopping(String topping) {
        if(!Toppings.contains(topping)) {
            Toppings.add(topping);
            return true;
        }
        return false;
    }

    /**
     * Setter method for milk
     * @param milk
     */
    public void addMilk(String milk) {
        milkType = milk;
    }

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
     * @return String: Drink name\n \nPrice \nMilk \nToppings
     */
    public String toString() {
        String toperino = "Toppings: ";
        if(Toppings.size() == 0) toperino += "None";
        else {
            toperino += "\n";
            for(int i = 0; i < Toppings.size(); i++) {
                toperino += Toppings.get(i);
                if(i != Toppings.size()-1) toperino+= "\n";
            }
        }
        return super.toString() + "Milk: " + milkType + "\n" + toperino + "\n\n";
    }
}
