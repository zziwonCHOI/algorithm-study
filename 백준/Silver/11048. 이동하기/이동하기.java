import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int[][] arr=new int[n+1][m+1];
        int[][] dp=new int[n+1][m+1];

        for(int i=1; i<=n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=1; j<=m; j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                dp[i][j]=Math.max(dp[i-1][j],Math.max(dp[i-1][j-1],dp[i][j-1]))+arr[i][j];
            }
        }

        System.out.println(dp[n][m]);
    }

}