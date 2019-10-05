package carDemo;

import java.util.Arrays;

public class carTester {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Car ford = new Car();
		Car tesla = new Car();
		ford.setProfile("Ford", "Mustang", "2000");
		tesla.setProfile("Tesla", "Model S", "2018");
		
		System.out.println("Ford Position: " + Arrays.toString(ford.getPosition()));
		System.out.println("Tesla Position: " + Arrays.toString(tesla.getPosition()));
		
		ford.move('R');ford.move('R');ford.move('R');ford.move('R');ford.move('R');
		ford.move('U');ford.move('U');ford.move('L');
		
		tesla.move('R');tesla.move('R');tesla.move('R');
		
		System.out.println(ford.getProfile());
		System.out.println("Ford Position: " + Arrays.toString(ford.getPosition()));
		System.out.println(tesla.getProfile());
		System.out.println("Tesla Position: " + Arrays.toString(tesla.getPosition()));
		
	}

}
