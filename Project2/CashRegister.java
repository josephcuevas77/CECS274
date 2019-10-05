package Project2;

import java.util.ArrayList;

public class CashRegister {

	private ArrayList<DrinkItem> Drinks;
	private ArrayList<DessertItem> Desserts;
	private  ArrayList<Object> allSales;
	private final  double SALES_TAX = .10;
	
	/**
	 * Default Constructor for Cash Register
	 */
	public CashRegister() {
		Drinks = new ArrayList<DrinkItem>();
		Desserts = new ArrayList<DessertItem>();
		allSales = new ArrayList<Object>();
	}
	
	/**
	 * method to clear the Cash Register and its contents
	 */
	public void clearCR() {
		Drinks.clear();
		Desserts.clear();
	}
	
	/**
	 * Retrieves the number of items in total from both lists of items
	 * @return number of items
	 */
	public int getNumItems() {
		return Drinks.size() + Desserts.size();
	}
	
	/**
	 * Retrieves the amount of Drink items
	 * @return number of drink items
	 */
	public int getNumDrinks() {
		return Drinks.size();
	}
	
	/**
	 * Retrieves the amount of Dessert Items
	 * @return number of dessert items
	 */
	public int getNumDesserts() {
		return Desserts.size();
	}
	
	/**
	 * Adds drink to drinks and sales list
	 * @param drink - Drink object to be added
	 */
	public void addDrink(DrinkItem drink) {
		Drinks.add(drink);
		allSales.add(drink);
	}
	
	/**
	 * Adds dessert to drinks and sales list
	 * @param dessert - Dessert object to be added
	 */
	public void addDessert(DessertItem dessert) {
		Desserts.add(dessert);
		allSales.add(dessert);
	}
	
	/**
	 * Adds Object to ArrayList
	 * @param o - object to be added
	 */
	public void addObject(Object o) {
		allSales.add(o);
	}
	
	/**
	 * Retrieves the drink list
	 * @return Drink List
	 */
	public ArrayList<DrinkItem> getDrinkList(){
		return Drinks;
	}
	
	/**
	 * Retrieves the Dessert List
	 * @return Dessert List
	 */
	public ArrayList<DessertItem> getDessertList(){
		return Desserts;
	}
	
	/**
	 * Calculates and returns subtotal for all Desserts
	 * @return drinks subtotal
	 */
	public  double getDrinksSub() {
		double sub = 0.0;
		for(DrinkItem d : Drinks) {
			sub += d.getCost();
		}
		return sub;
	}
	
	/**
	 * Calculates and returns subtotal for all Desserts
	 * @return dessert subtotal
	 */
	public  double getDessertsSub() {
		double sub = 0.0;
		for(DessertItem d: Desserts) {
			sub += d.getCost();
		}
		return sub;
	}
	
	/**
	 * Calculates the Subtotal of all the items in the Sale
	 * @return subtotal
	 */
	public double subTotal() {
		double sub = 0.0;
		for(DrinkItem d : Drinks) {
			sub += d.getCost();
		}
		for(DessertItem d: Desserts) {
			sub += d.getCost();
		}
		
		return sub;
	}
	
	/**
	 * Retrieves tax rate and returns
	 * @return TAX_RATE
	 */
	public double getTaxAmnt() {
		double tax = subTotal() * SALES_TAX;
		return tax;
	}
	
	/**
	 * Calculates and returns total
	 * @return total
	 */
	public double getTotal() {
		double total = subTotal() + (subTotal() * SALES_TAX);
		return total;
	}
	
	/**
	 * Applies coupon to items based on type
	 * @param coupon - coupon to be discounted
	 */
	public void applyCoupon(Coupon coupon) {
		if(coupon.getType().equals("Drink")) {
		for(DrinkItem d: Drinks) {
			d.applyCoupon(coupon);
		}
		}else if(coupon.getType().equals("Dessert")){
		for(DessertItem d: Desserts) {
			d.applyCoupon(coupon);
		}
		}
	}
	
	/**
	 * Allows list of objects to be printed in string
	 */
	public String toString() {
		String items = "";
		for(DrinkItem d: Drinks) {
			items += d;
		}
		for(DessertItem d: Desserts) {
			items += d;
		}
		return items;
	}
	
	public ArrayList<Object> getAllSales(){
		return allSales;
	}
	
	/**
	 * Allows list of objects to be printed in string
	 */
	public String toStringAllSales() {
		String sales = "";
		for(Object s : allSales) {
			sales +=  s + "\n";
		}
		
		return sales;
	}
}
