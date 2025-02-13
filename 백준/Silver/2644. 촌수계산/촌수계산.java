
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] arr;
    static boolean[] visited;
    static int cnt=0;
    static int n;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        sc.nextLine();
        int a=sc.nextInt();
        int b=sc.nextInt();
        sc.nextLine();
        int len=sc.nextInt();
        sc.nextLine();

        arr=new int[n+1][n+1];
        visited=new boolean[n+1];

        for(int i=1; i<=len; i++){
            int one=sc.nextInt();
            int two=sc.nextInt();
            arr[one][two]=arr[two][one]=1;

        }
        System.out.println(bfs(a,b));
    }

    public static int bfs(int a, int b){
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{a,0});
        visited[a]=true;

        while(!queue.isEmpty()){
            int[] cur=queue.poll();
            int node=cur[0];
            int dep=cur[1];
            if(node==b){
                return dep;
            }
            for(int i=1; i<=n; i++){
                if(arr[node][i]==1&&!visited[i]){
                    queue.add(new int[]{i,dep+1});
                    visited[i]=true;
//                    cnt++; cnt는 방문한 노드의 개수만 세기 때문에 올바른 촌수를 계산하지 못한다.
                    //촌수를 정확히 계산하려면 탐색 깊이를 추적해야 한다.
                }
            }
        }
        return -1;
    }
}
