
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main{
    static int[][] arr;
    static boolean[][] visited;

    static int[] dx={0,1,0,-1};
    static int[] dy={1,0,-1,0};
    static int n;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();

        //문제에서 잠기는 비의 양을 주지 않음 !! 비의 양에 따라 물에 잠길 수 있는 높이가 다를 수 있다고 했다.
        //-> 모든 가능한 h를 고려해서 안전한 영역이 최대일 때의 개수를 찾아야한다.

        int maxHeight=0; //가장 높은 빌딩의 높이
        arr=new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n;  j++){
                arr[i][j]=sc.nextInt();
                if(arr[i][j]>maxHeight){
                    maxHeight=arr[i][j];
                }
            }
        }

        int maxCnt=0; //안전영역 최대 개수
        for(int k=0; k<=maxHeight; k++){
            visited=new boolean[n][n];
            int cnt=0; //현재 h에 대한 안전 영역 개수
            for(int i=0; i<n; i++){
                for(int j=0; j<n;j++){
                    if(arr[i][j]>k&&!visited[i][j]){
                        cnt+=dfs(i,j,k);
                    }
                }
            }
            maxCnt=Math.max(maxCnt,cnt);
        }
        System.out.println(maxCnt);

    }

    public static int  dfs(int start, int end, int h){
        visited[start][end]=true;

        for(int i=0; i<4; i++){
            int x=start+dx[i];
            int y=end+dy[i];

            if(x>=0&&y>=0&&x<n&&y<n&&!visited[x][y]&&arr[x][y]>h){
                dfs(x,y,h);
            }
        }
        return 1;
    }
}
