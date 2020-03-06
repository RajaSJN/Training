package Solution;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) {
		int[] data = {420, 69, 501, 414, 212, 221, 69, 420, 414, 414, 414, 0, 70, 69, 501};
		int[] other = {1, 1, 1, 3, 4, 6, 3};
		int[] zero = {};
		int[] one = {1};
		int[] pairs = {1, 3 + 1, 2, 2, 3, 3, 4};
		int[] ten = {1, 1, 1, 1, 2, 3, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 3, 4, 10};
		int[] max = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63,64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98};
                int [] it = {0,0,0};
		System.out.println(Arrays.toString(solution(pairs, 1)));
		
	}
	
	public static int[] solution(int[] data, int n) {
		
		System.out.println(Arrays.toString(data));
		ArrayList<Integer> uniqueIDs = new ArrayList<Integer>();
		ArrayList<Integer> temp = new ArrayList<Integer>(); //to store data in to facilitate removal of IDs
		
		//If n is 0
		if (n <= 0) {
			int[] blank = {};
			return blank;
		}
		
		//Changing data to an ArrayList & imposing length restrictions
		for (int i = 0; i < data.length; i++) {
			if (i < 99) {
				temp.add(data[i]);
			}
		}
		
		//Finding unique IDs
		for (int i = 0; i < temp.size(); i++) {
			if (!uniqueIDs.contains(temp.get(i))) {
				uniqueIDs.add(temp.get(i));
			}
		}
		System.out.println("Finding unique IDs: " + uniqueIDs.toString());
		
		//Removing repeat IDs
		for (int i = 0; i < uniqueIDs.size(); i++) {
			System.out.println("ID: " + uniqueIDs.get(i));
			int count = 0;
			
			for (int j = 0; j < temp.size(); j++) {
				if (uniqueIDs.get(i).toString().equals(temp.get(j).toString())) {
					count++;
					System.out.println("Count: " + count);
				}
			}
			
			if (count > n) {
				for (int k = 0; k < temp.size(); k++) {
					if (uniqueIDs.get(i) == temp.get(k)) {
						System.out.println("Removed: " + temp.get(k));
						System.out.println(temp.toString());
						temp.remove(k);
						k--;
					}
				}
			}
		}
		
		//Changing temp back into array
		int[] answer = new int[temp.size()];
		for (int i = 0; i < temp.size(); i++) {
			answer[i] = temp.get(i);
		}
		
		return answer;
    }
}
