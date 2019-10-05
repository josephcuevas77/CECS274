package projects;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.FileWriter;
import java.io.IOException;

public class Project2Demo {
	public static void main(String[] args) throws FileNotFoundException {

		Scanner nani = new Scanner(System.in);

		//Prompts User to enter name for receipt txt file
		System.out.println("What would you like to name the new .txt file?");
		String name = nani.nextLine();
		StringBuilder receipt = new StringBuilder();
		receipt.append(".txt");
		String fileName = name + receipt.toString();

		//List to sort out first group and main name for products
		ArrayList<String> items = new ArrayList<String>();
		//List to sort out descriptor of product
		ArrayList<String> description = new ArrayList<String>();
		//List to sort out and store weight values for products into list 
		ArrayList<String> weights = new ArrayList<String>();
		//List to store prices for each respective product
		ArrayList<String> prices = new ArrayList<String>();
		//List to keep track of what the user enters or "is buying"
		ArrayList<String> cart = new ArrayList<String>();
		//List to keep track of how many the user is buying
		ArrayList<String> quantity = new ArrayList<String>();
		//List to match inputs with items in list
		ArrayList <String> matches = new ArrayList <String> ();
		//Used to store the weight of the product in the price lists
		ArrayList <String> weightPrices = new ArrayList <String> ();
		//Used to store the descriptions of products within the price lists
		ArrayList <String> descPrices = new ArrayList <String> ();

		//Gets location from user directory in order to read PriceList file
		File priceList = new File("C:\\Users\\Joseph\\Desktop\\School Resources\\CECS 274\\PriceList.txt");

		//Initializing Reader to read file 
		Scanner fileReader = new Scanner(priceList);

		//New location to save receipt name that user chooses
		PrintWriter fileWriter = new PrintWriter("C:\\Users\\Joseph\\Desktop\\Receipts\\" + fileName);

		//Pattern from regex in order to separate each thing into groups
		Pattern p = Pattern.compile("(.+?)\\s\\s+(.+?)\\s\\s+(.+?)\\s\\s+(.+?.+)");

		Matcher m;

		//Reads through file to get items and use regex to recognize
		while(fileReader.hasNextLine()) {
			String currentLine = fileReader.nextLine();
			m = p.matcher(currentLine);

			if(m.find()) {

				//Finds the groups and assigns them to a variable
				String mainItem = m.group(1);
				items.add(mainItem);
				String Description = m.group(2);
				descPrices.add(Description);
				String weight = m.group(3);
				weightPrices.add(weight);
				String price = m.group(4);
				prices.add(price);

			}

		}

		//Prompts user to enter in each item until done
		System.out.println("Enter the name and size/weight of the product followed by"
				+ " \"ENTER\". When you are done, enter \"DONE\".");

		//Initializes each variable in order for user to input
		String userItem = " ";
		String userDesc = " ";
		String userWeight = " ";
		String userQuantity = " ";

		while(!userQuantity.equals("DONE")) {

			System.out.println("Item name:");
			userItem = nani.nextLine();
			if(userItem.equals("DONE")) {
				break;
			}

			System.out.println("Description:");
			userDesc = nani.nextLine();
			if(userDesc.equals("DONE")) {
				break;
			}

			System.out.println("Item weight:");
			userWeight = nani.nextLine();
			if(userWeight.equals("DONE")) {
				break;
			}

			System.out.println("Item quantity: ");
			userQuantity = nani.nextLine();
			if(userQuantity.equals("DONE")) {
				break;
			}

			boolean itemFound = false;
			for(int y = 0; y < items.size(); y++) {
				if(userItem.equals(items.get(y)) && (userDesc.equals(descPrices.get(y))) && (userWeight.equals(weightPrices.get(y)))) {
					cart.add(userItem);	
					description.add(userDesc);
					weights.add(userWeight);
					quantity.add(userQuantity);
					itemFound = true;
				}

			}
			String response;
			if(itemFound == false) {
				System.out.println("Item not found in PriceList.txt, would you like to add the item to the Price List? Yes or No?");
				response = nani.nextLine();
				if(response.equals("Yes")) {
					String newItem;
					String newDesc;
					String newWeight;
					double newPrice;

					System.out.println("Item name:");
					newItem = nani.nextLine();

					System.out.println("Description:");
					newDesc = nani.nextLine();

					System.out.println("Item weight:");
					newWeight = nani.nextLine();

					System.out.println("Item Price: ");
					newPrice = nani.nextDouble();
					try {
						FileWriter priceListW = new FileWriter("C:\\Users\\Joseph\\Desktop\\School Resources\\CECS 274\\PriceList.txt", true);

						priceListW.write(String.format("%n%-33s%-52s%-15s%.2f",newItem, newDesc, newWeight, newPrice));

						priceListW.flush();
						priceListW.close();

					}
					catch(IOException i) {
						System.err.println(i.getMessage());
					}
				}
				if(response.equals("No")) {
					System.out.println("Looping you back around.");
				}
			}
			nani.nextLine();
		}

		//Printing Address of "store"
		String space = "";
		fileWriter.printf("–––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––——––––––––––––%n");
		fileWriter.printf("Just Zero Two %n002 E. Iota Dr. %nCity of Eternity, Ca 99999%n%n%n");
		fileWriter.printf("Item %-42s Subtotal %s%n", space, space);


		//Formatting the receipt to print and calculating total of all items in cart
		double total = 0;
		for(int x = 0; x < cart.size(); x++) {
			for(int i = 0; i < items.size(); i++) {
				if (cart.get(x).equals(items.get(i)) && (description.get(x).equals(descPrices.get(i))) && (weights.get(x).equals(weightPrices.get(i)))) {
					String productName = cart.get(x) + " " + description.get(x);
					matches.add(productName);


					int amount = Integer.parseInt(quantity.get(x));
					double price = Double.parseDouble(prices.get(i));

					if (amount <= 1 && amount >= 0) {
						fileWriter.printf("%-50s $%s %n", productName, prices.get(i));
						total += price * amount;
						System.out.println("Price: $" + price);
					}
					else if (amount > 1) {
						fileWriter.printf("%-39s" + amount + "@(%s)    $%s%n", productName, prices.get(i), (price * amount));
						total += (price * amount);
					}				
				}
			}
		}

		fileWriter.printf("%n%nTotal $%.2f", total);
		fileWriter.printf("%n–––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––——––––––––––––%n");

		//Extra credit, Adding up and calculating change if any.
		System.out.printf("The total of all your items is: $%.2f. ", total);
		System.out.println("How much are you paying today? $");
		double userPayment = Double.parseDouble(nani.nextLine().trim());
		double difference = userPayment - total;
		//Gives amount calculated of change to user
		if(difference >= 0) {
			System.out.printf("Your change from this transaction: $%.2f\n", difference);
			System.out.println("Have a nice day!");
			//Tells user if they have an inefficient amount of money
		}else {
			System.out.println("Insufficient funds.");
		}	

		//Close the file Reader and Writer to ensure no info leaks
		fileReader.close();
		fileWriter.close();
		//Also close Scanner to ensure no leaks
		nani.close();
	}
}
