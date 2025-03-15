import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
    static int n,l;
    static int[] scores;
    static int[] kcals;
    static int maxTotal;
    static boolean[] isSelected;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in)) ;
        StringTokenizer st;

        int T=Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            st=new StringTokenizer(br.readLine());

            n=Integer.parseInt(st.nextToken()); //재료의 수
            l=Integer.parseInt(st.nextToken()); //제한 칼로리

           scores=new int[n];
           kcals=new int[n];
            for(int i=0; i<n; i++){
                st=new StringTokenizer(br.readLine());
                int score=Integer.parseInt(st.nextToken());
                int kal=Integer.parseInt(st.nextToken());

                scores[i]=score;
                kcals[i]=kal;
            }
            maxTotal=Integer.MIN_VALUE;
            isSelected=new boolean[n];
            subSet(0,0,0);

            System.out.println("#"+t+" "+maxTotal);

        }
    }

    public static void subSet(int idx, int sum, int kcal){
        if(kcal>l){//정해진 칼로리를 초과하는 경우
            return;
        }

        //모든 재료를 선택했을 경우
        if(idx==n){
            maxTotal=Math.max(sum,maxTotal);
            return;
        }

        //현재 원소를 선택하는 경우
        subSet(idx+1, sum+scores[idx],kcal+kcals[idx] );
        //현재 원소를 선택하지 않는 경우
        subSet(idx+1, sum,kcal );

    }
}