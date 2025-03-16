import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int n,m,c;
    static int[][] arr;
    static int maxProfit;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T=Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            st=new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken()); //벌통의 크기
            m=Integer.parseInt(st.nextToken()); //선택할 수 있는 벌통의 수
            c=Integer.parseInt(st.nextToken()); //꿀을 채취할 수 있는 최대 양
            arr=new int[n][n];
            for(int i=0; i<n; i++){
                st=new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++){
                    arr[i][j]=Integer.parseInt(st.nextToken());
                }
            }

            maxProfit=0;

            System.out.println("#"+t+" "+honeyGet());
        }

    }

    public static int honeyGet() {

        int max1=Integer.MIN_VALUE;
        int max2=Integer.MIN_VALUE;
        int result=0;

        for(int i=0; i<n;i++){
            for(int j=0; j<=n-m; j++){
                maxProfit=0;
                //x좌표, y좌표, 벌통의 개수, 채취한 꿀의 양, 얻은 이익
                cal(i,j,0,0,0);
                max1=maxProfit;
                maxProfit=0;
                max2=0;

                //일꾼2 발톨 선택 시작(같은 행일 경우)
                for(int j2=j+m; j2<=n-m; j2++){
                    cal(i,j2,0,0,0);
                    max2=Math.max(max2,maxProfit);
                }

                //다른 행에서 선택하는 경우
                for(int i2=i+1; i2<n; i2++){
                    for(int j2=0; j2<=n-m; j2++){
                        cal(i2,j2,0,0,0);
                        max2=Math.max(max2,maxProfit);
                    }
                }

                //일꾼1이 벌통을 새로 선택했을 때마가 전체 이익 최댓값으로 갱신
                result=Math.max(result,max1+max2);
            }
        }

        return result;
    }
    public static void cal(int i, int j, int cnt,int sum, int benefit){

        if(sum>c){
            return;
        }
        if(cnt==m){
            if(maxProfit<benefit){
                maxProfit=benefit;
            }
            return;
        }

        //선택
        cal(i,j+1,cnt+1, sum+arr[i][j],benefit+arr[i][j]*arr[i][j]);
        //비선택
        cal(i,j+1,cnt+1, sum, benefit);
    }

}