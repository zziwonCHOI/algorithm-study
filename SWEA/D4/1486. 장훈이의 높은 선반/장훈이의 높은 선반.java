import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
    static int n,b,s,ans;
    static int[] arr,arr2;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        int T=Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            sb.append("#"+t+" ");
            StringTokenizer st=new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());
            b=Integer.parseInt(st.nextToken());
            ans=Integer.MAX_VALUE;
            arr=new int[n];
            visited=new boolean[n];
            
            st=new StringTokenizer(br.readLine());
            
            for(int i=0; i<n;i++){
                arr[i]=Integer.parseInt(st.nextToken());
            }
            subset(0);
            sb.append(ans-b).append("\n");
        

        }
                    System.out.println(sb);


    }
    
    public static void subset(int cnt){
        if(cnt==n) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    sum += arr[i];
                }
            }
            if(sum>=b && ans>sum){
                ans=sum;
                
            }
            return;
        }
        visited[cnt]=true;
        subset(cnt+1);
        visited[cnt]=false;
        subset(cnt+1);
    }
}