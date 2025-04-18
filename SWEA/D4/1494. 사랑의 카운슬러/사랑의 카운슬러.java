import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
	static int n;
	static Pos[] warms;
	static Pos[] nums;
	static long minSum;
	static boolean[] visited; //모든 지렁이 선택 되어야 하기 때문에 visited 배열 필요 
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			warms = new Pos[n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				warms[i]=new Pos(a,b);
			}
			
			visited=new boolean[21];
			nums=new Pos[n/2];
			minSum=Long.MAX_VALUE;
			comb(0,0);
			System.out.println("#"+t+" "+minSum);

		}
	}

	public static void comb(int index, int start) {
		
		if (index == n/2) {
			long x=0; 
			long y=0;
			
			for(int i=0; i<n; i++) {
				if(visited[i]) {
					x+=warms[i].x;
					y+=warms[i].y;
				}else {
					x-=warms[i].x;
					y-=warms[i].y;
				}
			}
			minSum=Math.min(minSum, x*x+y*y);
			return;
		}
		
		for(int i=start; i<n; i++) {
			if(visited[i]) continue;
			visited[i]=true;
			comb(index+1, i+1);
			visited[i]=false;
		}
	}

}

class Pos {
	int x;
	int y;

	public Pos() {
	}

	public Pos(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

}