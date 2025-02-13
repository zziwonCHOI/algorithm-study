
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] arr;
    static boolean[] visited;
    static int n;

    static StringBuilder sb=new StringBuilder();
    static Queue<Integer> queue=new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        int m=sc.nextInt();
        int v=sc.nextInt();
        sc.nextLine();

        arr=new int[n+1][n+1]; //노드는 1부터 시작하기 때문에 n+1로 선언
        visited=new boolean[n+1];

        for(int i=0; i<m; i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            arr[a][b]=arr[b][a]=1;
        }

        dfs(v);
        sb.append('\n');
        visited=new boolean[n+1];
        bfs(v);
        System.out.println(sb);
    }

    public static void dfs(int start){
        visited[start]=true;
        sb.append(start+" ");

        for(int i=1; i<=n; i++){ //노드의 수만큼 반복 1번 노드~ n번 노드
            if(arr[start][i]==1 && !visited[i]){
                dfs(i);

            }
        }

    }

    public static void bfs(int start){
        queue.add(start);
        visited[start]=true;

        while(!queue.isEmpty()){
            start=queue.poll();
            sb.append(start+" ");
            for(int i=1; i<=n; i++){
                if(arr[start][i]==1 && !visited[i]){
                    queue.add(i);
                    visited[i]=true;
                }
            }

        }
    }
}
