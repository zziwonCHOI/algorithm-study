import java.io.*;
import java.util.*;

public class Solution {

	static char[][] dmap;
	static boolean[][] v;
	static int N;
	static int[] di = {-1,-1,0,1,1,1,0,-1};
	static int[] dj = {0,1,1,1,0,-1,-1,-1};
	static int ans;
	
	//주변에 폭탄이 있는지 확인
	static public int bomb(int r, int c) {
		int cnt = 0;
		for(int d=0;d<8;d++) {
			int ni = r+di[d];
			int nj = c+dj[d];
			if(ni>=0 &&ni<N && nj>=0 && nj<N) {
				if (dmap[ni][nj] == '*') {
					cnt +=1;
				}
			}
		}
		return cnt;
	}
	
    
	static public void bfs(int r, int c) {
		ArrayDeque<char[]> deq = new ArrayDeque<>();
		v[r][c] = true;
		deq.offer(new char[] {(char) (r+'0'),(char) (c+'0')});
        
       
		while(!deq.isEmpty()) {
			char[] oj = deq.poll();
			int i = oj[0]-'0';
			int j = oj[1]-'0';
			int cnt = bomb(i,j);
			dmap[i][j] = (char)(cnt+'0');
			if (cnt>0) {
				continue;
			}
			for(int d=0;d<8;d++) {
				int ni = i+di[d];
				int nj = j+dj[d];
				if(ni>=0 &&ni<N && nj>=0 && nj<N && v[ni][nj] == false && dmap[ni][nj]!='*') {
					v[ni][nj] = true;
					deq.offer(new char[] {(char)(ni+'0'),(char)(nj+'0')});
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine().trim());
        
		for(int tc = 1;tc<=T;tc++) {
			ans = 0;
			N = Integer.parseInt(br.readLine().trim());
			dmap = new char[N][N];
			v = new boolean[N][N];
			for(int i = 0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim());
				String line = st.nextToken();
				for(int j=0;j<N;j++) {
					dmap[i][j] = line.charAt(j);
				}
			}
            
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(bomb(i,j) ==0 && dmap[i][j] != '*' && v[i][j] == false) {
                    
                        ans+=1;
						bfs(i,j);
					}
				}
			}
			
         
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(dmap[i][j] == '.') {
						dmap[i][j] = (char)(bomb(i,j)+'0');
						v[i][j] = true;
						ans +=1;
					}
				}
			}

			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}

}