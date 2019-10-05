package Project3;

import java.util.ArrayList;

/**
 * Creates the tea item with parameters/variables to be set 
 * @author Joseph
 * @since 3/19/19
 *
 */
public class TeaItem extends DrinkItem{

	private String size;
	private String flavor;
	private String sweetness;
	private String milk;
	private ArrayList<String> toppings = new ArrayList<String>();
	
	/**
	 * Default Constructor for the tea item
	 */
	public TeaItem() {
		size = "N/A";
		flavor = "N/A";
		sweetness = "N/A";
		milk = "N/A";
	}
	
	/**
	 * Overloaded Constructor for the tea item
	 * @param size - of the tea
	 * @param flavor - of the tea
	 * @param sweetness - of the tea
	 * @param milk -  of the tea
	 */
	public TeaItem(String size, String flavor, String sweetness, String milk) {
		this.size = size;
		this.flavor = flavor;
		this.sweetness = sweetness;
		this.milk = milk;
	}
	
	/**
	 * Adds toppings to the list of toppings
	 * @param top - topping to be added
	 */
	public void addTopping(String top) {
		toppings.add(top);
	}
	
	/**
	 * Calculates the cost of the tea item
	 * @return the cost 
	 */
	public double getCost() {
		double cost = 0.0;
		cost += getBasePrice(size);
		if(milk.equals("No Milk"))cost += 0;
		else cost += 0.25;
		cost += toppings.size() * .25;
		return cost;
	}
	
	/**
	 * Gets the base price based on the size of the drink
	 * @param size - of the drink
	 * @return the base price
	 */
	public static double getBasePrice(String size) {
		double basePrice = 0;
		switch(size) {
			case "Small":
				basePrice = 2.50;
				break;
			case "Medium":
				basePrice = 3.00;
				break;
			case "Large":
				basePrice = 3.50;
				break;
		}
		return basePrice;
	}
	
	/**
	 * Allows the tea item object to printed as a string
	 */
	public String toString() {
		String teaItem;
		String tops = "";
		for(String t : toppings) {
			tops += t + " | ";
		}
		if(tops.equals("")) { 
			teaItem = "\t\t--" + flavor + "(" + size + "):\t\t " + String.format("$%.2f%n",getCost()) 
							+ "\t\t\tSweetness: " + sweetness + "\n\t\t\tMilk: " + milk;
		}else {
			teaItem = "\t\t--" + flavor + "(" + size + "):\t\t " + String.format("$%.2f%n",getCost()) 
			+ "\t\t\tSweetness: " + sweetness + "\n\t\t\tMilk: " + milk + "\n\t\t\tToppings: " + tops;
		}
		return teaItem;
	}
}
