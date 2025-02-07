
import java.util.Scanner;

public class Main {
    static  int cnt1, cnt2;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        arr= new int[n+1];
        cnt1=0;
        cnt2=0;
        
        fib(n);
        fibonacci(n);

        System.out.println(cnt1+" "+cnt2);
    }
    static int fib(int n){
        if(n==1 || n==2){
            cnt1++;
            return 1;
        }else{
            return (fib(n-1)+fib(n-2));
        }
    }
    
    static int fibonacci(int n){
        arr[0]=0;
        arr[1]=1;
        for(int i=2; i<n; i++){
            cnt2++;
            arr[i]=arr[i -1]+arr[i-2];
        }
        return arr[n-1];
    }

}
