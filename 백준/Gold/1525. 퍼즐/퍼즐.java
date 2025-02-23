import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String correct="123456780";
    static Map<String, Integer> map=new HashMap<>(); //이미 방문한 퍼즐 상태와 이동 횟수를 저장
    static int[] dx={0,1,0,-1};
    static int[] dy={1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String init="";

        for(int i=0; i<3; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                int num=Integer.parseInt(st.nextToken());
                init+=num;
            }
        }

        map.put(init,0);
        System.out.println(bfs(init));

    }

    public static int bfs(String init){
        Queue<String> queue=new LinkedList<>();
        queue.add(init);

        while(!queue.isEmpty()){
            String cur=queue.poll();
            int cnt= map.get(cur); //변경된 횟수
            int empty=cur.indexOf('0');
            int px=empty%3;
            int py=empty/3;

            if(cur.equals(correct)){
                return cnt;
            }

            //0 주변으로 탐색
            for(int i=0; i<4; i++){
                int nx=px+dx[i];
                int ny=py+dy[i];

                if(nx<0||ny<0||nx>2||ny>2){
                    continue;
                }

                int nPos=ny*3+nx; //이동할 위치의 문자열 인덱스(행 번호 *행 길이+ 열 번호 
                char ch=cur.charAt(nPos); //교환할 숫자
                String next=cur.replace(ch,'c');
                next=next.replace('0',ch);
                next=next.replace('c','0');

                if(!map.containsKey(next)){ //이미 방문한 상태인지 확인
                    queue.add(next);
                    map.put(next,cnt+1);
                }
            }

        }
        return -1;
    }
}