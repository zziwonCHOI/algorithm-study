import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static int[] visited;
    static int sameStopMax;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T=Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            int n=Integer.parseInt(br.readLine());
            sameStopMax=0;
            visited=new int[10001];
            for(int i=0; i<n; i++){
                st=new StringTokenizer(br.readLine());
                int a=Integer.parseInt(st.nextToken());
                int b=Integer.parseInt(st.nextToken());
                int c=Integer.parseInt(st.nextToken());

                check(a,b,c);
            }

            System.out.println("#"+t+" "+sameStopMax);
        }
    }

    public static void check(int type, int a, int b){
        for(int i=a; i<=b; i++){
            if(type==1){
                visited[i]++;
            }else if(type==2){
                if(a%2==0){
                    if(i%2==0){
                        visited[i]++;
                    }
                }else{
                    if(i%2!=0){
                        visited[i]++;
                    }
                }
            }else{
                if(a%2==0){
                    if(i%4==0){
                        visited[i]++;
                    }
                }else{
                    if(i%3==0&&i%10!=0){
                        visited[i]++;
                    }
                }
            }
            sameStopMax=Math.max(sameStopMax,visited[i]);

        }
    }
}