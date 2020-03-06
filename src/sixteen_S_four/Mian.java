/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sixteen_S_four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
/**
 *
 * @author Siddarth Natarajan
 */
public class Mian {

    /**
     * @param args the command line arguments
     */
     ArrayList<Integer> balls = new ArrayList();
    ArrayList<String> temps = new ArrayList();
    int size;
    public void SetUpValues(String l){
       size = Integer.valueOf(l);
    }
    public void SetBalls(String l){
        BreakInput(l);
        for(int i = 0; i<size; i++){
            balls.add(Integer.parseInt(temps.get(i)));
        }
    }
    public void BreakInput(String l){
          // you could also do try and catch, but this is less lines
            l+=" ";
           int k = 0;
           for(int i =0; i<size; i++){
               String temp ="";
               while(!(" ".equals(String.valueOf(l.charAt(k))))){
                   temp+=String.valueOf(l.charAt(k));
                   k++;
               }
               k++;
               temps.add(i,temp);
           }
        }
    public int MaxWeight(){
        int weight = 0;
        int i = 0;
        while(i<balls.size()){
            try{
                if(balls.get(i-1).equals(balls.get(i+1))){
                    int temp = balls.get(i)+balls.get(i-1)+balls.get(i+1);
                    balls.remove(i-1);
                    balls.remove(i-1);
                    balls.remove(i-1);
                    balls.add(i-1,temp);
                    i =0;
                }
                else if(balls.get(i).equals(balls.get(i+1))){
                     int temp = balls.get(i)+balls.get(i+1);
                    balls.remove(i);
                    balls.remove(i);
                    balls.add(i,temp);
                    i= 0;
                }
                i++;
            }
            catch(Exception e){
                i++;
            }
        }
          for(int j = 0; j<balls.size();j++){
            if(balls.get(j)>weight){
                weight = balls.get(j);
            }
        }
        return weight;
    }
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Mian object = new Mian();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String l = br.readLine();
        object.SetUpValues(l);
        String x = br.readLine();
        object.SetBalls(x);
        System.out.println(object.MaxWeight());
    }
    
}
