/**
* This construct the student, storing student information
*
* @author Jerry Hou
* @since 1.0
*/

public class Student {
	private String email;
	private String name;
	private int[] choice;
	
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

	// getter method for student choice
	public int[] get_choice() {
		return choice;
	} // end of the getter method
} // end of the class
