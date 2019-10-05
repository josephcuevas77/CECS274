package JustinProject3;

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

    /**
     * Default Constructor
     */
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
            case("S"):
                price += 2.50;
                break;
            case("M"):
                price += 3.00;
                break;
            case("L"):
                price += 3.50;
                break;
        }
        price += Toppings.size() * 0.25;
        if(milkType != "No milk") price += 0.25;
        return price;
    }

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
