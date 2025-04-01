import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int N2 = sc.nextInt();

            int[] arr = new int[N];

            for(int i=0; i<N2; i++) {
                int Index = sc.nextInt();
                arr[Index-1] = 1;
            }

            System.out.print("#" + test_case);
            for(int i=0; i<N; i++) {
                if(arr[i]==0) {
                    System.out.print(" " + (i+1));
                }
            }
            System.out.println();
        }
    }
}