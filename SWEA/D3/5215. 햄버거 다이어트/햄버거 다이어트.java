import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int[] taste;
    static int[] cal;
    static int n,l;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T=Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            st=new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());
            l=Integer.parseInt(st.nextToken());

            taste=new int[n];
            cal=new int[n];

            for(int i=0; i<n; i++){
                st=new StringTokenizer(br.readLine());
                taste[i]=Integer.parseInt(st.nextToken());
                cal[i]=Integer.parseInt(st.nextToken());
            }

            max=0;
            comb(0,0,0);
            System.out.println("#"+t+" "+max);
        }

    }

    public static void comb(int cnt, int calSum, int tasteSum){
        if(calSum>l){
            return;
        }
        if(cnt==n){
            //지금 까지 초합의 칼로리 합이 최대를 넘지 않았으면 max값을 갱신한다. 
            if(calSum<=l){
                max=Math.max(max,tasteSum);
            }
            return;
        }

        comb(cnt+1, calSum+cal[cnt],tasteSum+taste[cnt]);
        comb(cnt+1, calSum,tasteSum);
    }

}