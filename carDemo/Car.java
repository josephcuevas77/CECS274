package carDemo;

public class Car {
	//attributes - instance variables
	private int[] position;
	private String make;
	private String model;
	private String year;
	
	/**
	 * default constructor. Initializes the position  
	 * of a new car to be the origin, and make, model, year to be "N/A"
	 * **/
	public Car() {	
		position = new int[2];
		make = "N/A";
		model = "N/A";
		year = "N/A";
	}

	/**
	 * updates make, model, and year of this car
	 * @param newMake - make of the car, as a String
	 * @param newModel - model of the car, as a String
	 * @param newYear - year of the car, as a String
	 * **/
	public void setProfile(String newMake, String newModel, String newYear) {
		make = newMake;
		model = newModel;
		year = newYear;
	}
	
	/**
	 * moves the car one unit in the given direction
	 * @param direction - a character representation of the acceptable directions
	 * 'U' for up, 'D' for down, 'R' for right, 'L' for left
	 * **/
	public void move(char direction) {
		
		if(direction == 'U') {
			position[1] += 1; //updating the second coordinate in the array
		}
		else if(direction == 'D') {
			position[1] -= 1; //updating the second coordinate
		}
		else if(direction == 'L') {
			position[0] -= 1;
		}
		else if(direction == 'R') {
			position[0] += 1;
		}
		else {
			System.out.println("ERROR: INVALID DIRECTION.");
		}
		
	}
	
	
	/**
	 * gets the car's make, model, and year
	 * @return the make, model and year in a formatted string
	 * **/
	public String getProfile() {
		return String.format("Make: %-25sModel: %-25sYear:%s", make, model, year);
	}
	
	
	/**
	 * gets the current position of the car
	 * @return the position as an array of size 2 representing the x- and y- coordinates
	 * **/
	public int[] getPosition() {
		return position;
}
}
