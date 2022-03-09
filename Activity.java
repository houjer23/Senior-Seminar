/**
* This class gives the description of one activity
*
* @author Jerry Hou
* @since 1.0
*/

public class Activity {
	String name;
	String presenter;
	
	// Constructor for the Activity
	public Activity(String name, String presenter) {
		this.name = name;
		this.presenter = presenter;
	} // end of the Constructor
	
	// used to print activty
	public String toString() {
		return "Name: " + name + "    Presenter: " + presenter;
	} // end of toString method
} // end of the class
