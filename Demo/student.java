package Demo;

/**
 * 
 * @author Joseph
 *
 */

public class student implements Comparable<Object> {
	private String name;
	private String ID;
	private double gpa;
	private int numCourses;
	private static int numOfStudents = 0;
	
	public student() {
		name = "N/A";
		ID = "N/A";
		gpa = 0;
		numCourses = 0;
		numOfStudents ++;
	}
	
	public student(String name, String ID, double gpa, int numCourses) {
		this.name = name;
		this.ID = ID;
		this.gpa = gpa;
		this.numCourses = numCourses;
		numOfStudents ++;
	}
	
	public void setName(String newName) {
		this.name = newName;
	}
	
	public  void updateGPA(String lettergrade) {
		int numCourses = this.numCourses; 
		double currentGPA = 0;
		
		if(lettergrade == "A") {
			currentGPA += 4;
			numCourses += 1;
		}
		else if(lettergrade == "B") {
			currentGPA += 3;
			numCourses += 1;
		}
		else if(lettergrade == "C") {
			currentGPA += 2;
			numCourses += 1;
		}
		else if(lettergrade == "D") {
			currentGPA += 1;
			numCourses += 1;
		}
		else if(lettergrade == "F") {
			currentGPA += 0;
			numCourses += 1;
		}
		else {
			System.out.println("Invalid letter Grade");
		}
		this.gpa = calculateGPA( currentGPA, numCourses);
	}
	
	public String toString() {
		return "Name: " + this.name + "\nID: " + this.ID + "\nGPA: " + this.gpa; 
	}
	
	public int compareTo(Object o) {
		student otherStudent = (student) o;
		
		if(this.gpa < otherStudent.gpa) {
			return -1; 
		}
		return 0;
	}
	
	public static int currentNumOfStudents() { return numOfStudents; } 
	
	private static double calculateGPA(double gradePoints, int numCourses) {
		double c = gpa;
		return gradePoints/numCourses; 
	}
}
