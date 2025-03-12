import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int n;
	static int[] arr;
	static int maxlen;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T=Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			n=Integer.parseInt(br.readLine());
			arr=new int[n];
			st=new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			
			maxlen=1; //최소한 원소 하나는 선택 
			dp=new int[n][n+1]; //각 위치까지 순열 길이를 저장할 배열 
			for(int[] row:dp) {
				Arrays.fill(row, -1);
			}
			
			maxlen=check(0,-1);
			
			System.out.println("#"+t+" "+maxlen);

		}
	
	}
	
	public static int check(int idx, int prev) {
		if(idx==n) {
			return 0;
		}
		
		//메모이제이션
		if(dp[idx][prev+1]!=-1) return dp[idx][prev+1];
		
		//현재 원소를 선택하지 않는 경우
		int result=check(idx+1, prev);
		
		
		//현재 원소를 선택하는 경우(증가하는 순서 유지)
		if(prev==-1||arr[idx]>arr[prev]) {
			result=Math.max(result,1+ check(idx+1,idx));
		}
		
		return dp[idx][prev+1]=result;
		
	}
	
}