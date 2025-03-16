import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Solution {
    static int n,l;
    static int[] scores;
    static int[] kcal;
    static int maxResult;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T=Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            st=new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());
            l=Integer.parseInt(st.nextToken());
            scores=new int[n];
            kcal=new int[n];

            for(int i=0; i<n; i++){
                st=new StringTokenizer(br.readLine());
                scores[i]=Integer.parseInt(st.nextToken());
                kcal[i]=Integer.parseInt(st.nextToken());
            }

            maxResult=Integer.MIN_VALUE;
            subset(0,0,0);
            System.out.println("#"+t+" "+maxResult);
        }
    }

    public static void subset(int idx,int sumLike, int sumKcal){
        if(sumKcal>l){
            //maxResult=Math.max(maxResult,sumLike-scores[idx-1]);
            return;
        }
        if(idx==n){
            maxResult=Math.max(maxResult,sumLike);
            return;
        }
        subset(idx+1,sumLike+scores[idx],sumKcal+kcal[idx]);
        subset(idx+1,sumLike,sumKcal);
    }
}