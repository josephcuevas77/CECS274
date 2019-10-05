package hw4;
//Import scanner to be used
import java.util.Scanner;

public class Homework4 {
	//Creates a global scanner that can be used in a functions and does not close scanner prematurely before needing it twice
	static Scanner nani = new Scanner (System.in);
	public static void main(String[] args) {
		//Calls get name function and assigns it to a variable
		String name = getName();
		//Checks to see if user wishes to quit
		if (name.equals("quit")){

			return;
		}
		//End of if statement to check if user wants to quit

		if(isWinner(name) == true) {
			System.out.println("Congratulations " + name + ". You Win!");
			main(new String[0]);
		}
		//End of first if statement

		if(isWinner(name) == false) {
			System.out.println("Sorry, " + name + ". You have to go now.");
			main(new String[0]);
		}
		//End of second if statement
		//Closing scanner so there is no resource leak
		nani.close();	
	}
	//End of main



	//Creates function to calculate and return the summation of ints from ASCII values
	public static int calculateNameScore(String name) {
		int add = 0;
		for(int i = 0; i < name.length(); i++) {
			if(Character.isLetter(name.charAt(i))) {
				char c = name.charAt(i);
				int value = (int)c;
				add += value;
			}
			//End of if statement
		}
		//End of for statement
		return add;
	}
	//End of calculateNameScore
	
	//Creates function to determine if name meets winning conditions
	public static boolean isWinner(String name) {
		int nameScore = calculateNameScore(name);
		int length = name.length();
		if((nameScore / length) % 2 == 0) {
			return true;
		}
		//End of if statement
		return false;

	}
	//End of isWinner function
	
	//Creates function to ask user for inputted name 
	public static String getName() {

		System.out.println("Please enter your name:");
		String name = nani.nextLine();
		//Will ask user to enter in again if length is 0
		while(name.length() < 1) {
			System.out.println("Please enter your name:");
			name = nani.nextLine();
		}
		return name;

	}
	//End of public String getName function




}

