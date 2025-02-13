import java.util.*;

public class Main {
    static int n;
    static List<List<Integer>> graph;
    static StringBuilder sb=new StringBuilder();
    static boolean[] visited;

    static Queue<Integer> queue=new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
         n=sc.nextInt();
         int m=sc.nextInt();
         int v=sc.nextInt();
         sc.nextLine();

         graph=new ArrayList<>();
         for(int i=0; i<=n; i++){
             graph.add(new ArrayList<>());
         }
         visited=new boolean[n+1];

         for(int i=0; i<m; i++){
             int a=sc.nextInt();
             int b=sc.nextInt();
             graph.get(a).add(b);
             graph.get(b).add(a);
         }
        //오름차순 방문을 위해 정렬
        for(int i=1; i<=n; i++){
            Collections.sort(graph.get(i));
        }

         dfs(v);
         sb.append("\n");
         visited=new boolean[n+1];
         bfs(v);

        System.out.println(sb);
    }

    public static void dfs(int start){
        visited[start]=true;
        sb.append(start+" ");

        //인접한 노드 순회(연결된 노드만 확인)
        for(int next:graph.get(start)){
            if(!visited[next]){ //다음노드가 방문하지 않았던 노드이면
                dfs(next);
            }
        }
    }

    public static void bfs(int start){
        queue.add(start);
        visited[start]=true;

        while (!queue.isEmpty()){
            start=queue.poll();
            sb.append(start+" ");

            for(int next:graph.get(start)){
                if(!visited[next]){
                    queue.add(next);
                    visited[next]=true;
                }
            }
        }
    }
}
