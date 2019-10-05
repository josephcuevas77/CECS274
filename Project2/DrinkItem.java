package Project2;

import java.util.ArrayList;

/**
 * Abstract Parent Class Drink Item which has extensions of BobaDrink and CoffeeDrink
 * @author Joseph
 *
 */
public abstract class DrinkItem {

	private String drinkName;
	private String drinkSweetness;
	private String drinkSize;
	private double price;
	private static  String[] sizeMenu = {"Small", "Medium", "Large"};
	
	/**
	 * Default constructor for drink item
	 * Contains null info for name, sweetness, and size
	 */
	public DrinkItem(){
		price = -1;
		drinkName = "N/A";
		drinkSweetness = "N/A";
		drinkSize = "N/A";
	}
	
	/**
	 * Overloaded Constructor for Drink Item
	 * @param price - set to -1
	 * @param name - type of drink
	 * @param sweetness - level of sweetness
	 * @param size
	 */
	public DrinkItem(String name, String sweetness, String size) {
		price = -1;
		drinkName = name;
		drinkSweetness = sweetness;
		drinkSize = size;
	}
	
	/**
	 * sets Price of drink
	 * @param p - price 
	 */
	public void setPrice(double p) {
		price = p;
	}
	
	/**
	 * Returns the price of the drink
	 * @return price
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * Sets the drink name for the drink Object
	 * @param newName - the new name to replace the default or previous name of Drink Object
	 */
	public void setName(String newName) {
		drinkName = newName;
	}
	
	/**
	 * Getter for the name of the Drink Object
	 * @return drink name
	 */
	public String getName() {
		return drinkName;
	}
	
	/**
	 * Sets the sweetness level for the Drink Object
	 * @param sweetness - sweetness level to be set
	 */
	public void setSweetness(String sweetness) {
		drinkSweetness = sweetness;
	}
	
	/**
	 * Getter for Drink sweetness
	 * @return sweetness of drink
	 */
	public String getSweetness() {
		return drinkSweetness;
	}
	
	/**
	 * Setter for drink size: sets the size of the drink
	 * @param size - size of drink
	 */
	public void setSize(String size) {
		drinkSize = size;
	}
	
	/**
	 * retrieves the menu of possible sizes to be chosen from for the user
	 * @return size menu
	 */
	public static  String[] getSizeMenu() {
		return sizeMenu;
	}
	
	/**
	 * Converts the size intake that is set for Drink and converts to price based on Size
	 * @return price of drink based on size
	 */
	public double getSize() {
		if(drinkSize.equals("Large") || drinkSize.equals("large")) {
			return 4.00;
		}else if(drinkSize.equals("Medium") || drinkSize.equals("medium")) {
			return 3.50;
		}else if(drinkSize.equals("Small") || drinkSize.equals("Small")) {
			return 3.00;
		}else return 0;
	}
	
	/**
	 * Enables printing out of Drink Item
	 */
	public String toString() {
		String drinkInfo = "Name: " + drinkName + ", Sweetness: " + drinkSweetness + ", Size:  " + drinkSize;
		return drinkInfo;
	}
	
	/**
	 * Applies coupon to Drink object
	 * @param coupon - coupon to get discount from
	 * @return price
	 */
	public double applyCoupon(Coupon coupon) { 
		setPrice(getCost() * (1 - coupon.getDiscount())); 
		return getPrice();
	}
	
	/**
	 * Abstract class to be used by both the BobaDrink and CoffeeDrink classes to have their own abstract way
	 * of calculating cost
	 * @return cost of Drink
	 */
	public abstract double getCost();
	
	/**
	 * Class to handle all BobaDrink object methods and items
	 * extends the DrinkItem Parent Class as its own child class
	 * @author Joseph
	 *
	 */
	public static class BobaDrink extends DrinkItem {
		
		private  String[] sweetnessMenu = {"Full","3/4 Sweet","1/2 Sweet","1/4 Sweet","Unsweetened"};
		private  String[] toppingsMenu = {"Boba", "Popping Boba", "Grass Jelly", "Lychee Jelly", "Coconut Jelly", "Mini Mochi","Done"};
		private  String[] milksMenu = {"Whole Milk","Half-And-Half","Almond Milk","Coconut Milk","No Milk"};
		private  String[] baseTeasMenu = {"Green tea", "Black tea","Jasmine Green Tea","Rose Tea","Oolong Tea"};
		
		private String baseTea;
		private String milk;
		private ArrayList<String> toppingList = new ArrayList<String>();
		
		/**
		 * Default constructor for BobaDrink
		 */
		public BobaDrink() {
			baseTea = "N/A";
			milk = "N/A";
			toppingList = new ArrayList<String>();
		}
		
