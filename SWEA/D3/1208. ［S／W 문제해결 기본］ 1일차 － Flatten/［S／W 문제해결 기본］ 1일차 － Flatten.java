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

        for(int t=1; t<=10; t++){
            int n=Integer.parseInt(br.readLine());
            st=new StringTokenizer(br.readLine());
            int[] arr=new int[100];
            for(int i=0; i<100; i++){
                arr[i]=Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);
            for(int i=0; i<n; i++){
                Arrays.sort(arr);
                arr[99]-=1;
                arr[0]+=1;

            }
            Arrays.sort(arr);

            System.out.println("#"+t+" "+(arr[99]-arr[0]));
        }
    }
}