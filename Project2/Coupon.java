package Project2;

/**
 * this class models a coupon object with a given item to which it 
 * can be applied and a percentage amount discount
 * @author Katherine Varela
 * @since 2019-02-12
 * @version 1.0.0
 * **/
public class Coupon {
	
	private String itemType;
	private double percentDiscount;
	private boolean isValid;
	private static  String[] couponOptions = {"Drink","Dessert"};
	
	/**
	 * Constructs an invalid coupon with no discount
	 * **/
	public Coupon() {
		itemType = "Not a valid coupon.";
		percentDiscount = 0;
		isValid = false;
	}
	
	/**
	 * creates a coupon with type of item it is applicable to, 
	 * and a percent discount
	 * @param item - type of item
	 * @param discount - the discount as a decimal percent
	 * **/
	public Coupon(String item, double discount) {
		itemType = item;
		percentDiscount = discount;
		isValid = true;
	}
	
	/**
	 * gets the discount of this coupon
	 * @return the discount as a percent decimal 
	 * **/
	public double getDiscount() {
		return percentDiscount;
	}
	
	/**
	 * gets the Type of this coupon
	 * @return the type as a String
	 */
	public String getType() {
		return itemType;
	}
	
	
	/**
	 * returns a string representation of this coupon that reads
	 * 'This coupon is valid for <discount amount>% off any <item type> time.'
	 * @return the Coupon object as a string
	 * **/
	public String toString() {
		if(isValid) {
		return String.format("This coupon is valid for %1.0f%% off any %s item.",
				percentDiscount * 100, itemType) ;}
		else { return "Invalid coupon."; }
	}
	
	/**
	 * Retrieves the Coupon options for drink or pastry
	 * @return Options for coupon as array
	 */
	public static String[] getCouponOptions() {
		return couponOptions;
	}

}
