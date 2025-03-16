import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr;
    static int[] nums;
    static int maxResult;
    static boolean[] isSelected;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n=Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine());
        arr=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=Integer.parseInt(st.nextToken());

        }

        nums=new int[n];
        maxResult=Integer.MIN_VALUE;
        isSelected=new boolean[n];
        perm(0);
        System.out.println(maxResult);
    }

    public static void perm(int cnt){
        if(cnt==n){
            int result=0;
            for(int i=0; i<n-1; i++){
                result+=Math.abs(nums[i]-nums[i+1]);
            }
            maxResult=Math.max(result,maxResult);
            return;
        }

        for(int i=0; i<n; i++){
            nums[cnt]=arr[i];
            if(isSelected[i]) continue;
            isSelected[i]=true;
            perm(cnt+1);
            isSelected[i]=false;
        }
    }
}