import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int n,m;
    static int[] dx={0,1,0,-1};
    static int[] dy={1,0,-1,0};
    static char[][] arr;
    static int maxCnt;
    static int aCnt, bCnt;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T=Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            st=new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());
            m=Integer.parseInt(st.nextToken());

            arr=new char[n][m];
            for(int i=0; i<n; i++){
                String s=br.readLine();
                for(int j=0; j<m; j++){
                    arr[i][j]=s.charAt(j);
                }
            }
            visited=new boolean[n][m];
            maxCnt=Integer.MIN_VALUE;
            aCnt=0;
            bCnt=0;

            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(!visited[i][j]&&arr[i][j]!='_'){
                        if(arr[i][j]=='A'){
                            int c=groupCheck(i,j,'A');
                            maxCnt=Math.max(maxCnt,c);
                            aCnt++;
                        }else if(arr[i][j]=='B'){
                            int c=groupCheck(i,j,'B');
                            maxCnt=Math.max(maxCnt,c);
                            bCnt++;
                        }
                    }
                }
            }

            System.out.println("#"+t+" "+aCnt+" "+bCnt+" "+maxCnt);
        }
    }

    public static int groupCheck(int x, int y, char type){
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{x,y});
        visited[x][y]=true;
        int cnt=1;
        while(!q.isEmpty()){
            int[] cur=q.poll();
            for(int k=0; k<4; k++){
                int nx=cur[0]+dx[k];
                int ny=cur[1]+dy[k];

                if(nx<0||ny<0||nx>=n||ny>=m) continue;

                if(type==arr[nx][ny]&&!visited[nx][ny]){
                    visited[nx][ny]=true;
                    cnt++;
                    q.add(new int[]{nx,ny,type});
                }
            }
        }
        return cnt;
    }
}