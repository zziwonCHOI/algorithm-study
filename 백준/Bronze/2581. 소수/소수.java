
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        sc.nextLine();
        int m=sc.nextInt();
        int sum=0;
        int min=m;


        int cnt=0; //소수의 개수

        for(int i=n; i<=m; i++){
            if(i==1){
                continue;
            }
            boolean check=true;
            //i가 소수인지 아닌지 판단
            for(int j=2; j<=Math.sqrt(i); j++){
                //소수가 아님
                if(i%j==0){
                    check=false;
                    break;
                }
            }
            if(check){
                cnt++;
                sum+=i;
                if(min>i){
                    min=i;
                }
            }
        }
        if (cnt != 0) {
            System.out.println(sum);
            System.out.println(min);
        }else{
            System.out.println(-1);
        }
    }


}
