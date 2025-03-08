import java.util.Scanner;

public class Solution {
    static int a,b,result;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        for(int t=1; t<=10; t++){
            sc.nextLine();
            a=sc.nextInt();
            b=sc.nextInt();
            sc.nextLine();
            result=1;
            cal(0);
            System.out.println("#"+t+" "+result);
        }
    }
    public static void cal(int cnt){
        if(cnt==b){
            return;
        }
        result*=a;
        cal(cnt+1);
    }
}