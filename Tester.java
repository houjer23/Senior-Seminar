/**
* This class takes the input
*
* @author Jerry Hou
* @since 1.0
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class Tester {
	// variables used to store student information and activity information
	public static Student[] students = new Student[69];
	public static Activity[] activities = new Activity[18];
	// the code runs here
	public static void main(String[] args) throws FileNotFoundException {
		// Store all inputs to the arraylist
        Scanner scanner = new Scanner(new File("SrSeminar_Arranged.csv"));
        scanner.useDelimiter(",");
        ArrayList<String> input = new ArrayList<>();
        while(scanner.hasNext()){
			String cur = scanner.next();
            input.add(cur);
            //System.out.println(cur);
        }
        scanner.close();
        store_data(input);
        
        // prints students and activies
        for (int i = 0; i < students.length; i ++) {
			System.out.println(students[i]);
		}
		for (int i = 0; i < activities.length; i ++) {
			System.out.println(activities[i]);
		}
    } // end of public static void main
    
    // pass the arraylist with all inputs to the store data method and construct Student and Activity
    public static void store_data(ArrayList<String> input) {
		// construct Student
        for (int i = 0; i < 69; i ++) {
			String email = input.remove(0);
			String name = input.remove(0) + " " + input.remove(0);
			int[] choice = new int[5];
			for (int j = 0; j < 4; j ++) {
				choice[j] = Integer.parseInt(input.remove(0));
			}
			choice[4] = Integer.parseInt(input.get(0).substring(0, 1));
			String format_last_string = input.get(0);
			format_last_string = format_last_string.replaceAll("[\\n]", "");
			input.set(0, format_last_string);
			Student s = new Student(email, name, choice);
			students[i] = s;
		}
		// construct Activity
		while (input.size() != 0) {
			String name = input.remove(0);
			int id = Integer.parseInt(input.remove(0));
			String presenter = input.remove(0);
			activities[id - 1] = new Activity(name, presenter);
			for (int j = 0; j < 4; j ++) {
				input.remove(0);
			}
			if (input.size() != 0) input.set(0, input.get(0).replaceAll("[\\n]", ""));
		}
	} // end of store data method
} // end of Tester class
