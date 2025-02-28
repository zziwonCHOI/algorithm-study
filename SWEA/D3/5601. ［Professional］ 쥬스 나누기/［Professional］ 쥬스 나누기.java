
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int T=sc.nextInt();
        sc.nextLine();

        for(int t=1; t<=T;t++){
            int n=sc.nextInt();
            System.out.print("#"+t+" ");
            for(int i=0; i<n;i++){
                System.out.print("1/"+n+" ");
            }
            System.out.println();   
        }
    }
}
