import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int[] check={1,2,3,4,5};
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br. readLine());

        arr=new int[5];
        for(int i=0; i<5; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        //앞 뒤 비교해서 바꾸기
        while(!checkArr()){
            for(int i=0; i<4; i++){
                if(arr[i]>arr[i+1]){
                    int temp=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=temp;
                    System.out.println(result());
                }
            }
        }


    }

    public static String result(){
        String r="";
        for(int i=0; i<5;i++){
            r+=String.valueOf(arr[i])+" ";
        }
        return r;
    }

    public static boolean checkArr(){
        return Arrays.equals(arr,check);
    }
}