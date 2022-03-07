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
	public static void main(String[] args) throws FileNotFoundException {
		// Trying to take all the inputs, and also construct Student and Activity
        Scanner scanner = new Scanner(new File("SrSeminar_Arranged.csv"));
        Student[] students = new Student[69];
        for (int i = 0; i < 69; i ++) {
			scanner.useDelimiter(",");
			String email = scanner.next();
			String name = scanner.next() + " " + scanner.next();
			System.out.println(email + " " + name);
			int[] choice = new int[5];
			for (int j = 0; j < 5; j ++) {
				choice[i] = scanner.nextInt();
				System.out.println(choice[i]);
			}
			System.out.println(choice[0]);
			scanner.nextLine();
		}
		// the map link the activity id and activity descriptions
		Map<Integer, Activity> activity_id_name = new HashMap<>();
		for (int i = 0; i < 18; i ++) {
			String name = scanner.next();
			int id = scanner.nextInt();
			String presenter = scanner.next();
			activity_id_name.put(id, new Activity(name, presenter));
		}
        scanner.close();
    } // end of public static void main
} // end of Tester class
