package Demo;

import java.util.Arrays;

public class PrimitiveVsObject {
	
	public static void multiplyByTwo(int a) {
		a *= 2;
	}
	
	public static void multiplyByTwo (int[] a) {
		for int
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int age = 98;
		int[] ages = {1,2,3,4,5};
		System.out.println(age);
		//Arrays.toString()' converts the contents into 
		//a printable string
		System.out.println(Arrays.toString(ages));
		multiplyByTwo(age);
		multiplyByTwo(ages);
		System.out.println(age);
		System.out.println(Arrays.toString(ages));
	}

}
