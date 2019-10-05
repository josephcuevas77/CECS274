package Project2;

import java.util.Scanner;
import Project2.DessertItem.Cookie;
import Project2.DessertItem.Macaron;
import Project2.DessertItem.Pastry;
import Project2.DrinkItem.BobaDrink;
import Project2.DrinkItem.CoffeeDrink;

public class Sales {
	
	 static Scanner nani = new Scanner(System.in);

	 /**
	  * Creates a BobaDrink object and fills in parameters
	  * @return BobaDrink
	  */
	public static BobaDrink addBoba() {
		BobaDrink BobaDrink = new BobaDrink();
		BobaDrink.resetToppings();
		System.out.println(arrayToString(DrinkItem.getSizeMenu())+ "\nWhat size would you like?");
		int sel = nani.nextInt();
		String size = choiceToString(sel, DrinkItem.getSizeMenu());
		BobaDrink.setSize(size);
		System.out.println(arrayToString(BobaDrink.getBaseTeasMenu()) + "\nWhat Base Tea would you like? ");
		sel = nani.nextInt();
		String tea = choiceToString(sel,BobaDrink.getBaseTeasMenu());
		BobaDrink.setBaseTea(tea);
		System.out.println("\n" + arrayToString(BobaDrink.getSweetnessMenu()) + "\nWhat Sweetness would you like? ");
		sel = nani.nextInt();
		String sweet = choiceToString(sel,BobaDrink.getSweetnessMenu());
		BobaDrink.setSweetness(sweet);
		System.out.println("\n" + arrayToString(BobaDrink.getMilksMenu()) + "\nWhich Milk option would you like?");
		sel = nani.nextInt();
		String milk = choiceToString(sel,BobaDrink.getMilksMenu());
		BobaDrink.setMilk(milk);
		System.out.println("\n===TOPPINGS===\n" + arrayToString(BobaDrink.getToppingsMenu()));
		System.out.println("What Toppings would you like?");
		String top;
		do {
			int sel5 = nani.nextInt();
			top = choiceToString(sel5, BobaDrink.getToppingsMenu());
			BobaDrink.addTopping(top);
		if(top.equals("Done")) BobaDrink.getToppingList().remove("Done");
		}while(!top.equals("Done"));
		return BobaDrink;
	}
	
	/**
	 * Creates a CoffeeDrink and fills in parameters
	 * @return CoffeeDrink
	 */
	public static CoffeeDrink addCoffee() {
		CoffeeDrink CoffeeDrink = new CoffeeDrink();
		System.out.println(arrayToString(DrinkItem.getSizeMenu())+ "\nWhat size would you like?");
		int sel = nani.nextInt();
		String size = choiceToString(sel, DrinkItem.getSizeMenu());
		System.out.println(arrayToString(CoffeeDrink.getBases()) + "\nWhat base would you like in your coffee?");
		int sel2 = nani.nextInt();
		String base = choiceToString(sel2, CoffeeDrink.getBases());
		System.out.println("How many teaspoons of sugar would you like in your Coffee?");
		int Tsp = nani.nextInt();
		return new CoffeeDrink(size, base, Tsp);
	}
	
	/**
	 * Creates a Macaron and fills in parameters
	 * @return Macaron
	 */
	public static Macaron addMacaron() {
		Macaron Macaron = new Macaron();
		String flavor = "";
		System.out.println("1.Matcha\n2.Chocolate");
		int sel = nani.nextInt();
		while(sel > 2 || sel < 1) {
			System.out.println("Please select one of the two options!");
			sel = nani.nextInt();
		}
		if(sel == 1) flavor = "Matcha";
		else if(sel == 2) flavor = "Chocolate";
		Macaron.setType(flavor);
		System.out.println("How many macarons would you like?");
		int num = nani.nextInt();
		Macaron.setAmount(num);
		Macaron.getCost(num,flavor);
		return Macaron;
	}
	
	/**
	 * Creates a Cookie and fills in parameters
	 * @return Cookie
	 */
	public static Cookie addCookie() {
		Cookie Cookie = new Cookie();
		System.out.println(arrayToString(Cookie.getCookieMenu()) + "\nWhat flavor of Cookies would you like?");
		int sel = nani.nextInt();
		while(sel > 2 || sel < 1) {
			System.out.println("Please select one of the two options!");
			sel = nani.nextInt();
		}
		String flavor = choiceToString(sel, Cookie.getCookieMenu());
		Cookie.setFlavor(flavor);
		System.out.println("\nHow many cookies would you like?");
		int quant = nani.nextInt();
		Cookie.setAmount(quant);
		return Cookie;
	}
	
	/**
	 * Creates a Pastry and fills the parameters
	 * @return Pastry
	 */
	public static  Pastry addPastry() {
		Pastry Pastry = new Pastry();
		System.out.println(arrayToString(Pastry.getPastryMenu()) + "Which Pastry would you like?");
		int sel = nani.nextInt();
		String flavor = choiceToString(sel, Pastry.getPastryMenu());
		Pastry.setName(flavor);
		System.out.println("\nHow many of the Pastry would you like?");
		int quant = nani.nextInt();
		Pastry.setAmount(quant);
		System.out.println(arrayToString(Pastry.getHeatingOptions()) + "\nWould you like your Pastry heated?");
		int sel2 = nani.nextInt();
		String heat = choiceToString(sel2,Pastry.getHeatingOptions());
		Pastry.setHeating(heat);
		return Pastry;
		}
	
	/**
	 * Creates a coupon and fills its parameters
	 * @return coupon
	 */
	public static Coupon newCoupon() {
		System.out.println("What type of coupon is it?\n" + arrayToString(Coupon.getCouponOptions()));
		int sel = nani.nextInt();
		String type = choiceToString(sel, Coupon.getCouponOptions());
		System.out.print("What percent discount is it? %");
		double discount = nani.nextDouble();
		discount /= 100.0;
		Coupon coupon = new Coupon(type, discount);
		return coupon;
	}
	
	/**
	 * Allows array to be printed out in String
	 * @param arr - array to be converted
	 * @return array as String
	 */
	public static  String arrayToString(String[] arr) {
		String blah = "";
		for(int i = 0; i < arr.length; i ++) {
		blah += (i+1) + "." + arr[i] + "\n";
		}
		return blah;
	}
	
	/**
	 * Takes int and converts it to index in array
	 * @param user - user int input
	 * @param arr - array to take index from
	 * @return choice corresponding to index in array
	 */
	public static  String choiceToString(int user, String[] arr) {
		return arr[user-1];
		
	}
}
