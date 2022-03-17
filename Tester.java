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
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.stream.IntStream;
import java.util.Deque;
import java.util.ArrayDeque;
//import java.util.Intstream;
public class Tester {
	// variables used to store student information, individual activity information, popularity of the session, and the final result
	public static Student[] students = new Student[69];
	public static Activity[] activities = new Activity[18];
	public static Session[] sessions = new Session[18];
	// result: row = time spot, column = session in the time spot, each item stores the meeting id at first and the student id afterward
	public static List<List<Integer>> session_placement = new ArrayList<>();
	// students_in_session: gives the student in each session
	public static List<List<List<Integer>>> students_in_session = new ArrayList<>();
	// the code runs here
	public static void main(String[] args) throws FileNotFoundException {
		// Store all inputs to the arraylist
        Scanner scanner = new Scanner(new File("SrSeminar_Arranged.csv"));
        scanner.useDelimiter(",");
        ArrayList<String> input = new ArrayList<>();
        while(scanner.hasNext()){
			String cur = scanner.next();
            input.add(cur);
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
		System.out.println("\n\n\n");
		
		// rank popularity and print out popularity
		sort_popular_session();
		for (int i = 0; i < sessions.length; i ++) {
			System.out.println(sessions[i]);
		}
		System.out.println("\n\n");
		
		// contruct the metting id
		construct_time_spot();
		System.out.println("row = time");
		System.out.println("column = session");
		for (int i = 0; i < 5; i ++) {
			System.out.println(session_placement.get(i));
		}
		
		add_students();
		
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
	
	// method used to rank the popular session from most popular to least popular
	public static void sort_popular_session() {
		for (int i = 0; i < sessions.length; i ++) {
			sessions[i] = new Session(i, 0);
		}
		for (int i = 0; i < students.length; i ++) {
			int[] cur_choice = students[i].get_choice();
			for (int j = 0; j < cur_choice.length; j ++) {
				sessions[cur_choice[j] - 1].increase_popularity(5 - j);
			}
		}
		Arrays.sort(sessions);
	} // end of the sorting popular session method
	
	// this method construct the result (i.e. give session id at each spot)
	public static void construct_time_spot() {
		for (int i = 0; i < 5; i ++) {
			session_placement.add(new ArrayList<>());
		}
		// my algorithm to construct the sessoin id
		for (int j = 0; j < 6; j ++) {
			for (int i = 0; i < 5; i ++) {
				int[] index_to_loop = new int[5];
				if (j == 0) {
					index_to_loop = IntStream.of(0, 1, 2, 3, 4).toArray();
				} else if (j == 1) {
					index_to_loop = IntStream.of(4, 0, 1, 2, 3).toArray();
				} else if (j == 2) {
					index_to_loop = IntStream.of(5, 6, 7, 8, 9).toArray();
				} else if (j == 3) {
					index_to_loop = IntStream.of(9, 5, 6, 7, 8).toArray();
				} else if (j == 4) {
					index_to_loop = IntStream.of(10, 11, 12, 13, 14).toArray();
				} else {
					index_to_loop = IntStream.of(15, 16, 17, 10, 11).toArray();
				}
				session_placement.get(i).add(sessions[index_to_loop[i]].get_id());
			}
		}
	} // end of the constructing meting id method
	
	// this method adds students to the constructed array and finishes the project
	public static void add_students() {
		//initualize students_in_session to the correct size
		for (int i = 0; i < 5; i ++) {
			students_in_session.add(new ArrayList<>());
			for (int j = 0; j < 6; j ++) {
				students_in_session.get(i).add(new ArrayList<>());
			}
		}
		for (int i = 0; i < students_in_session.size(); i ++) {
			System.out.println(students_in_session.get(i));
		}
		// unpaired staudent: [student id, time spot]
		Deque<List<Integer>> unpaired_students = new ArrayDeque<>();
		for (int i = 0; i < students.length; i ++) { // loop through student
			int[] choice_array = students[i].get_choice();
			List<Integer> choice = new ArrayList<>();
			for (int j = 0; j < 5; j ++) { // creates choice in arraylist
				choice.add(choice_array[j] - 1);
			}
			for (int j = 0; j < 5; j ++) { // loop through each day
				boolean flag = false;
				for (int k = 0; k < choice.size(); k ++) { // loop through each choice left over
					if (flag) {
						break;
					}
					for (int l = 0; l < 6; l ++) { // loop through each session
						if (session_placement.get(j).get(l) == choice.get(k) && students_in_session.get(j).get(l).size() <= 15) {
							students_in_session.get(j).get(l).add(i);
							choice.remove(k);
							flag = true;
							break;
						}
					}
				}
			}
		}
		for (int i = 0; i < students_in_session.size(); i ++) {
			System.out.println(students_in_session.get(i));
		}
	}
} // end of Tester class
