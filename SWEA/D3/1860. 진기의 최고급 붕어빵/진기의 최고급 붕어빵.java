import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T=Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());
            int k=Integer.parseInt(st.nextToken());

            st=new StringTokenizer(br.readLine());
            int[] welcome=new int[n];
            for(int i=0; i<n; i++){
                welcome[i]=Integer.parseInt(st.nextToken());
            }
            Arrays.sort(welcome);

            boolean check=true;
            int fishBread=0;
            for(int i=0; i<n; i++){
                //도착 시간까지 생상된 총 붕어빵의 개수
                fishBread=(welcome[i]/m)*k;
                if(fishBread<i+1){
                    check=false;
                    break;
                }
            }

            System.out.println("#"+t+" "+(check?"Possible":"Impossible"));
        }
    }
}