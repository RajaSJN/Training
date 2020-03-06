package seventeen_S_one;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
	int days;
	int [][] Teams;
	public Main( int x ) {
		days = x;
                Teams= new int[2][days];
	}
	public int CalcEqualDay() {
		int sumTeamA = 0;
		int sumTeamB =0;
		int matchday =0;
		for(int i = 0; i<days; i++) {
			sumTeamA += Teams[0][i];
			sumTeamB += Teams[1][i];
			if(sumTeamA== sumTeamB) {
				matchday = i+1;
			}
		}
		return matchday;
	}
        public void InputValues(String x, int l){
             for(int i = 0; i<days; i++) {
			Teams[l][i] = Integer.valueOf(x.charAt(2*i));
		}
        }
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String l = br.readLine();
                int days = Integer.parseInt(l);
                Main object = new Main(days);
                String x = br.readLine();          
                object.InputValues(x, 0);
                String y= br.readLine();
                object.InputValues(y, 1);
		System.out.print(object.CalcEqualDay());
    }
}
