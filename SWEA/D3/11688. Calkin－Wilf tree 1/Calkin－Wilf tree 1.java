import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int T=Integer.parseInt(br.readLine());

        for(int t=1; t<=T;t++){
            String[] input=br.readLine().split("");
            int a=1;
            int b=1;
            for(int i=0; i<input.length;i++){
                int sum=a+b;
                if(input[i].equals("L")){
                    b=a+b;
                }else{
                    a=a+b;
                }
            }
            System.out.println("#"+t+" "+a+" "+b);
        }
    }
}
