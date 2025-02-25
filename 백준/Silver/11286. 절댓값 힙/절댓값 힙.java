import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<int[]> pq = new PriorityQueue<>(
				(a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());

			if (num == 0) {
				if (pq.isEmpty()) {
					sb.append(0).append("\n");
				} else {
					int[] p = pq.poll();
					sb.append(p[1]).append("\n");
				}
			} else {
				pq.add(new int[] { Math.abs(num), num });
			}
		}
		System.out.println(sb);

	}

}