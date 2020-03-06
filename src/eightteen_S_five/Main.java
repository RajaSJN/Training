package eightteen_S_five;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class Main {
    public ArrayList<String> temps = new ArrayList();
    int PlanetNumbers;
    int CityNumbers;
    int FlightNumber;
     // minimum number of portals required will be NumberofPlanets-1
    int PortalNumber;
    Flight [][] flights;
    Portals [][] portals ;
    // This is how to minimise, you create a circuit hence each vertex will be passed only once, but make sure to stop right before start point
    String [] PassedPaths;
    String [] inputs;
    int k;
        public void SetUptFlights() throws IOException{
             for(int i= 0; i<FlightNumber ;i++){
                String temp = inputs[i];
                BreakInput(temp);
                for(int k = 0; k<PlanetNumbers;k++){
                  flights[k][i] = new Flight(temps.get(0),temps.get(1),String.valueOf(k+1),Integer.valueOf(temps.get(2)));   
                }
            }
        }
        public void SetUpPortals() throws IOException{
             for(int i= 0; i<PortalNumber ;i++){
                String temp =inputs[i+FlightNumber];
                BreakInput(temp);
                for(int k=0;k<CityNumbers;k++){
                portals[k][i] = new Portals(temps.get(0),temps.get(1),String.valueOf(k+1),Integer.valueOf(temps.get(2)));
                }
            }
        }
        // This acts as a constructor
        public void SetUpValues(String l){
            BreakInput(l);
             PlanetNumbers = Integer.valueOf(temps.get(0));
            CityNumbers = Integer.valueOf(temps.get(1));
            FlightNumber = Integer.valueOf(temps.get(2));
     // minimum number of portals required will be NumberofPlanets-1
             PortalNumber = Integer.valueOf(temps.get(3));
                flights = new Flight [PlanetNumbers][FlightNumber];
    portals = new Portals [CityNumbers][PortalNumber];
    // This is how to minimise, you create a circuit hence each vertex will be passed only once, but make sure to stop right before start point
    PassedPaths = new String [CityNumbers*PlanetNumbers];
    inputs = new String[FlightNumber+PortalNumber];
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
        public int TotalCost(){
            int cost =0;
             for(int j = 0; j<FlightNumber; j++){
                    for(int i = 0; i<PlanetNumbers;i++){
                        cost+=flights[i][j].cost;
                    }
             }
             for(int j = 0; j<PortalNumber; j++){
                    for(int i = 0; i<CityNumbers;i++){
                        cost+=portals[i][j].cost;
                    }
             }
             return cost;
        }
        public int FindMinPath(){
            // All the planets and cities start from 1
            String startpoint = "1,1";
            String endpoint ="";
            PassedPaths[0] = startpoint;
            int cost = 0;
            k = 1;
            
            while(k<CityNumbers*PlanetNumbers){
            int mincost= 1000; 
                boolean firsttime = true;
                for(int j = 0; j<FlightNumber; j++){
                    for(int i = 0; i<PlanetNumbers;i++){
                        if(CheckPath(flights[i][j].addressArrive)){
                            if(flights[i][j].addressLeave.equals(startpoint)){
                            if(!(flights[i][j].addressLeave.equals(flights[i][j].addressArrive))){
                                if(firsttime){
                                    System.out.println("This conidition ran");
                                    mincost = flights[i][j].cost;
                                    endpoint = flights[i][j].addressArrive;
                                    firsttime = false;
                                }
                                else if(flights[i][j].cost<mincost){
                                    mincost = flights[i][j].cost;
                                    endpoint = flights[i][j].addressArrive;
                                    System.out.println("Nien 2");
                                }
                            }
                        }}
                        else if(CheckPath(flights[i][j].addressLeave)){
                            if(flights[i][j].addressArrive.equals(startpoint)){
                            if(!(flights[i][j].addressArrive.equals(flights[i][j].addressLeave))){
                                if(firsttime){
                                    System.out.println("nien 3");
                                    mincost = flights[i][j].cost;
                                    endpoint = flights[i][j].addressLeave;
                                    firsttime = false;
                                }
                                else if(flights[i][j].cost<mincost){
                                    System.out.println("nien 4");
                                    mincost = flights[i][j].cost;
                                    endpoint = flights[i][j].addressLeave;
                                }
                            }
                        }}
                    }
                }
                 for(int j = 0; j<PortalNumber; j++){
                    for(int i = 0; i<CityNumbers;i++){
                       if(CheckPath(portals[i][j].addressArrive)){
                        if(portals[i][j].addressLeave.equals(startpoint)){
                            if(!(portals[i][j].addressLeave.equals(portals[i][j].addressArrive))){
                                if(firsttime){
                                    System.out.println("nien 5");
                                    mincost = portals[i][j].cost;
                                    endpoint = portals[i][j].addressArrive;
                                    firsttime = false;
                                }
                                else if(portals[i][j].cost<mincost){
                                    System.out.println("nien 6");
                                    mincost = portals[i][j].cost;
                                    endpoint = portals[i][j].addressArrive;
                                }
                            }
                        }
                       }else if(CheckPath(portals[i][j].addressLeave)){
                        if(portals[i][j].addressArrive.equals(startpoint)){
                            if(!(portals[i][j].addressArrive.equals(portals[i][j].addressLeave))){
                                if(firsttime){
                                    System.out.println("nien 7");
                                    mincost = portals[i][j].cost;
                                    endpoint = portals[i][j].addressLeave;
                                    firsttime = false;
                                }
                                else if(portals[i][j].cost<mincost){
                                    System.out.println("nien 8");
                                    mincost = portals[i][j].cost;
                                    endpoint = portals[i][j].addressLeave;
                                }
                            }
                        }
                       }
                    }
                }
                System.out.println(k);
                PassedPaths[k]= endpoint;
                startpoint = endpoint;
                 k++;   
                cost+=mincost;
                System.out.println(mincost);
            }
            return TotalCost()- cost;
        }
        public boolean CheckPath(String x){
            for(int i = 0; i<k;i++){
                if(PassedPaths[i].equals(x)){
                    return false;
                }
            }
            return true;
        }
	   public static void main(String[] args) throws IOException {
            Main object = new Main();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String l = br.readLine();
            object.SetUpValues(l);
            for(int i = 0; i<object.FlightNumber+object.PortalNumber; i++){
                object.inputs[i] = br.readLine();
            }
            object.SetUptFlights();
            object.SetUpPortals();
            System.out.println(object.FindMinPath());
            for( int i = 0; i<object.PassedPaths.length; i++){
                System.out.println(object.PassedPaths[i]);
            }
       }
}
