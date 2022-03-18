/**
* This class gives the description of one activity
*
* @author Jerry Hou
* @since 1.0
*/

public class Activity {
	private String name;
	private String presenter;
	
	// Constructor for the Activity
	public Activity(String name, String presenter) {
		this.name = name;
		this.presenter = presenter;
	} // end of the Constructor
	
	// used to print activty
	public String toString() {
		return "Name: " + name + "    Presenter: " + presenter;
	} // end of toString method
	
	// getter method for the session name
	public String get_name() {
		return name;
	} // end of the getter method
	
	// getter method for the session presenter
	public String get_presenter() {
		return presenter;
	} // end of the getter method
} // end of the class
