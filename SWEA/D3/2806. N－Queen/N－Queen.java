import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static int[] arr;
    static int n;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int T=Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            n=Integer.parseInt(br.readLine());
            cnt=0;
            arr=new int[n];
            nQueen(0);

            System.out.println("#"+t+" "+cnt);

        }
    }
    //경우의 수 구하기
    public static void nQueen(int depth){
        //모든 원소를 다 채운 상태면 count 증가 및 return
        if(depth==n){
            cnt++;
            return;
        }

        for(int i=0; i<n; i++){
            arr[depth]=i;
            //놓을 수 있는 위치일 경우 재귀호출
            if (Possible(depth)) {
                nQueen(depth+1);
            }
        }
    }

    public static boolean Possible(int d){
        for(int i=0; i<d; i++){
            //해당 열의 행과 i열의 행이 일치할경우(같은 행에 존재할 경우)
            if(arr[d]==arr[i]){
                return false;
            }
            //대각선 상에 놓여 있는 경우
            //열의 차와 행의 차가 같은 경우 대각선에 놓여있다는 의미

            else if(Math.abs(d-i)==Math.abs(arr[d]-arr[i])){
                return false;

            }
        }
        return true;


    }
}