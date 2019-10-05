package Demo;

import java.util.ArrayList;
import java.util.Collections;

public class studentTester {

	public static void main(String[] args) {
		
		student stud1 = new student();
		student stud2 = new student("John Doe", "000-000-000", 3.5, 2);
		student stud3 = new student("Abe. S", "", 1.5, 3);
		
		stud1.setName("Joseph Cuevas");
		stud1.updateGPA("A");
		stud1.updateGPA("A");
		stud1.updateGPA("A");
		stud2.setName("Zero Two");
		stud1.updateGPA("A");
		
		ArrayList <student> students = new ArrayList <student> ();
		students.add(stud2);
		students.add(stud3);
		students.add(stud1);
		
		System.out.println("Before Sort:\n");
		for(student s: students) {
			System.out.println(s);
			System.out.println("--------------------");
		}
		
		Collections.sort(students);
		System.out.println("After Sort:\n");
		for(student s: students) {
			System.out.println(s);
			System.out.println("--------------------");
		}
		System.out.println(student.currentNumOfStudents);

	}

}
