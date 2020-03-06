package eightteen_S_five;
public class Portals {
	String planeta;
	String planetb;
	String city;
	int cost;
        String addressLeave;
        String addressArrive;
	public Portals(String a, String b, String c, int cost){
		planeta = a;
		planetb = b;
		city = c;
		this.cost = cost;
                addressLeave = planetb +"," + city;
                addressArrive = planeta+ ","+city;
	}
}
