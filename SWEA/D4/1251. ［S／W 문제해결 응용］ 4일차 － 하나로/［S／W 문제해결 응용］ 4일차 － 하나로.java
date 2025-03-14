import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	//가중치 정렬을 위한 Edge 클래스 만들기 (간선 정보 저장)
	static class Edge implements Comparable<Edge>{
		int from, to;
		long cost;
		
		Edge(int from, int to, long cost){
			this.from=from;
			this.to=to;
			this.cost=cost;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Long.compare(this.cost, o.cost);
		}
		
		
	}
	static int n;
	static int[] parent;
	public static void makeSet() {
		for(int i=0;i<n; i++) {
			parent[i]=i;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T=Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			n=Integer.parseInt(br.readLine());
			long[] x=new long[n];
			long[] y=new long[n];
		
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<n; i++) {
				x[i]=Long.parseLong(st.nextToken());
			}
			
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<n; i++) {
				y[i]=Long.parseLong(st.nextToken());
			}
			double E=Double.parseDouble(br.readLine());
			
			parent=new int[n];
			//makeset
			for(int i=0; i<n;i++) parent[i]=i;
			
			//가능한 모든 간선을 priority queue에 저장 
			PriorityQueue<Edge> pq=new PriorityQueue<>();
			for(int i=0; i<n; i++) {
				for(int j=i+1; j<n; j++) {
					Long L=(x[i]-x[j])*(x[i]-x[j])+(y[i]-y[j])*(y[i]-y[j]);
					pq.add(new Edge(i, j, L));
				}
			}
			
			long ans=0; //최소 신장 트리의 총 비용
			int cnt=0; //선택된 간선 개수 
			while(!pq.isEmpty()) {
				Edge e=pq.poll();
				
				//두 노드가 같은 집합이면 사이클이므로 무시 
				if(union(e.from, e.to)) continue;
				ans+=e.cost;//최소 비용 누적 
				if(++cnt==n-1) break; //MST가 완선되면 종료 
				
			}
			System.out.println("#"+t+" "+Math.round(ans*E));
			
		}
	}
	
	public static int find(int x) {
		if(parent[x]==x) return x;
		
		return parent[x]=find(parent[x]);
	}
	
	public static boolean union(int a, int b) {
		int pa=find(a);
		int pb=find(b);
		
		if(pa==pb) return true; //이미 같은 집합이면 합칠 필요 없음(사이클 발생)
		
		parent[pb]=pa; //b의 부모를 a로 설정(집합 병합)
		return false;
	}
	

}