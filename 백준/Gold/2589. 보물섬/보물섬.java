
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int m,n;
    static char[][] map;
    static int[] dx={0,1,0,-1};
    static int[] dy={1,0,-1,0};


    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        map=new char[n][m];
        for(int i=0; i<n; i++){
            String s=br.readLine();
            for(int j=0; j<m; j++){
                map[i][j]=s.charAt(j);
            }
        }

        int max=Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j]=='L'){
                    int d=bfs(i,j);
                    max=Math.max(d,max);
                }
            }
        }

        System.out.println(max);

    }

    public static int bfs(int x, int y){
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[] {x,y});

        int[][] distance=new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                distance[i][j]=-1;
            }
        }
       distance[x][y]=0;
        int maxDepth=0;

        while(!q.isEmpty()){
            int[] cur=q.poll();
            for(int k=0; k<4; k++){
                int curx=cur[0]+dx[k];
                int cury=cur[1]+dy[k];
                if(curx<0||cury<0||curx>=n||cury>=m) continue;

                if(distance[curx][cury]==-1&&map[curx][cury]=='L'){
                    distance[curx][cury]=distance[cur[0]][cur[1]]+1;
                    q.add(new int[]{curx,cury});
                }
            }
        }
        //가장 멀리 있는 지점의 거리를 반환
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(distance[i][j]>maxDepth){
                    maxDepth=distance[i][j];
                }
            }
        }
        return maxDepth;
    }
}
