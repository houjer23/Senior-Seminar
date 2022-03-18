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
	private int[] result = new int[5];
	
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
	
	// method to add a session for the student when the result is confirmed
	public void add_session(int time, int session_id) {
		result[time] = session_id;
	} // end of the add session method
	
	// getter method for the session that the student goes to
	public int[] get_result() {
		return result;
	} // end of the getter method
	
	// getter method for student name
	public String get_name() {
		return name;
	} // end of the getter method
} // end of the class
