import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
    static int n,m;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static int maxlen;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T=Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            st=new StringTokenizer(br.readLine());

            n=Integer.parseInt(st.nextToken());
            m=Integer.parseInt(st.nextToken());

            graph=new ArrayList<>();
            for(int i=0; i<=n; i++){
                graph.add(new ArrayList<>());
            }

            for(int i=0; i<m; i++){
                st=new StringTokenizer(br.readLine());
                int a=Integer.parseInt(st.nextToken());
                int b=Integer.parseInt(st.nextToken());
                graph.get(a).add(b);
                graph.get(b).add(a);
            }


            maxlen=1; //최소 경로 길이는 1(정점 1개만 선택하는 경우)
            for(int i=1; i<=n; i++){
                visited=new boolean[n+1];
                dfs(i,1);
            }
            System.out.println("#"+t+" "+maxlen);
        }
    }
    public static void dfs(int start, int len){
        visited[start]=true;
        maxlen=Math.max(maxlen,len);
        for(int i:graph.get(start)){
            if(!visited[i]){
                dfs(i,len+1);
            }
        }
        visited[start]=false;

    }
}