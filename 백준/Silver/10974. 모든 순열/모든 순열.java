import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static StringBuilder sb=new StringBuilder();
    static int[] nums;
    static boolean[] isSelected;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        n=Integer.parseInt(br.readLine());
        nums=new int[n];
        isSelected=new boolean[n];
        perm(0);
        System.out.println(sb);
    }

    public static void perm(int cnt){
        if(cnt==n){
            for(int i:nums){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<n;i++){
            nums[cnt]=i+1;
            if(isSelected[i]) continue;
            isSelected[i]=true;
            perm(cnt+1);
            isSelected[i]=false;
        }
    }
}