/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nineteen_S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.*;
import java.util.ArrayList;


/**
 *
 * @author Siddarth Natarajan
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    int length;
    int maxPerDay;
    long []scores;
    ArrayList<String> temps = new ArrayList();
     public void BreakInput(String l, int r){
         temps.clear();
          l+=" ";
           int k = 0;
           for(int i =0; i<r; i++){
               String temp ="";
               while(!(" ".equals(String.valueOf(l.charAt(k))))){
                   temp+=String.valueOf(l.charAt(k));
                   k++;
               }
               k++;
               temps.add(i,temp);
           }
        }
    public void Setter(String l){
        BreakInput(l,2);
        this.length = Integer.parseInt(temps.get(0));
        maxPerDay = Integer.parseInt(temps.get(1));
        scores = new long[length];
    }
    public void SetUpScores(String l){
        BreakInput(l,length);
        for(int i = 0; i<length; i++){
            scores[i] = Long.parseLong(temps.get(i));
        }
    }
    public long MaxScore(){
        long max = 0;
        if(length%maxPerDay == 0){
            long tempmax =-1;
            int l =0;
            for(int i = 0; i<length; i++){
                        if(l<maxPerDay){
                            if(scores[i]>tempmax){
                                tempmax =scores[i];
                                l++;
                            }
                        }
                        else{
                            l=0;
                            System.out.println(tempmax);
                            max+=tempmax;
                            tempmax=0;
                            i--;
                        }
                }
            max+=tempmax;
            System.out.println(tempmax);
        }
        else{
            int [] SubMaxes = new int[Math.round(length/maxPerDay)+1];
            int leftover = length - Math.round(length/maxPerDay)*maxPerDay;
            for(int j = 0; j<Math.round(length/maxPerDay)+1; j++){
                long superpose =0;
                long[] tempscore = scores.clone();
                for(int k= 0; k<leftover; k++){
                    if(tempscore[k+maxPerDay*j]>superpose){
                        superpose = tempscore[k];
                    }
                    tempscore[k] =0;
                }
                long tempmax = -1;
                int l =0;
                for(int i = 0; i<length; i++){
                    if(tempscore[i]!=0){
                        if(l<maxPerDay){
                            if(tempscore[i]>tempmax){
                                tempmax =tempscore[i];
                                l++;
                            }
                        }
                        else{
                            l=0;
                            SubMaxes[j]+=tempmax;
                            tempmax=0;
                            i--;
                        }
                    }
                }
                SubMaxes[j]+=tempmax;
                SubMaxes[j]+=superpose;
                if(SubMaxes[j]>max){
                    max= SubMaxes[j];
                }
            }
        }
        return max;
    }

   ArrayList<String> input;

   public void Reader() throws Exception {
       File file = new File("C:\\Users\\Siddarth Natarajan\\Documents\\CCC\\2019_TestData\\all_data\\all_data\\s4\\s4.1-16.in");
       BufferedReader reader = new BufferedReader(new FileReader(file));

       ArrayList<String> input = new ArrayList<String>();
       String in;
       while ((in = reader.readLine()) != null) {
           input.add(in);
       }

       this.input = input;
       getN();
       getK();
       getValues();
   }

   public void getN() {
       length = Integer.parseInt(input.get(0).split(" ")[0]);
   }

   public void getK() {
       maxPerDay= Integer.parseInt(input.get(0).split(" ")[1]);
   }

   public void getValues() {
       String[] stringValues = input.get(1).split(" ");
       scores = new long [length];
       for (int i = 0; i < stringValues.length; i++) {
           scores[i] = Integer.parseInt(stringValues[i]);
       }
   }

    public static void main(String[] args) throws IOException, Exception {
        // TODO code application logic here
        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String x = br.readLine();
        String y = br.readLine();
        Main object = new Main();
        object.Setter(x);
        object.SetUpScores(y);*/
        Main object = new Main();
        object.Reader();
        System.out.println(object.MaxScore());
    }
    
}
