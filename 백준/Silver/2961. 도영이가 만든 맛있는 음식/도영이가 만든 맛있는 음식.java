import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] sour;
    static int[] bitter;
    static boolean[] sourCheck;
    static int minResult;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n=Integer.parseInt(br.readLine());
        sour=new int[n];
        bitter=new int[n];
        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            sour[i]=Integer.parseInt(st.nextToken());
            bitter[i]=Integer.parseInt(st.nextToken());
        }

        sourCheck=new boolean[n];
        minResult=Integer.MAX_VALUE;
        subset(0,0,1,0);
        System.out.println(minResult);
    }

    public static void subset(int idx, int depth, int s, int b){
        if(idx==n){
            if(depth>0){
                minResult=Math.min(Math.abs(s-b),minResult);
            }
            return;
        }
        subset(idx+1,depth+1, s*sour[idx],b+bitter[idx]);
        subset(idx+1,depth,s,b);
    }
}