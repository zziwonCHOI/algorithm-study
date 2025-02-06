
import java.io.*;
import java.util.*;



//간선 정보를 저장하는 클래스
class Edge implements Comparable<Edge>{
    int start;
    int end;
    int weight;

    Edge(int start, int end, int weight){
        this.start=start;
        this.end=end;
        this.weight=weight;
    }

    //가중치 기준 오름차순 정렬
    public int compareTo(Edge o){
        return weight-o.weight;
    }
}
public class  Main {
    static int[] parent;
    static ArrayList<Edge> edgeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N=Integer.parseInt(br.readLine());
        int M=Integer.parseInt(br.readLine());

        edgeList=new ArrayList<>();

        for(int i=0; i<M; i++){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            int weight=Integer.parseInt(st.nextToken());

            edgeList.add(new Edge(start, end, weight));
        }
        parent =new int[N+1];
        for(int i=1; i<=N; i++){
            //일단 자기 자신으로 부모노드 설정
            parent[i]=i;
        }

        Collections.sort(edgeList);//가중치를 기준으로 오름차순 정렬

        int result=0;

        for(int i=0; i<edgeList.size(); i++){
            Edge edge=edgeList.get(i);

            //사이클이 발생하는 간선을 제외
            if(find(edge.start)!=find(edge.end)){ //부모 노드가 서로 같지 않을 때 사이클이 돌지 않는다.
                result+=edge.weight; //가중치로 연결(추가)
                union(edge.start,edge.end); //두 노드를 같은 집합으로 병합
            }
        }
        bw.write(result+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
    public static int find(int x){
        if(x== parent[x]){ //자신과 부모가 같을때
            return x;

        }
        return  parent[x]=find(parent[x]);
    }

    public static void union(int x, int y){
        x=find(x);
        y=find(y);

        //부모가 같지 않은 노드라면
        if(x!=y){
            //부모 노드 변경해주기
            parent[y]=x;
        }
    }
}
