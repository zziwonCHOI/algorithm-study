import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
    static int n;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T=Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            n=Integer.parseInt(br.readLine());
            arr=new int[n];
            st=new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                arr[i]=Integer.parseInt(st.nextToken());
            }
            boolean result=true;
            Set<Integer> set=new HashSet<>();
            for(int i=0; i<n; i++){
                if(arr[i]<1||arr[i]>n){
                    result=false;
                    break;
                }
                if(set.contains(arr[i])){
                    result=false;
                    break;
                }else{
                    set.add(arr[i]);
                }
            }

            System.out.println("#"+t+" "+(result?"Yes":"No"));
        }
    }
}