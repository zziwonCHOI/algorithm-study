import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n,l;
	static int[] scores;
	static int[] kcal;
	static int maxScore;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T=Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			st=new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken());
			l=Integer.parseInt(st.nextToken());
			scores=new int[n];
			kcal=new int[n];
			
			for(int i=0; i<n; i++) {
				st=new StringTokenizer(br.readLine());
				scores[i]=Integer.parseInt(st.nextToken());
				kcal[i]=Integer.parseInt(st.nextToken());
			}
			
			maxScore=0;
			subset(0, 0, 0);
			System.out.println("#"+t+" "+maxScore);
		}
		
	}

	public static void subset(int idx, int scoreSum, int kcalSum) {
		if(kcalSum>l) {
			return;
			
		}
		if(idx==n) {
			maxScore=Math.max(scoreSum, maxScore);
			return;
		}
		
		subset(idx+1, scoreSum+scores[idx], kcalSum+kcal[idx]);
		subset(idx+1, scoreSum, kcalSum);
	}
}