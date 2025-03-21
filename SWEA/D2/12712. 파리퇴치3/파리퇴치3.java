import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n,m;
	static int[][] arr;
	static int maxCnt;
	static int[] dx= {0,1,0,-1};
	static int[] dy= {1,0,-1,0};
	static int[] dx2= {1,1,-1,-1};
	static int[] dy2= {1,-1,-1,1};
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
			for(int i=0; i<n; i++) {
				for(int j=0;j<n; j++) {
					int result=catchFlying(i,j);
					maxCnt=Math.max(maxCnt, result);
				}
			}
			
			System.out.println("#"+t+" "+maxCnt);
		}
			
	}
	
	public static int catchFlying(int x, int y) {
		int sum1=arr[x][y];
		for(int k=0; k<4; k++) {
			int curx=x;
			int cury=y;
			for(int i=0; i<m-1; i++) {
				curx+=dx[k];
				cury+=dy[k];
				if(curx<0||cury<0||curx>=n||cury>=n) continue;
				sum1+=arr[curx][cury];
			}
		}
		
		int sum2=arr[x][y];
		for(int k=0; k<4; k++) {
			int curx=x;
			int cury=y;
			for(int i=0; i<m-1; i++) {
				curx+=dx2[k];
				cury+=dy2[k];
				if(curx<0||cury<0||curx>=n||cury>=n) continue;
				sum2+=arr[curx][cury];
			}
		}
		
		return Math.max(sum1, sum2);
	}

}