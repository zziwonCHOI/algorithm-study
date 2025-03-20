import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n,m;
	static int[][] arr;
	static int[] dx= {0,1,0,-1};
	static int[] dy= {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T=Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			st=new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken());
			m=Integer.parseInt(st.nextToken());
			arr=new int[n][m];
			for(int i=0; i<n; i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0; j<m; j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			int maxCnt=Integer.MIN_VALUE;
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					int cnt=pop(i,j);
					maxCnt=Math.max(maxCnt, cnt);
				}
			}
			
			System.out.println("#"+t+" "+maxCnt);
		}
	}

	public static int pop(int x, int y) {
		int c=arr[x][y];
		for(int k=0; k<4; k++) {
			int nx=x;
			int ny=y;
			for(int i=0; i<arr[x][y]; i++) {
				nx+=dx[k];
				ny+=dy[k];
				if(nx<0||ny<0||nx>=n||ny>=m) continue;
				
				c+=arr[nx][ny];
			}
			
		}
		return c;
	}

}