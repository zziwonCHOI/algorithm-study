
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int T=sc.nextInt();
        sc.nextLine();

        for(int t=1; t<=T; t++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int[] arr=new int[a+b+1];
            for(int i=1; i<=a; i++){
                for(int j=1; j<=b; j++){
                    arr[i+j]++;

                }
            }

            int max=0;

            for(int i=2; i<=a+b; i++){
                max= Math.max(arr[i],max);
            }

            System.out.print("#"+t+" ");
            for(int i=2; i<=a+b;i++){
                if(arr[i]==max){
                    System.out.print(i+" ");
                }
            }
            System.out.println();
        }
    }
}
