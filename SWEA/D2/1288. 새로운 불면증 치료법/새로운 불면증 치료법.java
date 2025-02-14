
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
         int T=sc.nextInt();
         sc.nextLine();

         for(int t=1; t<=T; t++){
             int n=sc.nextInt();

             Set<Integer> set=new HashSet<>();

             int i=1;

             while(set.size()<10){
                  long num=(long)n*i;
                 String s=String.valueOf(num);
                 for(char c:s.toCharArray()){
                     set.add(c-'0');
                 }
                 i++;
             }

             System.out.println("#"+t+" "+n*(i-1));
         }
    }

}
