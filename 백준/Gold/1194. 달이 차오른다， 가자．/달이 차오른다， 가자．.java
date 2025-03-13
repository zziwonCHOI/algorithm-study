import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Main {
	static class Node {
		int x, y, dist, key;

		Node(int x, int y, int d, int k) {
			this.x = x;
			this.y = y;
			dist = d;
			key = k;
		}
	}

	static int n, m;
	static char[][] arr;
	static int startX, startY;
	static int minMove;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static boolean[][][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] line = br.readLine().split(" ");
		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);

		arr = new char[n][m];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = s.charAt(j);
				if (arr[i][j] == '0') {
					startX = i;
					startY = j;
				}

			}
		}
		visited = new boolean[n][m][64]; // 6개의 키 상태 (2^6)
		minMove = Integer.MAX_VALUE;
		int result = bfs();
		System.out.println(result==Integer.MAX_VALUE?-1:minMove);
	}

	public static int bfs() {
		Queue<Node> q = new ArrayDeque<>();
		q.offer(new Node(startX, startY, 0, 0));
		visited[startX][startY][0] = true;

		while (!q.isEmpty()) {
			Node cur = q.poll();

			if (arr[cur.x][cur.y] == '1') {
				minMove=Math.min(minMove, cur.dist);
				continue;
			}
			for (int k = 0; k < 4; k++) {
				int curx = cur.x + dx[k];
				int cury = cur.y + dy[k];
				int key = cur.key;

				if (curx < 0 || cury < 0 || curx >= n || cury >= m)
					continue;

				int next = arr[curx][cury];

				if (next == '#')
					continue;

				if (Character.isLowerCase(next)) {
					key |= (1 << (next - 'a'));
				}
				if (Character.isUpperCase(next)) {
					if ((key & (1 << (next - 'A'))) == 0) {
						continue;
					}
				}

				if (!visited[curx][cury][key]) {
					visited[curx][cury][key] = true;
					q.add(new Node(curx, cury, cur.dist + 1, key));
				}

			}

		}

		return minMove;
	}

}