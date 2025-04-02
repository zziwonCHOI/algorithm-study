import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n, m;
	static int[][] arr;
	static int wCnt, bCnt;
	static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int[] dy = { 1, 1, 0, -1, -1, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken()); // 플레이어가 돌을 놓는 횟수
			arr = new int[n][n];

			// 가운데 초기 돌 놓기
			arr[n / 2-1][n / 2-1] = 2;
			arr[n / 2-1][n / 2] = 1;
			arr[n / 2 ][n / 2-1] = 1;
			arr[n / 2][n / 2] = 2;

			// 돌을 놓는 횟수만큼 반복
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken()) - 1;
				int x = Integer.parseInt(st.nextToken()) - 1;
				int addRock = Integer.parseInt(st.nextToken());

				arr[x][y]=addRock;
				for (int k = 0; k < 8; k++) {
					int nx = x + dx[k];
					int ny = y + dy[k];

					if (nx < 0 || ny < 0 || nx >= n || ny >= n||arr[nx][ny]==0||arr[nx][ny]==addRock)
						continue;

					int curx=nx;
					int cury=ny;
					boolean flag=false;
					while(true) {
						curx+=dx[k];
						cury+=dy[k];
						
						if(curx<0||cury<0||curx>=n||cury>=n||arr[curx][cury]==0) break;
						if(arr[curx][cury]==addRock) {
							flag=true;
							break;
						}
						
					}
					
					if(flag) {
						int flipx=x+dx[k];
						int flipy=y+dy[k];
						while(flipx!=curx||flipy!=cury) {
							arr[flipx][flipy]=addRock;
							flipx+=dx[k];
							flipy+=dy[k];
						}
					}
					
				}

			}

			wCnt=0;
			bCnt=0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (arr[i][j] == 1) {
						bCnt++;
					} else if(arr[i][j]==2) {
						wCnt++;
					}
				}
			}

			System.out.println("#" + t + " " + bCnt + " " + wCnt);
		}

	}

}