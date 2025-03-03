import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    public static class Player{
        int row,col,depth;
        public Player(int r, int c, int d){
            row=r;
            col=c;
            depth=d;
        }
    }
    static int endX, endY,startX, startY;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx={0,1,0,-1};
    static int[] dy={1,0,-1,0};
    static int n;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T=Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            n=Integer.parseInt(br.readLine());
            arr=new int[n][n];
            visited=new boolean[n][n];
            ans=0;
            for(int i=0; i<n; i++){
                st=new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++){
                    arr[i][j]=Integer.parseInt(st.nextToken());
                }
            }

            st=new StringTokenizer(br.readLine());
            startX=Integer.parseInt(st.nextToken());
            startY=Integer.parseInt(st.nextToken());

            st=new StringTokenizer(br.readLine());
            endX=Integer.parseInt(st.nextToken());
            endY=Integer.parseInt(st.nextToken());

            System.out.println("#"+t+" "+(bfs()?ans:-1));
        }
    }
    public static boolean bfs(){

        Queue<Player> queue=new LinkedList<>();
        queue.add(new Player(startX,startY,0));
        visited[startX][startY]=true;

        while(!queue.isEmpty()){
            Player cur=queue.poll();
            int curX=cur.row;
            int curY= cur.col;

            for(int k=0; k<4; k++){
                int X=curX+dx[k];
                int Y=curY+dy[k];

                if(X<0||Y<0||X>=n||Y>=n) continue;

                if(X==endX&&Y==endY) {
                    ans=cur.depth+1;
                    return true;
                }
                if(arr[X][Y]==1||visited[X][Y]) continue;

                if(arr[X][Y]==2){
                    if(cur.depth%3==2){
                        visited[X][Y]=true;
                        queue.add(new Player(X,Y,cur.depth+1));
                    }else{
                        visited[cur.row][cur.col]=true;
                        queue.add(new Player(cur.row,cur.col,cur.depth+1));
                    }
                }else{
                    visited[X][Y]=true;
                    queue.add(new Player(X,Y,cur.depth+1));
                }
            }

        }
        return false;
    }
}