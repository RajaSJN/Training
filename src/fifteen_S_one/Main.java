/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifteen_S_one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Siddarth Natarajan
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    ArrayList<Integer> numbers = new ArrayList<>();
    int length;
   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public Main() throws IOException{
        setLength();
        setNumbers();
        System.out.println(Sum());
    }
     public void setLength() throws IOException{
         String l=br.readLine();
         length=Integer.parseInt(l);
         
     }
     public void setNumbers() throws IOException{
         for(int i = 0;i<length;i++){
             String x = br.readLine();
             if(Integer.parseInt(x)==0){
                 numbers.remove(numbers.size()-1);
             }
             else{
                 numbers.add(Integer.parseInt(x));
             }
         }
     }
     public int Sum(){
         int sum=0;
         for(int i = 0; i<numbers.size();i++){
             sum+=numbers.get(i);
         }
         return sum;
     }
    public static void main(String[] args) throws IOException {
        Main object = new Main();
    }
    
}
