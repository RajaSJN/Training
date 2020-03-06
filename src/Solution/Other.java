/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Solution;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Siddarth Natarajan
 */
public class Other {
    public static int [] solution(int elements[], int n){
        ArrayList<Integer> finalset = new ArrayList<>();
        ArrayList<Integer> count = new ArrayList<>();
       if(n!=0){
        for(int i = 0; i<elements.length;i++){
            if(!finalset.contains(elements[i])){
                finalset.add(elements[i]);
                count.add(1);
                }
            else if(finalset.contains(elements[i])){
                    int position = finalset.indexOf(elements[i]);
                    int temp = count.get(position);
                    count.set(position, temp+1);
                }
            }
        }
        int sum =0;
        for(int i =0; i<count.size(); i++){
            if(count.get(i)>n){
                count.remove(i);
                finalset.remove(i);
                i--;
            }
            else{
                sum+= count.get(i);
            }
        }
        int [] finals = new int [sum];
        int k =0;
        for(int i = 0; i<elements.length;i++){
            if(k<sum){
                if((finalset.contains(elements[i]))){
                finals[k] = elements[i];
                k++;
            }
            else{
                i++;
            }
            }
            else{
                break;
            }
        }
        return finals;
    }
    public static int[] solutions(int[] data, int n) {
        ArrayList<Integer> items = new ArrayList<Integer>();
        for(int i = 0; i < data.length; i++) {
            int count = 0;
            for(int j = 0; j < data.length; j++) {
                if(data[j]==data[i]) {
                    count++;
                }
            }
            if(count<n+1) {
                items.add(data[i]);
            }
        }
        int[] newData = new int[items.size()];
        for(int i = 0; i < items.size(); i++) {
            newData[i]=items.get(i);
        }
        return newData;
    }
    public static void main(String[] args) {
		int[] data = {420, 69, 501, 414, 212, 221, 69, 420, 414, 414, 414, 0, 70, 69, 501};
		int[] other = {1, 1, 1, 3, 4, 6, 3};
		int[] zero = {};
		int[] one = {1};
		int[] pairs = {2147483647, 3 + 1, 2, 2, 3, 3, 4};
		int[] ten = {1, 1, 1, 1, 2, 3, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 3, 4, 10};
		int[] max = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63,64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98};
                System.out.println(Arrays.toString(solution(pairs, 2)));
	}	
}
