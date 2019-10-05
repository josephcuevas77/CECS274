package labs;

public class RentalCar {

	private boolean rented;
	private static int carsRented;
	private static int carsAvailable;

	/**
	      Constructs a rental car.
	 */
	public RentalCar()
	{ 
		rented = false;
		carsAvailable ++;
		
		
	}

	/**
	      Get number of cars available.
	      @return count of cars that are available
	 */
	public static int numAvailable() 
	{
		return carsAvailable;
	}

	/**
	      Get number of cars rented.
	      @return count of cars that are rented
	 */
	public static int numRented() 
	{
		return carsRented;
	}

	/**
	      Try to rent this car.
	      @return true if the car was successfully rented, false if it was already
	      rented.
	 */
	public boolean rentCar() 
	{
		 if(!rented) {
			 carsRented ++; 
			 carsAvailable -= 1; 
			 rented = true; 
			 return true;
			 }
		 return false;
	}

	/**
	      Return rented car.
	      @return true if the car was previously rented and is now returned,
	      false if it was not previously rented.
	 */
	public boolean returnCar()
	{
		 if(rented) {
			 carsAvailable ++;
			 carsRented -= 1;
			 rented = false;
			 return true;
		 }
		 return false;
		
	}
}
