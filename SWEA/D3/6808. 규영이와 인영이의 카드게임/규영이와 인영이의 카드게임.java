import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[] in;
    static int[] gyu;

    static int winCnt, loseCnt;
    static int[] cards; //인영이가 뽑은 카드를 임시 저장
    static boolean[] isSelected;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T=Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            st=new StringTokenizer(br.readLine());

            in=new int[9];
            gyu=new int[9];

            boolean[] cardCheck=new boolean[19];
            for(int i=0; i<9; i++){
                int c=Integer.parseInt(st.nextToken());
                gyu[i]=c;
                cardCheck[c]=true;

            }
            int cnt=0;
            for(int i=1; i<=18; i++){
                if(!cardCheck[i]){
                    in[cnt]=i;
                    cnt++;
                }
            }
            winCnt=0;
            loseCnt=0;
            cards=new int[9];
            isSelected=new boolean[9];
            gamePerm(0);

            System.out.println("#"+t+" "+winCnt+" "+loseCnt);
        }
    }


    public static void gamePerm(int cnt){

        if(cnt==9){
            int gyuSum=0;
            int inSum=0;
            for(int i=0; i<9;i++){
                if(gyu[i]>cards[i]){
                    gyuSum+=gyu[i]+cards[i];
                }else if(gyu[i]<cards[i]){
                    inSum+=gyu[i]+cards[i];
                }
            }

            if(gyuSum>inSum){
                winCnt++;
            }else if(gyuSum<inSum){
                loseCnt++;
            }
            return;
        }

        for(int i=0; i<9; i++){
            if(isSelected[i]) continue;
            cards[cnt]=in[i];
            isSelected[i]=true;
            gamePerm(cnt+1);
            isSelected[i]=false;
        }
    }
}