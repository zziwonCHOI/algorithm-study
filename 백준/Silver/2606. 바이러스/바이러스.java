import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] arr;
    static boolean[] visited;
    static int n;
    static int cnt=0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        n=sc.nextInt();
        int m=sc.nextInt();
        sc.nextLine();

        arr=new int[n+1][n+1];
        visited=new boolean[n+1];
        for(int i=1; i<=m; i++){
            int a=sc.nextInt();
            int b=sc.nextInt();

            arr[a][b]=arr[b][a]=1;
        }
        dfs(1);

        System.out.println(cnt);
    }

    public static void dfs(int start){
        visited[start]=true;

        for(int i=1; i<=n; i++){
            if(arr[start][i]==1&& !visited[i]){
                cnt++;
                dfs(i);
            }
        }
    }
}
