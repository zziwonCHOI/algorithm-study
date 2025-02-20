import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int T=Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            int n=Integer.parseInt(br.readLine());
            String s=br.readLine();
            String result="Yes";

            if(n%2==0){
                for(int i=0; i<n/2; i++){
                    if(s.charAt(i)!=s.charAt(n/2+i)){
                        result="No";
                        break;
                    }
                }

            }else{
                result="No";
            }

            System.out.println("#"+t+" "+result);
        }
    }

}

//3
//6
//abcabc
//2
//ab
//1
//z