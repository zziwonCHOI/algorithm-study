import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int t=1; t<=10; t++){
            int n=Integer.parseInt(br.readLine());
            List<String> ori=new ArrayList<>();
            st=new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                ori.add(st.nextToken());
            }

            int insertCnt=Integer.parseInt(br.readLine());
            st=new StringTokenizer(br.readLine());
            for(int i=0; i<insertCnt; i++){
                st.nextToken();
                int index=Integer.parseInt(st.nextToken());
                int cnt=Integer.parseInt(st.nextToken());
                for(int j=0; j<cnt;j++){
                    ori.add(index+j,st.nextToken());
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