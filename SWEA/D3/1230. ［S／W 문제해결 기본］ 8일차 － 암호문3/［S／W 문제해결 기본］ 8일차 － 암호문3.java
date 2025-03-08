import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static List<String > ori;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int t=1; t<=10; t++){
            ori=new ArrayList<>();
            int n=Integer.parseInt(br.readLine());
            st=new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                ori.add(st.nextToken());
            }
            int doCnt=Integer.parseInt(br.readLine());
            st=new StringTokenizer(br.readLine());
            for(int i=0; i<doCnt; i++){
                char c=st.nextToken().charAt(0);
                if(c=='I'){
                    int index=Integer.parseInt(st.nextToken());
                    int cnt=Integer.parseInt(st.nextToken());
                    for(int j=0; j<cnt; j++){
                        ori.add(index+j,st.nextToken());
                    }
                } else if (c=='D') {
                    int index=Integer.parseInt(st.nextToken());
                    int cnt=Integer.parseInt(st.nextToken());
                    for(int j=0; j<cnt; j++){
                        ori.remove(index);
                    }
                }else if(c=='A'){
                    int cnt=Integer.parseInt(st.nextToken());
                    for(int j=0; j<cnt;j++){
                        ori.add(st.nextToken());
                    }
                }
            }
            StringBuilder sb=new StringBuilder();
            for(int i=0; i<10; i++){
                sb.append(ori.get(i)).append(" ");
            }
            System.out.println("#"+t+" "+sb);
        }
    }
}