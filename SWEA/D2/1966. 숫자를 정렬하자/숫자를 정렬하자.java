import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T=Integer.parseInt(br.readLine());

		for(int t=1; t<=T; t++) {
			StringBuilder sb=new StringBuilder();
			int n=Integer.parseInt(br.readLine());
			int[] arr=new int[n];
			st=new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			sb.append("#"+t).append(" ");
			for(int i:arr) {
				sb.append(i).append(" ");
			}
			
			System.out.println(sb);
		}
		
	}

}