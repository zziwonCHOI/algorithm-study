import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int result;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        n=Integer.parseInt(br.readLine());
        nums=new int[n+1];
        perm(1,1);
        System.out.println(result);
    }

    public static void perm(int cnt, int r){
        if(cnt>n){
            result=r;
            return;
        }
        perm(cnt+1,r*cnt);
    }
}