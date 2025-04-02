import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n; 
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T=Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			n=Integer.parseInt(br.readLine());
			arr=new int[n][n];
			for(int i=0; i<n; i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			int[][] rotate90=rotatoin(arr);
			int[][] rotate180=rotatoin(rotate90);
			int[][] rotate270=rotatoin(rotate180);

			System.out.println("#"+t);
			for(int i=0; i<n; i++) {
				StringBuilder sb=new StringBuilder();
				for(int j=0; j<n; j++) {
					sb.append(rotate90[i][j]);
				}
				sb.append(" ");
				for(int j=0; j<n; j++) {
					sb.append(rotate180[i][j]);
				}
				sb.append(" ");
				for(int j=0; j<n; j++) {
					sb.append(rotate270[i][j]);
				}
				System.out.println(sb);
			}
			
		}
		
	}
	
	public static int[][] rotatoin(int[][] before) {
		int[][] afterArr=new int[n][n];
		
		for(int i=0; i<n;i++) {
			for(int j=0; j<n; j++) {
				afterArr[i][j]=before[n-1-j][i];
			}
		}
		return afterArr;
	}

}