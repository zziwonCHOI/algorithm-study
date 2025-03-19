import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n,k;
	static int[] w;
	static int[] v;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		
		w=new int[n];
		v=new int[n];
		
		for(int i=0; i<n; i++) {
			st=new StringTokenizer(br.readLine());
			w[i]=Integer.parseInt(st.nextToken());
			v[i]=Integer.parseInt(st.nextToken());
			
			
		}
		int maxVaule=knapsack(w,v,k);
		System.out.println(maxVaule);
		
		
	}

	public static int knapsack(int[] weight, int[] value, int K) {
		int[][] dp=new int[n+1][K+1]; //dp[i][j]일때 i번째 물건까지 고려했다고 하면, 배낭의 현재 무게 j에서 얻을 수 있는 최대 가치를 저장 
		
		for(int i=1; i<=n; i++) {
			for(int j=0; j<=K; j++) {  //배낭의 무게 0~K까지 탐색 
				if(weight[i-1]>j) {//현재 물건이 배낭 무게보다 크면  못 넣는다. 
					dp[i][j]=dp[i-1][j]; //이전 상태 유지 
				}else { //물건을 넣을지 말지 선택 
					dp[i][j]=Math.max(dp[i-1][j],value[i-1]+dp[i-1][j-weight[i-1]]);
					//현재 물건을 넣을 경우-> 현재 물건의 가치+ (이전 상태에서 weight[i-1]만큼 뺀 값)
				}
			}
		}
		return dp[n][K];
	}
}