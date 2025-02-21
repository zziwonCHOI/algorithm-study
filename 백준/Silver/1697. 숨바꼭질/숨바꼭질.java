import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static boolean[] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int me = Integer.parseInt(st.nextToken());
		int bro = Integer.parseInt(st.nextToken());

		visited = new boolean[100001];
		System.out.println(bfs(me, bro, 0));

	}

	public static int bfs(int me, int bro, int d) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] { me, d });
		visited[me] = true;

		while (!q.isEmpty()) {
			int[] c = q.poll();
			int cur = c[0];
			int time = c[1] + 1;
			if (cur == bro) {
				return time - 1;

			}
			if (cur - 1 >=0&&!visited[cur-1]) {
				q.add(new int[] { cur - 1, time });
				visited[cur - 1] = true;
			}
			if (cur + 1 < 100001 &&!visited[cur+1]) {
				q.add(new int[] { cur + 1, time });
				visited[cur + 1] = true;
			}
			if (cur * 2 < 100001 &&!visited[cur*2]) {
				q.add(new int[] { cur * 2, time });
				visited[cur * 2] = true;
			}
			
		}
		return -1;
	}
}