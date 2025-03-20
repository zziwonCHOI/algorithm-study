import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int n, m;
    static int[][] arr;
    static int maxlen;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            arr = new int[n][m];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            maxlen = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(arr[i][j]==1){
                        search(i, j);
                    }
                }
            }

            System.out.println("#"+t+" "+maxlen);
        }

    }

    public static void search(int x, int y) {
        int cnt=0;
        for(int i=x; i<n; i++){
            if(arr[i][y]==1) {
                cnt ++;
                maxlen = Math.max(cnt, maxlen);
            }else{
                cnt=0;
            }
        }
        int cnt2=0;
        for(int i=y; i<m; i++){
            if(arr[x][i]==1) {
                cnt2 ++;
                maxlen = Math.max(cnt2, maxlen);
            }else{
                cnt2=0;
            }
        }

    }
}