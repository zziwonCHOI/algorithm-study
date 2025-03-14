
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int T=sc.nextInt();
        sc.nextLine();

        for(int t=1; t<=T; t++){
            String[] line=sc.nextLine().split(" ");
            String result="";
            for(int i=0; i<line.length;i++){
                String[] s=line[i].split("");
                result+=s[0].toUpperCase();
            }

            System.out.println("#"+t+" "+result);
        }
    }
}
