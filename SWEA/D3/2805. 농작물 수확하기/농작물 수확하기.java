import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());



        for(int t=1; t<=T; t++){
            int n=Integer.parseInt(br.readLine());
            int[][] arr=new int[n][n];
            for(int i=0; i<n; i++){
                String line=br.readLine();
                for(int j=0; j<n; j++){
                    arr[i][j]=line.charAt(j)-'0';
                }
            }

            int sum=0;
            int center=n/2;//가운데랑 얼마나 떨어져있는지 비교할떄 사용
            for(int i=0; i<n; i++){
                int dist=center-Math.abs(center-i);
                for(int j=center-dist; j<=center+dist; j++){
                    sum+=arr[i][j];
                }
            }

            System.out.println("#"+t+" "+sum);

        }

    }
}