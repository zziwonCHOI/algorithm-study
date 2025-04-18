import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T=Integer.parseInt(br.readLine());
		for(int t=1; t<=T;t++) {
			int n=Integer.parseInt(br.readLine());
			int[] nums=new int[n+1];
			int[] pos=new int[n+1];
			
			st=new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				nums[i]=Integer.parseInt(st.nextToken());
				pos[nums[i]]=i;
			}
			
			int maxLen=1;
			int len=1;
			
			for(int i=2; i<=n; i++) {
				if(pos[i-1]<pos[i]) {
					len++;
					maxLen=Math.max(maxLen, len);
				}else {
					len=1;
				}
			}
			
			int result=n-maxLen;
			System.out.println("#"+t+" "+result);
		}
	}

}