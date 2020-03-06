package training;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Training {

   public static void main(String[] args) {

       int N;
       int K;

       N = 5;
       K = 3;
       int[] places = {2, 5, 7, 1, 4};
       ArrayList<ArrayList<ArrayList<Integer>>> days = new ArrayList<ArrayList<ArrayList<Integer>>>(); // The possible days

       // Gets ArrayList with the maximum days
       int x = 0;
       while (x < places.length - (K - 1)) {
           // Get the first full day
           ArrayList<ArrayList<Integer>> schedule = new ArrayList<ArrayList<Integer>>();
           int[] placesSplit = places.clone();
           ArrayList<Integer> fullDay = new ArrayList<Integer>();
           for (int i = 0; i < K; i++) {
               fullDay.add(places[x + i]);
               placesSplit[x + i] = -1;
           }
           schedule.add(fullDay);
           System.out.println(fullDay);
           System.out.println(Arrays.toString(placesSplit));

           // Splits remaining array into two seperate arrays
           int y = 0;
           int last = placesSplit.length - 1;
           if (placesSplit[0] != -1 ^ placesSplit[last] != -1) { // If one of the selected integers (the one in full day) was at the front of the array. Note: ^ is XOR operator
               ArrayList<Integer> splitArray = new ArrayList<Integer>(); // Seeing as array can only be split in two, no need for two arrays
               if (placesSplit[0] != -1) {
                   while (placesSplit[y] != -1 && y < last) {
//                        System.out.println(placesSplit[y]);
                       splitArray.add(placesSplit[y]);
                       y += 1;
                   }
               }
               if (placesSplit[last] != -1) { // Altertnativley, if the 'fullDay' integers are at the end of the array
                   y = last;
                   while (placesSplit[y] != -1 && y > 0) {
                       splitArray.add(placesSplit[y]);
//                        System.out.println(placesSplit[y]);
                       y -= 1;
                   }
               }
               System.out.println(splitArray);
               // Add splitArray to the final schedule array
               schedule.add(splitArray);
           } else {
               ArrayList<Integer> splitArray1 = new ArrayList<Integer>();
               ArrayList<Integer> splitArray2 = new ArrayList<Integer>();
               boolean listSelect = false; // If listSelect is false, numbers will be appended to splitArray1. If true, numbers are appended to splitArray2
               for (int i = 0; i < placesSplit.length; i++) { // Iterates through the list of numbers, such to put
                   if (placesSplit[i] == -1) {
                       listSelect = true;
                   } else {
                       if (listSelect == false) {
                           splitArray1.add(placesSplit[i]);
                       } else {
                           splitArray2.add(placesSplit[i]);
                       }
                   }
               }
//                System.out.println("Lists:");
//                System.out.println(splitArray1);
//                System.out.println(splitArray2);
               // Add the splitArray1 and splitArray2 to the final schedule array
               schedule.add(splitArray1);
               schedule.add(splitArray2);
           }
           System.out.println("Schedule:");
           System.out.println(schedule);
           days.add(schedule);
           x += 1;
       }

       // Find which days in the days ArrayList have the leastamount of days to complete the whole thing in
       int shortest = days.get(0).size(); // Gets the size of the first ArrayList (days) and then compares all of them
       int shortestIndex = 0;
       int daysLength = days.size();
       ArrayList<Integer> same = new ArrayList<Integer>(); // Contains the other indexes with the same value, such that if shortestIndex is changed, all of the indexes with the same value are also deleted
       for (int i = 0; i < daysLength; i++) {
           int size = days.get(i).size();
           if (size > shortest) {
               days.remove(i);
               i--;
               daysLength--;
           } else if (size < shortest) {
               days.remove(shortestIndex);
               int factor = 0;
               for (int j = 0; j < same.size(); j++) { // Probably buggered up this bit
                   days.remove(same.get(j)-factor);
                   factor++;
               }
               shortest = size;
               shortestIndex = i;
               i -= factor;
           } else if (size == shortest) {
               same.add(i);
           }
       }
       System.out.println(days);

       // Goes through each of the days and performs the calucations to find it's total score
       ArrayList<Integer> scores = new ArrayList<Integer>();

       for (int i = 0; i < days.size(); i++) {
           ArrayList<ArrayList<Integer>> eachSchedule = days.get(i);
           int score = 0;
           for (int j = 0; j < eachSchedule.size(); j++) { // For each of the days
               int max = 0;
               for (int k = 0; k < eachSchedule.get(j).size(); k++) // For each of the scores for each day. Iterates through each of the scores in the array and picks the largest
                   if (eachSchedule.get(j).get(k) > max) {
                       max = eachSchedule.get(j).get(k);
                   }
               score += max;
           }
           scores.add(score);
       }

       // Find which schedule has the largest score
       int maxSchedule = 0;
       int maxIndex = 0;
       for (int i = 0; i < scores.size(); i++) {
           if (scores.get(i) > maxSchedule) {
               maxSchedule = scores.get(i);
               maxIndex = i;
           }
       }
       System.out.print("Largest total score: ");
       System.out.println(maxSchedule);
       System.out.print("Associated schedule: ");
       System.out.println(days.get(maxIndex));


   }
}

