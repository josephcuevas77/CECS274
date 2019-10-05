package Project2;

/**
 * Abstract Parent Class DessertItem that has extensions/children of Pastry and 
 * Cookie, and then the Macaron class extends Cookie
 * @author Joseph
 *
 */
public abstract class DessertItem {

	private String dessertName;
	private int quantity;
	private double price;

	/**
	 * Default constructor for DessertItem
	 */
	public DessertItem() {
		price = -1;
		quantity = 0;
		dessertName = "N/A";
	}

	/**
	 * Overloaded constructor for DessertItem
	 * @param price - set to -1
	 * @param name - name or type of DessertItem
	 * @param amount - amount of that Dessert
	 */
	public DessertItem(String name, int amount) {
		price = -1;
		quantity = amount;
		dessertName = name;
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
	 * Applies coupon to Dessert object
	 * @param coupon - coupon to get discount from
	 * @return price
	 */
	public double applyCoupon(Coupon coupon) { 
			setPrice(getCost() * (1 - coupon.getDiscount())); 
			return getPrice();
		}

	/**
	 * Abstract class to calculate cost that is extended in the Pastry, Cookie, and Macaron
	 * @return cost
	 */
	public abstract double getCost();

	/**
	 * Class to handle all Pastry object methods and items
	 * extends the DessertItem Parent Class as its own child class
	 * @author Joseph
	 *
	 */
	public static class Pastry extends DessertItem {
		private  int amount;
		private  String type;
		private double unitPrice = 3.00;
		private  String heatingOption;
		private static String[] pastryMenu = {"Taro Bun","Matcha Roll"};
		private static String[] heatingOptions = {"None","Oven","Microwave"};

		/**
		 * Default constructor for Pastry Object
		 */
		public Pastry() {
			type = "N/A";
			amount = 0;
			heatingOption = "N/A";
		}

		/**
		 * Overloaded constructor for Pastry object
		 * @param pastry - type of pastry
		 * @param quantity - amount of pastries
		 * @param heat - heat option for pastries
		 */
		public Pastry(String pastry, int quantity, String heat) {
			type = pastry;
			amount = quantity;
			heatingOption = heat;
		}

		/**
		 * Retrieves the pastry menu 
		 * @return pastry menu
		 */
		public static String[] getPastryMenu() {
			return pastryMenu;
		}
		
		/**
		 * Retrieves the heating options
		 * @return heating options "menu"
		 */
		public static String[] getHeatingOptions() {
			return heatingOptions;
		}
		
		/**
		 * sets the heating option for the pastries
		 * @param heat - option chosen for heating
		 */
		public  void setHeating(String heat) {
			heatingOption = heat;
		}
		
		/**
		 * Sets the name of the pastry 
		 * @param name - name of pastry
		 */
		public  void setName(String name) {
			type = name;
		}
		
		/**
		 * Sets the amount of pastries
		 * @param quant - number of pastries
		 */
		public  void setAmount(int quant) {
			amount = quant;
		}

		/**
		 * Pastry abstract method to calculate cost in its own way
		 */
		public double getCost() {
			if(super.getPrice() != -1
					&& super.getPrice() != (amount * unitPrice)
					&& super.getPrice() != (amount * unitPrice) + (amount * .50))
				return super.getPrice();
			if(heatingOption.equals("None")) {
				super.setPrice((amount * unitPrice));
				return super.getPrice();
			}else {
				super.setPrice((amount * unitPrice) + (amount * .50));
				return super.getPrice();
			}
			 
		}
		
		/**
		 * Allows Pastry Object to be printed through String
		 */
		public String toString() {
			String pastry = "\n=====PASTRY=====\nPastry: " + type + "\nAmount: " + amount 
							+ "\nHeating: " + heatingOption + "\nPrice: $" + String.format("%.2f",getCost());
			return pastry;
		}
	}

	/**
	 * Class to handle all Cookie object methods and items
	 * extends the DessertItem Parent Class as its own child class
	 * @author Joseph
	 *
	 */
	public static class Cookie extends DessertItem {

		private int amount;
		private String flavor;
		private double pricePerDozen = 6.00;
		private String[] cookieMenu = {"Chocolate Chip", "Oatmeal Raisin"};

		/**
		 * Default Constructor for Cookie
		 */
		public Cookie() {
			flavor = "N/A";
			amount = 0;
		}

		/**
		 * Overloaded Constructor for Cookie object
		 * @param type - type of cookies
		 * @param quantity - amount of cookies
		 */
		public Cookie(String type,int quantity) {
			super(type, quantity);
			flavor = type;
			amount = quantity;
		}
		
		/**
		 * Sets the flavor of the cookies
		 * @param type - type of cookie
		 */
		public  void setFlavor(String type) {
			flavor = type;
		}
		
		/**
		 * Sets the amount of cookies desired
		 * @param quant - amount of cookies
		 */
		public void setAmount(int quant) {
			amount = quant;
		}
		
		/**
		 * Retrieves the Cookie menu options
		 * @return cookie menu
		 */
		public String[] getCookieMenu() {
			return cookieMenu;
		}

		/**
		 * Cookie abstract method to calculate cost in its own way
		 */
		public double getCost() {
			if(super.getPrice() != -1 &&
					super.getPrice() != ((double)amount/12) * pricePerDozen)
				return super.getPrice();
			super.setPrice(((double)amount/12) * pricePerDozen);
			return super.getPrice();
		}
		
		/**
		 * Allows the Cookie Object to be printed out in String
		 */
		public String toString() {
			String cookie = "\n=====COOKIE=====\nFlavor: " + flavor + "\nAmount: " + amount + " cookies\nPrice: $" + String.format("%.2f",getCost());
			return cookie;
		}
	}

	/**
	 * Class to handle all Macaron object methods and items
	 * extends the DessertItem Parent Class as its own child class
	 * @author Joseph
	 *
	 */
	public static class Macaron extends Cookie {
		private  int amount;
		private  String type;
		private double cost;
		private double unitPriceGT = 1.25;
		private double pricePerThreeGT = 3.50;
		private double unitPriceChoc = 1.00;
		private double pricePerThreeChoc = 2.75;

		/**
		 * Default Constructor for Macaron
		 */
		public Macaron() {
			amount = 0;
			type = "N/A";
		}

		/**
		 * Overloaded Constructor for Macaron
		 * @param quantity - amount of Macarons
		 * @param flavor - flavor of Macarons
		 */
		public Macaron(int quantity, String flavor) {
			super(flavor, quantity);
			amount = quantity;
		}
		
		/**
		 * Sets the amount of Macarons to be bought
		 * @param num - number of Macarons
		 */
		public  void setAmount(int num) {
			amount = num;
		}
		
		/**
		 * Sets the the type of Macaron being bought
		 * @param flavor - type of Macaron
		 */
		public  void setType(String flavor) {
			type = flavor;
		}

		/**
		 * Abstract method to calculate the cost for Macarons
		 * @param amount - number of Macarons
		 * @param type - flavor of Macarons
		 * @return cost
		 */
		public double getCost(int amount,String type) {
			int quantity = amount;
			String flavor = type;
			if( super.getPrice() != -1
					&& super.getPrice() != ((quantity % 3) * unitPriceGT) + (Math.floor(quantity/3) * pricePerThreeGT)
					&& super.getPrice() != ((quantity % 3) * unitPriceChoc) + (Math.floor(quantity/3) * pricePerThreeChoc))
				return super.getPrice();
			switch(flavor) {
			case("Matcha"):
				super.setPrice(((quantity % 3) * unitPriceGT) + (Math.floor((double)quantity/3) * pricePerThreeGT));
				return super.getPrice();
			case("Chocolate"):
				super.setPrice(((quantity % 3) * unitPriceChoc) + (Math.floor((double)quantity/3) * pricePerThreeChoc));
				return super.getPrice();
		}
		return cost;
		}
			
		/**
		 * Allows the Macarons to be printed dependent upon whether its chocolate or Matcha
		 */
		public String toString() {
			if(type.equals("Matcha")) {
				String macaronInfo = "\n=====MACARON=====\nFlavor: Matcha"  + "\nAmount : " + amount + "\nPrices: \n" + (amount % 3) + " @ unit Price of: $" + unitPriceGT
							  + "\n" + String.format("%1.0f",Math.floor(amount/3)) + " @ trio price of: $" + pricePerThreeGT + "\nTotal Price: $" + String.format("%.2f",getCost(amount, "Matcha"));
				return macaronInfo;
			}else if(type.equals("Chocolate")) {
				String macaronInfo = "\n=====MACARON=====\nFlavor: Chocolate"  + "\nAmount : " + amount + "\nPrices: \n" + (amount % 3) + " @ unit Price of: $" + unitPriceChoc
						  + "\n" + String.format("%1.0f",Math.floor(amount/3)) + " @ trio price of: $" + pricePerThreeChoc + "\nTotal Price: $" + String.format("%.2f",getCost(amount, "Chocolate"));
				return macaronInfo;
			}else return "N/A";
			
		}
	}
}
