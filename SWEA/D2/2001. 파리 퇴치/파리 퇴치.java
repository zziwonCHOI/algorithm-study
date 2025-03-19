import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n,m;
	static int[][] arr;
	static int maxCnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T=Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			st=new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken());
			m=Integer.parseInt(st.nextToken());
			
			arr=new int[n][n];
			for(int i=0; i<n; i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
					
				}
					
			}
			
			maxCnt=Integer.MIN_VALUE;
			for(int i=0; i<=n-m; i++) {
				for(int j=0; j<=n-m; j++) {
					int c=catchFlying(i,j);
					maxCnt=Math.max(maxCnt, c);
				}
			}
			System.out.println("#"+t+" "+maxCnt);
		}
	}

	public static int catchFlying(int x, int y) {
		int cnt=0;
		for(int i=x; i<x+m; i++) {
			for(int j=y; j<y+m; j++) {
				cnt+=arr[i][j];
			}
		}
		return cnt;
	}
}