		/**
		 * Overloaded constructor for BobaDrink
		 * @param sweet - sweetness to be set
		 * @param size - size of BobaDrink
		 * @param tops - arraylist of toppings for drink
		 */
		public BobaDrink(String baseTea, String sweet,String size,String milkC,ArrayList<String> tops) {
			super(baseTea, sweet, size);
			milk = milkC;
			toppingList = tops;
		}
		
		/**
		 * Retrieves sweetness menu
		 * @return sweetness menu
		 */
		public  String[] getSweetnessMenu() {
			return sweetnessMenu;
		}
		
		/**
		 * Retrieves the Toppings menu for user viewing
		 * @return toppings menu
		 */
		public  String[] getToppingsMenu() {
			return toppingsMenu;
		}
		
		/**
		 * Retrieves the milk options for the BobaDrink
		 * @return milk menu
		 */
		public  String[] getMilksMenu() {
			return milksMenu;
		}
		
		/**
		 * Retrieves the base tea options for the BobaDrink
		 * @return base tea menu
		 */
		public  String[] getBaseTeasMenu() {
			return baseTeasMenu;
		}
		
		/**
		 * Retrieves list of toppings in BobaDrink based on user input 
		 * @return topping list
		 */
		public ArrayList<String> getToppingList() {
			return toppingList;
		}
		
		/**
		 * BobaDrink abstract method to calculate cost in its own way
		 */
		public double getCost() {
			if(super.getPrice() != -1
					&& super.getPrice() != getSize() + (toppingList.size() * .5))
				return super.getPrice();
			super.setPrice(getSize() + (toppingList.size() * .5));
			return super.getPrice();
		}
		
		/**
		 * Sets the base tea for the Boba Drink
		 * @param tea - base tea for Boba
		 */
		public void setBaseTea(String tea) {
			baseTea = tea;
		}
		
		/**
		 * Sets the milk for the BobaDrink
		 * @param milkC - milk choice from user
		 */
		public void setMilk(String milkC) {
			milk = milkC;
		}
		
		/**
		 * Adds topping to topping list as they are inputted by user
		 * @param top - topping to be added
		 */
		public  void addTopping(String top) {
			toppingList.add(top);
		}
		
		/**
		 * Clears list of toppings so that a new one may be created
		 */
		public  void resetToppings() {
			toppingList = new ArrayList<String>();
		}
		
		/**
		 * Allows the BobaDrink object to be printed out as its own String
		 */
		public String toString() {
			String tops = "";
			for(String t : toppingList) {
				tops += t + ", ";
			}
			String boba = "===BOBA===\nBase Tea: " + baseTea + "\nSweetness: " + super.drinkSweetness + "\nMilk: " + milk + "\nSize: " + super.drinkSize
					+ "\nToppings: " + tops + "\nPrice: $" + String.format("%.2f%n",getCost());
			return boba;
		}
	}
	
	/**
	 * Class to handle all CoffeeDrink object methods and items
	 * extends the DrinkItem Parent Class as its own child class
	 * @author Joseph
	 *
	 */
	public static class CoffeeDrink extends DrinkItem {
		
		private  String[] bases = {"Water","Whole Milk","Almond Milk"};
		private String base;
		private int numOfTsp;
		
		/**
		 * Default constructor for CoffeeDrink object
		 */
		public CoffeeDrink() {
			base = "N/A";
			numOfTsp = 0;
		}
		
		/**
		 * Overloaded constructor for the CoffeeDrink object
		 * @param size - size of Coffee
		 * @param newBase - base of Coffee
		 * @param Tsp - number of Teaspoons of Sugar added
		 */
		public CoffeeDrink(String size, String newBase,int Tsp) {
			super(newBase,Integer.toString(Tsp),size);
			base = newBase;
			numOfTsp = Tsp;
		}
		
		/**
		 * Retrieves the menu of bases 
		 * @return bases menu
		 */
		public  String[] getBases() {
			return bases;
		}
		
		/**
		 * Sets the base of the CoffeeDrink Item
		 * @param newBase - base of Coffee
		 */
		public void setBase(String newBase) {
			base = newBase;
		}
		
		/**
		 * Sets the amount of Tsp of sugar to be added to the coffee
		 * @param numTsp - # of Tsp of Sugar
		 */
		public void setNumTsp(int numTsp) {
			numOfTsp = numTsp;
		}
		
		/**
		 * CoffeeDrink abstract method to calculate cost in its own way
		 */
		public double getCost() {
			if(super.getPrice() != -1
					&& super.getPrice() != getSize())
				return super.getPrice();
			super.setPrice(getSize());
			return super.getPrice();
		}
		
		/**
		 * Allows the CoffeeDrink Object to be printed as its own String
		 */
		public String toString() {
			String CoffeeInfo = "===COFFEE===\nSize: " + super.drinkSize + "\nBase: " + base + "\nNum of Teaspoons: " + numOfTsp 
					+ "\nPrice: $" + String.format("%.2f%n",getCost()); 
			return CoffeeInfo;
		}
	}
}
