import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int n,k;
    static int[] arr;
    static int cnt;
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
            for(int i=0; i<n;i++){
                arr[i]=Integer.parseInt(st.nextToken());
            }
            cnt=0;
            subset(0,0);

            System.out.println("#"+t+" "+cnt);
        }
    }
    
    public static void subset(int idx, int sum){
        //모든 숫자를 선택했을 경우
        if(idx==n){
            if(sum==k){
                cnt++;
            }
            return;
        }
        
        if(sum==k){
            cnt++;
            return;
        }
        //현재 값을 선택하는 경우
        subset(idx+1,arr[idx]+sum);
        //현재 값을 선택하지 않는 경우
        subset(idx+1,sum);
    }
}