import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
	static int[][] arr;
	static int n;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int[][] distance;
	private static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			distance=new int[n][n]; 
			for (int i = 0; i < n; i++) {
				String s = br.readLine();
				for (int j = 0; j < n; j++) {
					arr[i][j] = s.charAt(j) - '0';
					distance[i][j] = INF; // 초기값 설정
				}
			}

			bfs(0, 0);

			System.out.println("#" + t + " " + distance[n - 1][n - 1]);
		}
	}

	public static void bfs(int x, int y) {
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[2] - o2[2];
			}

		});

		pq.add(new int[] { x, y, arr[x][y] });
		distance[x][y]=arr[x][y];
		
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			for (int k = 0; k < 4; k++) {
				int curx = cur[0] + dx[k];
				int cury = cur[1] + dy[k];
				int cost = cur[2];

				
				if (curx < 0 || cury < 0 || curx >= n || cury >= n)
					continue;

				int newCost = cost + arr[curx][cury];
				if (newCost < distance[curx][cury]) {
					distance[curx][cury] = newCost;
					pq.add(new int[] { curx, cury, newCost });

				}

			}
		}

	}
}