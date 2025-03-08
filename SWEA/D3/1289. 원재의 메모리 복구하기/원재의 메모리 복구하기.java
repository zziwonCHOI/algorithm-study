import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int T=Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            char[] line=br.readLine().toCharArray();
            int result=0;
            char before='0';
            for(int i=0; i<line.length; i++){
                if(line[i]!=before){
                    before=line[i];
                    result++;
                }
            }
            System.out.println("#"+t+" "+result);
        }
    }
}