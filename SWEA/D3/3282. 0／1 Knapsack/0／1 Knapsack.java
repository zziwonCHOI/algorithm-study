import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T=Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());

            int[] weight=new int[n+1];
            int[] values=new int[n+1];

            for(int i=1; i<=n; i++){
                st=new StringTokenizer(br.readLine());
                weight[i]=Integer.parseInt(st.nextToken());
                values[i]=Integer.parseInt(st.nextToken());
            }

            int[][] dp=new int[n+1][w+1];

            for(int i=1; i<=n; i++){
                for(int j=0; j<=w; j++){
                    if(weight[i]<=j){
                        dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-weight[i]]+values[i]);
                    }else{
                        dp[i][j]=dp[i-1][j];
                    }
                }
            }

            System.out.println("#"+t+" "+dp[n][w]);
        }
    }
}