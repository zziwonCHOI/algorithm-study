import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[][] arr;
    static int[] dx={0,1,0,-1};
    static int[] dy={1,0,-1,0};

    static int n;

    static int cnt=1;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T=Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            n=Integer.parseInt(br.readLine());
            arr=new int[n][n];
            int max=Integer.MIN_VALUE;
            int curNum=0;
            for(int i=0; i<n; i++){
                st=new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++){
                   arr[i][j]= Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    cnt=1;
                    int c=dfs(i,j);
                    if(max<c){
                        max=c;
                        curNum=arr[i][j];
                    }else if(max==c){
                        if(curNum>arr[i][j]){
                            curNum=arr[i][j];
                        }
                    }
                }
            }

            System.out.println("#"+t+" "+curNum+" "+max);

        }
    }

    public static int dfs(int startX, int startY){
        for(int i=0; i<4; i++){
            int x=startX+dx[i];
            int y=startY+dy[i];
            if(x>=0&&y>=0&&x<n&&y<n){
                if(arr[startX][startY]+1==arr[x][y]){
                    cnt++;
                    dfs(x,y);
                }

            }
        }
        return cnt;
    }
}