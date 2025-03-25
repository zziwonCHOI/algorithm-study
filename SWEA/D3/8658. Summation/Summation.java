
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        sc.nextLine();

        for(int t=1; t<=T;t++){
            ArrayList<Integer> sums=new ArrayList<>();

            for(int i=0; i<10; i++){
                int num=sc.nextInt();
                char[] n=String.valueOf(num).toCharArray();
                int sum=0;
                for(int j=0; j<n.length;j++){
                    sum+=n[j]-'0';
                }
                sums.add(sum);
            }
            sc.nextLine();
            sums.sort((a,b)->a-b);

            System.out.println("#"+t+" "+sums.get(9)+" "+sums.get(0));

        }
    }


}
