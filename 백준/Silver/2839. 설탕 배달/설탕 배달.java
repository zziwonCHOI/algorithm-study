
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		
		int cnt=0;
		
		while(true) {
			if(n%5==0) {
				cnt+=n/5;
				break;
				
			}
			
			if(n<0) {
				cnt=-1;
				break;
			}
			cnt++;
			n-=3;
		}
		
		System.out.println(cnt);
		
		
	}

}
