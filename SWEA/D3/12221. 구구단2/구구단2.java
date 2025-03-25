
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			
			String[] input=br.readLine().split(" ");
			
			int a=Integer.parseInt(input[0]);
			int b=Integer.parseInt(input[1]);
			int result=0;
			if(a<10 && b<10) {
				result=a*b;
			}else {
				result=-1;
			}
			
			System.out.println("#"+t+" "+result);
		}

	}

}
