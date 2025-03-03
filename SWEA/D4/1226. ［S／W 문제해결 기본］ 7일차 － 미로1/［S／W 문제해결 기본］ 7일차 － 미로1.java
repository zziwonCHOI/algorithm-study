import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx={0,1,0,-1};
    static int[] dy={1,0,-1,0};
    static boolean check;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        for(int t=1; t<=10; t++){
            br.readLine();

            arr=new int[16][16];
            for(int i=0; i<16; i++){
                String[] line=br.readLine().split("");
                for(int j=0; j<16; j++){
                    arr[i][j]=Integer.parseInt(line[j]);
                }
            }

            visited=new boolean[16][16];
            check=false;
            dfs(1,1);
            System.out.print("#"+t+" ");
            System.out.println(check?1:0);
        }
    }
    public static void dfs(int startX, int startY){
        visited[startX][startY]=true;

        for(int k=0; k<4; k++){
            int x=startX+dx[k];
            int y=startY+dy[k];
            if(arr[x][y]==3){
                check=true;
                return;
            }
            if(x>=0&&y>=0&&x<16&&y<16&&arr[x][y]!=1&&!visited[x][y]){
                dfs(x,y);
            }
        }
    }
}