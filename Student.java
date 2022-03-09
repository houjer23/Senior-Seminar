/**
* This construct the student, storing student information
*
* @author Jerry Hou
* @since 1.0
*/

public class Student {
	String email;
	String name;
	int[] choice;
	
	// constructor for student, storing the file
	public Student(String email, String name, int[] choice) {
		this.email = email;
		this.name = name;
		this.choice = choice;
	} // end of the Constructor
	
	// used to print Student
	public String toString() {
		return email + " " + name;
	} // end of the toString method
} // end of the class
