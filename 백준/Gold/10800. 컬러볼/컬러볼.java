import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static class Ball{
        int color, size, idx;
        Ball(int idx, int color, int size){
            this.idx=idx;
            this.color=color;
            this.size=size;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n=Integer.parseInt(br.readLine());

        Ball[] balls=new Ball[n];

        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            int color=Integer.parseInt(st.nextToken());
            int size=Integer.parseInt(st.nextToken());
            balls[i]=new Ball(i,color,size);
        }

        Arrays.sort(balls,(o1,o2)->{
            if(o1.size==o2.size) return o1.color-o2.color;
            else return o1.size-o2.size;
        });

        int[] answer=new int[n];
        int[] color =new int[n+1]; //색 별 누적합
        int sum=0; //전체 누적합
        int size=0; //직전 공 크기
        int count=0;//개수

        Ball prev=null;

        for(Ball ball:balls){
            answer[ball.idx]=sum-color[ball.color];
            //이전 공과 사이즈가 같은 경우
            if(size==ball.size){
                //색도 같은 경우
                if(prev!=null && ball.color==prev.color){
                    answer[ball.idx]=answer[prev.idx];
                }else{
                    answer[ball.idx]-=count*size;
                }
                count++;

            }else{
                size=ball.size;
                count=1;
            }

            sum+=ball.size;
            color[ball.color]+=ball.size;
            prev=ball;
        }

        for(int result:answer){
            System.out.println(result);
        }

    }
}