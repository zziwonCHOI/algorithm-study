import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    static int n,m;
    static int[] arr;
    static int sum;
    static int result;
    public static void com(int start, int cnt){

        if(sum>m){
            return;
        }
        if(cnt==2){
            if(sum==m){
                result=sum;
                return;
            }
            if(sum<m&&sum>result){
                result=sum;
                return;
            }
            return;
        }

        for(int i=start; i<n;i++){
            sum+=arr[i];
            com(i+1,cnt+1);
            sum-=arr[i];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T=Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            st=new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());
            m=Integer.parseInt(st.nextToken());
            arr=new int[n];
            st=new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                arr[i]=Integer.parseInt(st.nextToken());
            }
            sum=0;
            result=0;
            com(0,0);
            System.out.println("#"+t+" "+(result==0?-1:result));
        }

    }
}