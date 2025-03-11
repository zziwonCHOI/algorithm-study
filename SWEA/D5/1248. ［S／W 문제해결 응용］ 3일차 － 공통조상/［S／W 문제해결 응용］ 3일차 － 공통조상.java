import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static class Node{
        int right, left, parent, data;
        public Node(int d){
            data=d;
            right=0;
            left=0;
            parent=0;
        };
    }
    static int v,e,targetA,targetB;
    static Node[] nodes;
    static boolean[] visited;
    static int commonParent, size;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T=Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            st=new StringTokenizer(br.readLine());
            v=Integer.parseInt(st.nextToken());
            e=Integer.parseInt(st.nextToken());
            targetA=Integer.parseInt(st.nextToken());
            targetB=Integer.parseInt(st.nextToken());

            
            nodes=new Node[v+1];
            for(int i=1; i<=v; i++){
                nodes[i]=new Node(i);
            }
            st=new StringTokenizer(br.readLine());
            for(int i=0; i<e; i++){
                int a=Integer.parseInt(st.nextToken());
                int b=Integer.parseInt(st.nextToken());

                if(nodes[a].left==0){
                    nodes[a].left=b;
                }else{
                    nodes[a].right=b;
                }
                nodes[b].parent=a;
            }

            visited=new boolean[v+1];
            size=0;
            bfs(targetA,targetB);
            System.out.println("#"+t+" "+commonParent+" "+size);
        }
    }

    public static void bfs(int a, int b){
        commonParent=0;

        while(true){
            if(a!=1){
                int parent=nodes[a].parent;
                if(visited[parent]){
                    commonParent=parent;
                    break;
                }
                visited[parent]=true;
                a=parent;
            }
            if(b!=1){
                int parent=nodes[b].parent;
                if(visited[parent]){
                    commonParent=parent;
                    break;
                }
                visited[parent]=true;
                b=parent;
            }
        }
        get(nodes[commonParent]);
    }

    public static void get(Node n){
        size++;
        if(n.left!=0){
            get(nodes[n.left]);
        }
        if(n.right!=0){
            get(nodes[n.right]);
        }
    }
}