import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[] parent;

    //find: 루트 노드 찾기
    static int find(int x){
        if(parent[x]!=x){
            parent[x]=find(parent[x]);
        }
        return parent[x];
    }

    //union: 두 집합 합치기
    static void union(int a, int b){
        int rootA=find(a);
        int rootB=find(b);
        //부모가 같지 않으면
        if(rootA!=rootB){
            parent[rootB]=rootA; //합치기
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T=Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());

            //부모 노드 초기화
            parent=new int[n+1];
            for(int i=1; i<=n; i++){
                parent[i]=i;
            }
            st=new StringTokenizer(br.readLine());
            for(int i=0; i<m; i++) {
                int a=Integer.parseInt(st.nextToken());
                int b=Integer.parseInt(st.nextToken());

                union(a,b);
            }

           int cnt=0;
            //각 사람마다 루트가 자기 자신인 노드는 그룹이 아니다.
            for(int i=1; i<=n; i++){
                if(parent[i]==i){
                    cnt++;
                }
            }


            System.out.println("#"+t+" "+cnt);


        }
    }
}