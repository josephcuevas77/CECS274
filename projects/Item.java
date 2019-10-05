package projects;

/**
 * models a grocery item that will be printed on a receipt
 * RESPONSIBILITIES:
 * 1. Store the name of the item X
 * 2. Get/Update the unit price X
 * 3. Get/Update the size of one item X
 * 4. Get/Update quantity of products of this same item X
 * 5. Get/Update the subtotal X
 * 
 **/

public class Item {
	
	private String itemName;
	private double unitPrice;
	private String sizeWeight;
	private int qty;
	
	/*
	 * Recall: A default constructor initializes the instance variables.
	 * If you do not have a default constructor, your class will still compile
	 * and run. However the compiler is going to initialize to default values.
	 * String or any other Object data type -> null; double -> 0.0; int -> 0;
	 *  boolean -> false; etc.
	 *  THIS IS DANGEROUS BECAUSE IT MAY CAUSE THE OBJECTS FROM THIS CLASS
	 *  TO MISBEHAVE OR BEHAVE IN A WAY THE USER DOES NOT ACCEPT. HENCE, 
	 *  YOU SHOULD ALWAYS WRITE AT LEAST A DEFAULT CONSTRUCTOR
	 */
	
	/**
	 * default constructor initializes the name of the item and size to
	 *  "N/A" and all other quantities to be 0
	 * **/
	public Item() {
		itemName = "N/A";
		unitPrice = 0;
		sizeWeight = "N/A";
		qty = 0;
	}
	
	/**
	 * overloaded constructor initializes an Item object with the given 
	 * initial data
	 * @param name - the name of this item as a String
	 * @param size - the size or weight of this item as a String
	 * @param unitPrice - the price of this item as a double
	 * @param qty - the number of products of this same item
	 * **/
	
	public Item(String name, String size, double unitPrice, int qty) {
		itemName = name;
		sizeWeight = size;
		this.unitPrice = unitPrice;
		this.qty = qty;
	}

	/*
	 * sets and stores the name of this current item
	 * @param itemName - the new name of the item as a string
	 */

	public void setItemName(String itemName) {
		this.itemName = itemName; /*"this" is a special keyword
		 that allows you to differentiate between instance variables
		 and parameter names. When you call "this.itemNAme", the compiler
		 knows you mean the "itemName" belonging to this current Item object,
		 not the "itemName" parameter*/
	}
	
	/**
	 * gets the name of this item
	 * @return the name as a string
	 * **/
	public String getItemName() { return itemName; }
	
	/*
	 * gets the unit price for this item
	 * @return the price as a double
	 * 
	 */
		
	public double getUnitPrice() { return unitPrice; }
		
	/*
	 * updates the price of this item
	 * @param newPrice - the new price that is going to be given to this item
	 * 
	 */
	
	public void setUnitPrice(double newPrice) {
		unitPrice = newPrice; //we do not need to use "this.itemPrice" 
		//because the parameter name is different.
	}
	
	/*
	 * gets the size of this item
	 * @return the size including the unit
	 */
	
	public String getSize() { return sizeWeight;}
	
	/*
	 * sets the size of the object
	 * @param newSize - the size of this object as a string
	 */

	public void setSize(String newSize) {
		sizeWeight = newSize; 
	}
	
	/*
	 * gets the quantity of this item
	 * @return the quantity as an integer
	 */
	
	public int getQty() { return qty; }
	
	/*
	 * updates the quantity by 1
	 */
	
	public void updateQty() {
		qty++;
	}
	

	/*
	 * gets the subtotal owed for this item
	 * @return the subtotal as a double
	 */

	public double getSubtotal() { return qty * unitPrice; }
	
	/**
	 * returns the string you wish to print whenever System.out.print()
	 * or Sout() is called on this current Item object. The compiler will
	 * look for this method when you call a print method and thus print the 
	 * string instead of the memory address.
	 *  **/
	
	public String toString() {
		String info = String.format("%-25s %-10s %d(@$%.2f) %-15s$%.2f", itemName, sizeWeight, qty, unitPrice, "", this.getSubtotal());
		return info; 
	}

}
