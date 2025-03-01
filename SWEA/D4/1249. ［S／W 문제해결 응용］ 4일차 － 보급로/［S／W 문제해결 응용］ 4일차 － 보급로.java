import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static final int INF=999999;
    static int[] dx={0,1,0,-1};
    static int[] dy={1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());


        for(int t=1; t<=T; t++){
            int n=Integer.parseInt(br.readLine());
            int[][] arr=new int[n][n];

            for(int i=0; i<n; i++){
                String[] line=br.readLine().split("");
                for(int j=0; j<n; j++){
                    arr[i][j]=Integer.parseInt(line[j]);
                }
            }

            int[][] distance=new int[n][n];

            for(int i=0; i<n; i++){
                Arrays.fill(distance[i],INF);
            }


            PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[2]-o2[2];
                }
            });

            distance[0][0]=0;
            pq.add(new int[]{0,0,0});

            while(!pq.isEmpty()){
                int[] cur=pq.poll();
                int curX=cur[0];
                int curY=cur[1];
                int cost=cur[2];

                if(cost>distance[curX][curY]) continue;

                for(int k=0; k<4; k++){
                    int x=curX+dx[k];
                    int y=curY+dy[k];
                    if(x>=0&&y>=0&&x<n&&y<n){
                        int d=distance[curX][curY]+arr[x][y];
                        if(d<distance[x][y]){
                            distance[x][y]=d;
                            pq.add(new int[]{x,y,d});
                        }
                    }

                }
            }

            System.out.println("#"+t+" "+distance[n-1][n-1]);

        }


    }
}