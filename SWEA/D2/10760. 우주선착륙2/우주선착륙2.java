import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n,m;
	static int[][] arr;
	static int[] dx= {0,1,1,1,0,-1,-1,-1};
	static int[] dy= {1,1,0,-1,-1,-1,0,1};
	static int cntResult;
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
				for(int j=0; j<m;j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			cntResult=0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(candidateCheck(i,j)) {
						cntResult++;
					}
				}
			}
			
			System.out.println("#"+t+" "+cntResult);
			
		}
	}

	public static boolean candidateCheck(int x, int y) {
		int cnt=0; //현재 값보다 작은 주변 값 개수 
		for(int k=0; k<8; k++) {
			int nx=x+dx[k];
			int ny=y+dy[k];
			if(nx<0||ny<0||nx>=n||ny>=m) continue;
			
			if(arr[x][y]>arr[nx][ny]) {
				cnt++;
			}
		}
		if(cnt>=4) {
			return true;
		}
		return false;
	}
}