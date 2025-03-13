import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static char[][] arr;
	static boolean[][] visited;
	static int basicCnt;
	static int specialCnt;
	static int[] dx= {0,1,0,-1};
	static int[] dy= {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		n=Integer.parseInt(br.readLine());
		arr=new char[n][n];
		for(int i=0; i<n; i++) {
			String s=br.readLine();
			for(int j=0; j<n; j++) {
				arr[i][j]=s.charAt(j);
			}
		}
		basicCnt=0;
		specialCnt=0;
		
		visited=new boolean[n][n];
		for(int i=0;i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!visited[i][j]) {
					basicCnt++;
					bfs(i,j,arr[i][j],'b');
				}
			}
		}
		
		visited=new boolean[n][n];
		for(int i=0;i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!visited[i][j]) {
					specialCnt++;
					bfs(i,j,arr[i][j],'s');
				}
			}
		}
		
		System.out.println(basicCnt+" "+specialCnt);
	}

	public static void bfs(int i,int j, char c, char type) {
		Queue<int[]> q=new LinkedList<int[]>();
		visited[i][j]=true;
		q.add(new int[] {i,j});
		
		while(!q.isEmpty()) {
			int[] cur=q.poll();
			
			for(int k=0; k<4; k++) {
				int x=cur[0]+dx[k];
				int y=cur[1]+dy[k];
				
				if(x<0||y<0||x>=n||y>=n) continue;
				
				//일반 사람일 경우
				if(type=='b') {
					//방문하지 않고 c와 같은 색일 경우 
					if(!visited[x][y]&&arr[x][y]==c) {
						visited[x][y]=true;
						q.add(new int[] {x,y});
					}
				}else {//색약일 경우 
					if(c=='R'||c=='G') {
						if(!visited[x][y]&&(arr[x][y]=='R'||arr[x][y]=='G')) {
							visited[x][y]=true;
							q.add(new int[] {x,y});
						}
					}else {
						if(!visited[x][y]&&arr[x][y]==c) {
							visited[x][y]=true;
							q.add(new int[] {x,y});
						}
					}
				}
			}
		}
	}
}