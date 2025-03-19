import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n, len;
	static int[][] arr;
	static int totalCnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			len = Integer.parseInt(st.nextToken());

			arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			totalCnt = 0;
			check();
			System.out.println("#"+t+" "+totalCnt);
		}

	}

	public static void check() {

		// 행 확인
		for (int i = 0; i < n; i++) {
			int cnt = 0;
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 1) {
					cnt++;
				}else {
					if(cnt==len) {
						totalCnt++;
					}
					cnt=0;
				}
			}
			if(cnt==len) {
				totalCnt++;
			}
			
		}

		// 열 확인
		for (int i = 0; i < n; i++) {
			int cnt = 0;
			for (int j = 0; j < n; j++) {
				if (arr[j][i] == 1) {
					cnt++;
				}else {
					if(cnt==len) {
						totalCnt++;
					}
					cnt=0;
				}
			}
			if(cnt==len) {
				totalCnt++;
			}
		}
	}

}