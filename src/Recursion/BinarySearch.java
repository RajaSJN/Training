/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursion;

/**
 *
 * @author Siddarth Natarajan
 */
public class BinarySearch {

    /**
     * @param args the command line arguments
    */
    static int [] x = {2,3,4,5,6,7,8,9,10,12};
    static int max = x.length-1;
    static int min = 0;
    static boolean BinarySearch(int value, int max, int min){
        int median = (max+min)/2;
        if((x[median] == value) || (x[max] == value) || (x[min] == value) ){
            return true;
        }
        if(x[median]> value){
            return BinarySearch(value,median,min);
        }
         if(x[median]< value){
            return BinarySearch(value,max,median);
        }
        if(max-min <= 3){
            return false;
        }
         return false;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(BinarySearch(7,max,min));
    }
    
}
