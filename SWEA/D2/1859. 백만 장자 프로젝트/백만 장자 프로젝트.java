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
            int n=Integer.parseInt(br.readLine());
            int[] arr=new int[n];
            st=new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                arr[i]=Integer.parseInt(st.nextToken());
            }

            long maxResult=0;
            int maxValue=0;

            //max 값을 갱신해나가면서 max-현재 값을 결과값으로 더해 나간다. 뒤에서 부터 도는 이유는 나중에 나오는 가장 큰 값을 찾기 위해서이다. 
            for(int i=n-1; i>=0; i--){
                if(maxValue<arr[i]){
                   maxValue=arr[i];
                }
                maxResult+=maxValue-arr[i];
            }

            System.out.println("#"+t+" "+maxResult);
        }
    }
}