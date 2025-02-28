import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	static int[] distance;
	static boolean[] visited;
	static final int INF=999999;
	static ArrayList<Node>[] graph;
	static StringBuilder sb=new StringBuilder();
	
	static class Node implements Comparable<Node>{
		int vertex;
		int weight;
		
		public Node(int v, int w) {
			this.vertex=v;
			this.weight=w;
		};
		
		public int compareTo(Node o) {
			return this.weight-o.weight;
		}
	}
	public static void main(String[] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int v=Integer.parseInt(st.nextToken());
		int e=Integer.parseInt(st.nextToken());
		
		
		//그래프 저장할때는 인접 리스트 사용하기 
		graph=new ArrayList[v+1];
		
		for(int i=1; i<=v;i++) {
			graph[i]=new ArrayList<Node>(); //리스트 초기화 
		}
		int start=Integer.parseInt(br.readLine());
		
		for(int i=0; i<e; i++) {
			st=new StringTokenizer(br.readLine());
			int from=Integer.parseInt(st.nextToken());
			int to=Integer.parseInt(st.nextToken());
			int w=Integer.parseInt(st.nextToken());
			
			graph[from].add(new Node(to,w));
			
		}
		distance=new int[v+1];
		visited=new boolean[v+1];
		Arrays.fill(distance, INF);
		dijkstra(start);
		
		for(int i=1; i<=v; i++) {
			if(distance[i]==INF) {
				sb.append("INF").append("\n");
				
			}else {
				sb.append(distance[i]).append("\n");

			}
		}
		System.out.println(sb);
	}
	
	
	public static void dijkstra(int start) {
		PriorityQueue<Node> pq=new PriorityQueue<Node>();
		distance[start]=0;
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node cur=pq.poll();
			int curV=cur.vertex;
			if(visited[curV]) continue;
			
			visited[curV]=true;
			
			//현재 정점에서 이동할 수 있는 모든 간선 선택
			for(Node n:graph[curV]) {
				int nV=n.vertex;
				int nd=n.weight+distance[curV];
			
				if(nd<distance[nV]) {
					distance[nV]=nd;
					pq.offer(new Node(nV, nd)); //해당 하는 정점 pq에 넣기 
				}
				
				
			}
		}
	}

}