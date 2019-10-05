package CustomerTest;

/**
 * models a store directory that assigns customer membership levels according to their points
 * REPONSIBILITIES:
 * 1. Store the inputted customer ID X
 * 2. Get/Update the reward points for the customer X
 * 3. Get/Update the membership Level based on points X
 * @author Joseph
 *
 */

public class Customer {

	private int custID;
	private int rewardP;
	private String membrLvl;
	
	/**
	 * Default constructor initializes the customer ID and reward Points to 0 
	 * and defaults the membership level to "bronze"
	 */
	public Customer() {
		custID = 0;
		rewardP = 0;
		membrLvl = "bronze";
	}
	
	/**
	 * Overloaded constructor initializes Customer object with the given initial data
	 * @param custID - the customer ID that the user inputs as an int
	 * @param rewardP - the reward points of the customer as an int
	 */
	public Customer(int custID, int rewardP) {
		
		
		this.custID = custID;
		this.rewardP = rewardP;
		
		if(rewardP >= 0 && rewardP <= 2000) {
			membrLvl = "Bronze";
		}
		if(rewardP > 2000 && rewardP <= 5000){
			membrLvl = "Silver";
		}
		if(rewardP > 5000 && rewardP <= 10000){
			membrLvl = "Gold";
		}
		if(rewardP > 10000){
			membrLvl = "Platinum";
		}
	}
	/**
	 * Gets the ID number of the customer 
	 * @return the ID as an int
	 */
	public int getID() { return custID; }
	
	/**
	 * Gets the reward points for the customer
	 * @return the points as an int
	 */
	public int getRewardP() { return rewardP; }
	
	/**
	 * Gets the membership level for the customer
	 * @return the membership level as a String
	 */
	public String getMembrLvl() { return membrLvl; }
	
	/**
	 * Makes function to add points to existing points of Customer and adjusts
	 * membership level accordingly.
	 * @param newPoints - the points being added to the current Customer reward points
	 */
	public void addPoints(int newPoints) {
		rewardP += newPoints;
		if(rewardP >= 0 && rewardP <= 2000) {
			membrLvl = "Bronze";
		}
		if(rewardP > 2000 && rewardP <= 5000){
			membrLvl = "Silver";
		}
		if(rewardP > 5000 && rewardP <= 10000){
			membrLvl = "Gold";
		}
		if(rewardP > 10000){
			membrLvl = "Platinum";
		}
	}
	/**
	 * Prints and formats the output of all the items in from the customer info
	 */
	public String toString() {
		String info = String.format("Customer ID: %d%nReward Points: %d%nMembership Level: %s%n", custID, rewardP, membrLvl);
		return info;
	}
}
