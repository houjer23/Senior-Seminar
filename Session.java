/**
* This construct the Session and help sort the Session based on user choice
*
* @author Jerry Hou
* @since 1.0
*/
public class Session implements Comparable<Session>{
	private int id;
	private int popularity;

	// Constructor
	public Session(int id, int popularity) {
		this.id = id;
		this.popularity = popularity;
	}
	
	// compareTo used for sort
	public int compareTo(Session s2) {
		return s2.popularity - this.popularity;
	} // end of compareTo method

	// setter method for popularity
	public void increase_popularity(int amount) {
		popularity += amount;
	} // end of the setter method
	
	// getter method for id
	public int get_id() {
		return id;
	} // end of the getter method
	
	// rewrite toString method
	public String toString() {
		return "Session Id: " + id + " Popularity: " + popularity;
	} // end of the toString method
}
