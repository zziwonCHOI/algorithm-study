import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            String line=br.readLine();
            char[] arr=line.toCharArray();
            int cnt=0;
            String result;
            for(int i=0; i<arr.length;i++){
                if(arr[i]=='o'){
                    cnt++;
                }
            }
            
            if(15-arr.length+cnt>7){
                result="YES";
            }else{
                result="NO";
            }

            System.out.println("#"+t+" "+result);
        }
    }
}