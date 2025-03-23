import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int n;
    static char[][] arr;
    static int[] dx={0,1,1,1,0,-1,-1,-1};
    static int[] dy={1,1,0,-1,-1,-1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T=Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            n=Integer.parseInt(br.readLine());
            arr=new char[n][n];
            for(int i=0; i<n;i++){
                st=new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++){
                    arr[i][j]=st.nextToken().charAt(0);
                }
            }

            int maxDepth=Integer.MIN_VALUE;
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(arr[i][j]=='W'){
                        int depth=check(i,j);
                        if(depth>maxDepth){
                            maxDepth=depth;
                        }
                    }
                }
            }

            System.out.println("#"+t+" "+maxDepth);
        }
    }

    public static int check(int x, int y){
        int d=0;
        for(int i=0; i<8; i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(nx<0||ny<0||nx>=n||ny>=n) continue;

            if(arr[nx][ny]=='W'){
                d++;
            }
        }
        return d!=0?d:1;
    }
}