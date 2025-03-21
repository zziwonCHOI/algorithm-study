import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int n;
	static int[] arr;
	static int[] num;
	static int[] carrot;
	static int minGap;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			int result=Integer.MAX_VALUE;
			for(int i=1; i<n-1; i++) {
				 if (arr[i - 1] == arr[i]) continue; // 그룹1 ~ 그룹2 사이에 같은 당근 걸침

				    for (int j = i + 1; j < n; j++) {
				        if (arr[j - 1] == arr[j]) continue; // 그룹2 ~ 그룹3 사이에 같은 당근 걸침

				        int a = i;
				        int b = j - i;
				        int c = n - j;
					
					if(a==0||b==0||c==0) continue;
					
					if(a>n/2||b>n/2||c>n/2) continue;
					int maxSize=Math.max(a, Math.max(c, b));
					int minSize=Math.min(a, Math.min(c, b));
					
					result=Math.min(maxSize-minSize, result);
				}
			}
			
			System.out.println("#"+t+" "+(result==Integer.MAX_VALUE?-1:result));
		}
	}

}