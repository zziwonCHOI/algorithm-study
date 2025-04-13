import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int n;
    static int limitCut;
    static char[][] map;
    static boolean[][][][] visited;
    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
    static int dir;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T=Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            st=new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());
            limitCut=Integer.parseInt(st.nextToken());

            map=new char[n][n];
            int startX=0;
            int startY=0;
            for(int i=0; i<n; i++){
                String line=br.readLine();
                for(int j=0; j<n; j++){
                    map[i][j]=line.charAt(j);

                    if(map[i][j]=='X'){
                        startX=i;
                        startY=j;
                    }
                }
            }

            visited=new boolean[n][n][4][6];
            dir=0;
            int result=bfs(startX,startY);

            System.out.println("#"+t+" "+result);
        }
    }

    public static int bfs(int x, int y){
        Queue<int[]> q=new LinkedList<>();
        //좌표, dir, limitCut, 조작 횟수
        q.add(new int[] {x,y,0,limitCut,0});
        visited[x][y][0][limitCut]=true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int dir = cur[2];
            int cutLeft = cur[3];
            int cnt = cur[4];

            int nx = cx + dx[dir];
            int ny = cy + dy[dir];

            if (nx >=0 &&ny >= 0 && nx < n && ny < n) {
                int newCnt = cnt+1;
                if (map[nx][ny] == 'Y') {
                    return newCnt;
                }

                if(map[nx][ny]=='G'){
                    if(!visited[nx][ny][dir][cutLeft]){
                        q.add(new int[]{nx,ny,dir,cutLeft,newCnt});
                        visited[nx][ny][dir][cutLeft]=true;
                    }
                }else if(map[nx][ny]=='T'){
                    if(cutLeft>0){
                        if(!visited[nx][ny][dir][cutLeft-1]){
                            visited[nx][ny][dir][cutLeft-1]=true;
                            q.add(new int[]{nx,ny,dir,cutLeft-1,newCnt});
                        }
                    }
                }

            }
            //좌회전
            int leftDir=(dir+3)%4;
            if(!visited[cx][cy][leftDir][cutLeft]){
                visited[cx][cy][leftDir][cutLeft]=true;
                q.add(new int[]{cx,cy,leftDir,cutLeft,cnt+1});
            }

            //우회전
            int rightDir=(dir+1)%4;
            if(!visited[cx][cy][rightDir][cutLeft]){
                visited[cx][cy][rightDir][cutLeft]=true;
                q.add(new int[]{cx,cy,rightDir,cutLeft,cnt+1});
            }
        }
        return -1;
    }
}
