import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        for(int t=1; t<=10; t++){
            int len=Integer.parseInt(br.readLine());
            char[][] arr=new char[8][8];
            int cnt=0;
            for(int i=0; i<8; i++){
                String line=br.readLine();
                for(int j=0; j<8; j++){
                    arr[i][j]=line.charAt(j);
                }
            }
            StringBuilder sb=new StringBuilder();

            //행 검사
            for(int i=0; i<8; i++){
                for(int j=0; j<=8-len;j++){
                    StringBuilder word= new StringBuilder();
                    for(int k=0; k<len; k++){
                        word.append(arr[i][k + j]);
                    }
                    String reverse=new StringBuilder(word.toString()).reverse().toString();

                    if(word.toString().equals(reverse)){
                        cnt++;
                    }
                }
            }
            //열 검사
            for(int i=0; i<8; i++){
                for(int j=0; j<=8-len;j++){
                    StringBuilder word= new StringBuilder();
                    for(int k=0; k<len; k++){
                        word.append(arr[j + k][i]);
                    }
                    String reverse=new StringBuilder(word.toString()).reverse().toString();

                    if(word.toString().equals(reverse)){
                        cnt++;
                    }
                }
            }

            System.out.println("#"+t+" "+cnt);
        }
    }
}