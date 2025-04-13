import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    static int[][] arr;
    static boolean[][] visited;
    static int[] dx={0,1,0,-1};
    static int[] dy={1,0,-1,0};
    static boolean isPossible;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        

        for(int t=1; t<=10; t++){
            br.readLine();
            arr=new int[16][16];
            for(int i=0;i<16; i++){
                String line=br.readLine();
                for(int j=0; j<16; j++){
                    arr[i][j]=line.charAt(j)-'0';
                }
            }

            visited=new boolean[16][16];
            isPossible=false;
            bfs(1,1);

            System.out.println("#"+t+" "+(isPossible?1:0));
        }
    }

    public static void bfs(int x, int y){
        Queue<int[]> q=new LinkedList<>();

        q.add(new int[] {x,y});
        visited[x][y]=true;

        while(!q.isEmpty()){
            int[] cur=q.poll();
            for(int k=0; k<4; k++){
                int nx=cur[0]+dx[k];
                int ny=cur[1]+dy[k];
                if(nx<0||ny<0||nx>=16||ny>=16||arr[nx][ny]==1) continue;

                if(arr[nx][ny]==3){
                    isPossible=true;
                    return;
                }

                if(arr[nx][ny]==0 && !visited[nx][ny]){
                    visited[nx][ny]=true;
                    q.add(new int[] {nx,ny});
                }
            }
        }
    }
}
