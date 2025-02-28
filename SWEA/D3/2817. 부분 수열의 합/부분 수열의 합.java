import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static  int[] arr;
    static int n,k,cnt;
    static boolean[] isSelecte;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T=Integer.parseInt(br.readLine());
        for(int t=1; t<=T;t++){
            st=new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());
            k=Integer.parseInt(st.nextToken());

            arr=new int[n];
            st=new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                arr[i]=Integer.parseInt(st.nextToken());
            }

            cnt=0;
            comb(0,0);
            System.out.println("#"+t+" "+cnt);
        }


    }


    public static void comb(int index,int sum){
        if(index==n){
            if(sum==k){
                cnt++;
            }
            return;
        }

        comb(index+1,sum+arr[index]);
        comb(index+1,sum);

    }
}