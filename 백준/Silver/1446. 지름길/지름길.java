
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int d=sc.nextInt();
        sc.nextLine();


        List<List<int[]>> graph=new ArrayList<>();
        for(int i=0; i<=d; i++){
            graph.add(new ArrayList<>());
        }

        //기본 도로 추가
        for(int i=0; i<d; i++){
            graph.get(i).add(new int[]{i+1,1});
        }

        //지름길 정보 입력받기
        for(int i=0; i<n; i++){
            int start=sc.nextInt();
            int end=sc.nextInt();
            int dist=sc.nextInt();
            if(end<=d){
                graph.get(start).add(new int[]{end,dist});
            }

        }

        //다익스트라 알고리즘 실행
        int[] distnace=new int[d+1]; //distance는 0번 위치에서 index 번호까지 가는 최단 거리 저장
        Arrays.fill(distnace,Integer.MAX_VALUE);
        distnace[0]=0;

        PriorityQueue<int[]> pq=new PriorityQueue<>(Comparator.comparingInt(a->a[1]));
        pq.offer(new int[]{0,0}); //시작점 (0, 거리0)

        while(!pq.isEmpty()){
            int[] cur=pq.poll();
            int curPos=cur[0]; //현재 노드 위치
            int curDist=cur[1];//현재 노드까지의 최단거리

            if(curDist>distnace[curPos]){ //더 짧은 거리로 방문한 경우
                continue;
            }

            for(int[] next: graph.get(curPos)){//현재 위치에서 이동할 수 있는 모든 노드 탐색
                int nextPos=next[0]; //다음 노드
                int nextDist=curDist+next[1];//현재 거리+이동 거리

                if(nextDist<distnace[nextPos]){
                    distnace[nextPos]=nextDist;
                    pq.offer(new int[]{nextPos,nextDist});
                }
            }
        }

        System.out.println(distnace[d]);
    }
}
