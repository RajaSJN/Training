/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sixteen_S_five;

/**
 *
 * @author Siddarth Natarajan
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
public class Main {
    LinkedList<Integer> cells = new LinkedList();
    ArrayList<String> temps = new ArrayList();
    long generations;
    int size;
    public void SetUpValues(String l){
       BreakInput(l);
       generations = Long.valueOf(temps.get(1));
       size = Integer.valueOf(temps.get(0));
    }
    public void BreakInput(String l){
            temps.clear();
             int k = 0;
            for(int j = 0; j<l.length();j++){
                temps.add("");
                if(!" ".equals(String.valueOf(l.charAt(j)))){
                    String supertemp = temps.get(k);
                    temps.add(k, supertemp+=l.charAt(j));
                }
                else{
                    k++;
                    temps.add("");
                }
            }
        }
    public void SetUpLL(String y){
        for(int i = 0; i< size;i++){
            String x ="";
            x+= y.charAt(i);
            cells.add(Integer.valueOf(x));
        }
    }
    public String living(){
        String r="";
        int x;
        int y;
        boolean [] condition = new boolean[size];
        for(long i = 0; i<generations; i++){
            for(int j = 0; j<size; j++){
                // let x be left value 
                // let y be right value
                x=j-1;
                if(x<0){
                    x=size-1;
                }
                y =(j+1)%size;
                if((cells.get(x)==1&&cells.get(y)==0)||(cells.get(y)==1&&cells.get(x)==0)){
                    condition[j] = true;
                }
                else{
                    condition[j] = false;
                }
            }
            for(int k= 0; k<size; k++){
                if(condition[k]){
                    cells.add(k,1);
                }
                else{
                    cells.add(k,0);
                }
            }
        }
        for(int i = 0; i<size; i++){
            r+= String.valueOf(cells.get(i));
        }
        return r; 
    }
    public static void main(String[] args) throws IOException {
        Main object = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String l = br.readLine();
        object.SetUpValues(l);
        String y = br.readLine();
        object.SetUpLL(y);
        System.out.println( object.living());
    }
 
}
