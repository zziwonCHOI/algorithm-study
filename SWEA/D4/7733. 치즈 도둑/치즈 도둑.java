import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int n;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx={0,1,0,-1};
    static int[] dy={1,0,-1,0};

    static boolean[][] checked;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T=Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            n=Integer.parseInt(br.readLine());
            arr=new int[n][n];
            int maxCnt=Integer.MIN_VALUE;
            PriorityQueue<Integer> pq=new PriorityQueue<>();
            for(int i=0; i<n; i++){
                st=new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++){
                    arr[i][j]=Integer.parseInt(st.nextToken());
                    if(!pq.contains(arr[i][j])){
                        pq.add(arr[i][j]);
                    }
                }
            }
            visited = new boolean[n][n];
            maxCnt=Math.max(maxCnt,chunkCheck());
            for(int i:pq){
                int c=eatEngel(i);
                maxCnt=Math.max(c,maxCnt);
            }

            System.out.println("#"+t+" "+maxCnt);
        }

    }

    public static int eatEngel(int eatNum){
        visited=new boolean[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j]<=eatNum){
                    visited[i][j]=true;
                }
            }
        }


        return chunkCheck();
    }


    public static int chunkCheck(){
        checked=new boolean[n][n];
        for(int i=0; i<n; i++){
            checked[i]=visited[i].clone();
        }
        int cnt=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!checked[i][j]){
                    bfs(i,j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void bfs(int x, int y){
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{x,y});
        while(!q.isEmpty()){
            int[] cur=q.poll();
            int cx=cur[0];
            int cy=cur[1];
            for(int k=0; k<4; k++){
                int nx=cx+dx[k];
                int ny=cy+dy[k];

                if(nx<0||ny<0||nx>=n||ny>=n) continue;

                if(!checked[nx][ny]){
                    checked[nx][ny]=true;
                    q.add(new int[]{nx, ny});
                }

            }
        }
    }
}