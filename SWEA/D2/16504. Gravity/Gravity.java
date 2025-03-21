import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int max=0;
			for (int i = 0; i < n-1; i++) {
				int result = 0;

				for (int j = i+1; j <n; j++) {
					if (arr[i] > arr[j]) {
						result++;
					}
				}
				max=Math.max(max, result);
			}
			
			System.out.println("#"+t+" "+max);
		}
	}

}