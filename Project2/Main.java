package Project2;

import java.util.Scanner;
import Project2.DessertItem.Cookie;
import Project2.DessertItem.Macaron;
import Project2.DessertItem.Pastry;
import Project2.DrinkItem.BobaDrink;
import Project2.DrinkItem.CoffeeDrink;

public class Main {

	public static void main(String[] args) {
		
		Scanner nani  = new Scanner(System.in);
		double payment = 0.0;
		double total = 0.0;
		
		CashRegister c = new CashRegister();
		CashRegister allSales = new CashRegister();
		
		BobaDrink newBoba = new BobaDrink();
		Pastry newPastry = new Pastry();
		Cookie newCookie = new Cookie();
		Macaron newMacaron = new Macaron();
		
		System.out.println(mainMenu());
		int userIn = nani.nextInt();
		while(userIn != 3) {
			switch(userIn) {
			case 1: 
				System.out.println("=====DRINKS AND DESSERTS=====\n1.Coffee\n2.Boba\n3.Pastries\n4.Cookies\n5.Macarons\n6.Finalize Sale\n");
				System.out.println("Please make a selection");
				int userIn2 = nani.nextInt();
				switch(userIn2) {
				case 1:
					System.out.println("===COFFEE===");
					c.addDrink(Sales.addCoffee());
//					System.out.println(c.getDrinkList().get(c.getDrinkList().size()-1));
//					System.out.println(c.getDrinkList());
					break;
				case 2:
					System.out.println("===BOBA===");
					newBoba = Sales.addBoba();
					c.addDrink(newBoba);
//					System.out.println(newBoba);
//					System.out.println(c.getDrinkList());
					break;
				case 3:
					System.out.println("===PASTRIES==="); 
					newPastry = Sales.addPastry();
					c.addDessert(newPastry);
//					System.out.println(newPastry);
//					System.out.println(c.getDessertList());
					break;
				case 4:
					System.out.println("===COOKIES===");
					newCookie = Sales.addCookie();
					c.addDessert(newCookie);
//					System.out.println(newCookie);
					break;
				case 5:
					System.out.println("===MACARONS===");
					newMacaron = Sales.addMacaron();
					c.addDessert(newMacaron);
//					System.out.println(newMacaron);
					break;
				case 6:
					System.out.println(finalMenu());
					int input = nani.nextInt();
					while(input != 5) {
						switch(input) {
							case 1:
								System.out.printf("Subtotal: $%.2f%n", c.subTotal());
								System.out.printf("Tax: $%.2f%n", c.getTaxAmnt());
								System.out.printf("Total: $%.2f%n",  c.getTotal());
								System.out.println(finalMenu());
								input = nani.nextInt();
								break;
							case 2:	
								Coupon coupon = Sales.newCoupon();
								c.applyCoupon(coupon);
								System.out.println(finalMenu());
								input = nani.nextInt();
								break;
							case 3:
								System.out.print("Please enter payment amount: $"); 
								payment = nani.nextDouble();
								System.out.println(finalMenu());
								input = nani.nextInt();
								break;
							case 4:
								double change = c.getTotal() - payment;
								if(change <= 0) {
								System.out.printf("Change owed : $%.2f%n" ,(change * -1) );
								}else System.out.println("Insufficient payment, please pay the correct amount");
								System.out.println(finalMenu());
								input = nani.nextInt();
								break;
							}
					}System.out.println(c.toString()); //Selection of Option 5
					System.out.printf("%nTotal of this sale: $%.2f%n",  c.getTotal());
					for(Object i :c.getAllSales()) {
						allSales.addObject(i);
					}
					total += c.getTotal();
					c.clearCR();
					System.out.println(mainMenu());
					userIn = nani.nextInt();
					break;
				}
				break;
			case 2:
				System.out.println(allSales.toStringAllSales());
				System.out.printf("Total of All Sales: $%.2f%n", total);
				
				System.out.println(mainMenu());
				userIn = nani.nextInt();
				break;
			}
		}System.out.println("Register has closed.");
	nani.close();
	}
	
	public static  String mainMenu() {
		String menu = "===========MAIN MENU===========\n" + 
			   		  "1.New Sale\n2.Print all Sales\n3.Close the register\n" + 
			   		  "===============================";
		return menu;
	}
	
	public static String finalMenu() {
		String menu = "=============\n" +
		"1.Give Total\n2.Accept Coupons\n3.Accept Payment\n4.Give Change\n5.Print Receipt\n" + 
					  "=============";
		return menu;
	}
}
