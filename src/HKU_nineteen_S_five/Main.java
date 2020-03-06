/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HKU_nineteen_S_five;
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
    int nodes;
    long mindistance;
    int max = 0;
    ArrayList<String> sets = new  ArrayList();
    ArrayList<String> temps = new ArrayList();
    long [][] connections;
    public Main() throws IOException{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         String x = br.readLine();
         BreakInput(x);
         SetNodesandDistance();
         connections = new long [3][nodes-1];
         for(int i =0; i<nodes-1;i++){
             x = br.readLine();
             BreakInput(x);
             SetUpConnections(i);
         }
         for(int i =0; i<nodes-1;i++){
             x = br.readLine();
             NewSets(x);
         }
         PassMin();
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
    public void SetNodesandDistance(){
        nodes = Integer.parseInt(temps.get(0));
        mindistance = Integer.parseInt(temps.get(1));
        for(int i =0; i<nodes;i++){
            sets.add(String.valueOf(i));
        }
    }
    public void SetUpConnections(int i){
        for(int j= 0;j<3;j++){
        connections[j][i] = Long.parseLong(temps.get(j));
        }
    }
    public void NewSets(String x){
        sets.add(x);
    }
    public void PassMin(){
        for(int i = nodes-1;i< 2*nodes +1 ; i++){
            BreakInput(sets.get(i));
            long max = 0;
            for(int j = 0; j<temps.size();j++){
                for(int k = 0; k<temps.size();k++){
                    if(k!= j){
                        long r =FindPath(temps.get(j),temps.get(k));
                        if(r>max){
                            max = r;
                        }
                    }   
                }
            }
        }
    }
    public long FindPath(String x, String y){
        long max = 0;
        long mapping [][] = new long [2][nodes-1];
        for(int i = 0; i<nodes -1; i++){
            mapping[0][i]= i;
            //if(LeadsToPath(i,Long.parseLong(y))){
              //  mapping[1][i] = this.max;
            //}
            this.max =0;
        }
        return max;
    }
    public int LeadsToPath(int r, long x, long y, int l){
        int max = 0;
        if(0<nodes-1){
            for(int i =0; i<nodes-1; i++){
                if(connections[0][i] == x){
                   this.max+= connections[2][i];
                   if(y==connections[1][i]){
                       break;
                   }
                   else{
                       LeadsToPath(i,connections[1][i],y,l++);
                   }
                }
                else if(connections[1][i] == x){
                    max+=connections[2][i];
                   if(y==connections[0][i]){
                       break;
                   }
                   else{
                       LeadsToPath(i,connections[0][i],y,l++);
                   }
                }
            }
        }
        return max;
    }
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
    }
    
}
