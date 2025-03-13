import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            int n=Integer.parseInt(br.readLine());
            
            int result=n/3;
            System.out.println("#"+t+" "+result);
        }
    }
}