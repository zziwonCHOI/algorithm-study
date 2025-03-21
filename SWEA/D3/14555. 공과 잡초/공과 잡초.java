import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T=Integer.parseInt(br.readLine());
		for( int t=1;t<=T; t++) {
			String s=br.readLine();
			int cnt=0;
			char prev=0;
			for(int i=0; i<s.length(); i++) {
				char c=s.charAt(i);
				if(prev=='('&&c=='|') {
					cnt++;
				}else if(prev=='|'&&c==')') {
					cnt++;
				}else if(prev=='('&&c==')') {
					cnt++;
				}
				prev=c;
			}
			
			System.out.println("#"+t+" "+cnt);
		}
	}

}