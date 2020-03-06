package eightteen_S_five;
public class Flight {
	String planet;
	String citya;
	String cityb;
	int cost;
         String addressLeave;
        String addressArrive;
	public Flight(String a, String b, String planet, int cost) {
		this.planet = planet;
		citya = a;
		cityb = b;
		this.cost = cost;
                addressLeave = planet+","+citya;
                addressArrive = planet+","+cityb;
	}
       
}
