import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        for(int t=1; t<=10; t++){
            sc.nextInt();
            int[][] arr=new int[100][100];

            for(int i=0; i<100; i++){
                for(int j=0; j<100; j++){
                    arr[i][j]=sc.nextInt();
                }
            }

            int maxSum=0;

            //행 계산
            for(int i=0; i<100; i++){
                int s=0;
                for(int j=0; j<100; j++){
                    s+=arr[i][j];
                }
                if(maxSum<s){
                    maxSum=s;
                }
            }

            //열 계산
            for(int i=0; i<100; i++){
                int s=0;
                for(int j=0; j<100; j++){
                    s+=arr[j][i];
                }
                if(maxSum<s){
                    maxSum=s;
                }
            }

            //대각선 계산1
            int s1=0;
            for(int j=0; j<100; j++){
                s1+=arr[j][j];
            }
            if(maxSum<s1){
                maxSum=s1;
            }

            //대각선 계산2
            int s2=0;
            for(int i=0; i<100; i++){
                s2+=arr[i][99-i];
            }
            if(maxSum<s2){
                maxSum=s2;
            }
            
            System.out.println("#"+t+" "+maxSum);
        }
    }
}