import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	static int[][] arr;
	static int[] dx= {0,1,0,-1};
	static int[] dy= {1,0,-1,0};
	static Queue<int[]> q;
	static Set<String> number;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T=Integer.parseInt(br.readLine());
		for(int t=1; t<=T;t++) {
			arr=new int[4][4];
			for(int i=0; i<4; i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0; j<4; j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			//중복된 숫자는 제외하고 개수 세기 
			number=new HashSet<String>();
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					moveBoard(0,i,j,String.valueOf(arr[i][j]));
				}
			}
			
			System.out.println("#"+t+" "+number.size());
		}
	}

	
	
	public static void moveBoard(int cnt, int x, int y, String num) {
		if(cnt==6) {
			number.add(num);
			return;
		}
		
		for(int k=0; k<4; k++) {
			int curx=x+dx[k];
			int cury=y+dy[k];
			if(curx<0||cury<0||curx>=4||cury>=4) continue;
			moveBoard(cnt+1, curx, cury,num+String.valueOf(arr[curx][cury]));
		}
	}
}