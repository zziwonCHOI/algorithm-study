import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws  IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T=Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			st=new StringTokenizer(br.readLine());
			int l=Integer.parseInt(st.nextToken());
			int u=Integer.parseInt(st.nextToken());
			int x=Integer.parseInt(st.nextToken());
			int result=0;
			
			
			if(x>=u) {
				result=-1;
			}else if (x<u&&x>=l) {
				result=0;
			}else if(x<l) {
				result=l-x;
			}
			System.out.println("#"+t+" "+result);
			
		}
	}

}