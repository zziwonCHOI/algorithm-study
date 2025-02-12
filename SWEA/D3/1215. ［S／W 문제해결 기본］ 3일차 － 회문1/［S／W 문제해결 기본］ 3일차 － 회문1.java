
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        for(int t=1; t<=10; t++){
            int n=sc.nextInt();
            sc.nextLine();

            int cnt=0;
            char[][] arr=new char[8][8];
            for(int i=0; i<8; i++){
                char[] line=sc.nextLine().toCharArray();
                for(int j=0; j<8; j++){
                    arr[i][j]=line[j];
                }
            }

            //행 체크
            for(int i=0; i<8; i++){
                for(int j=0; j<8-n+1; j++){
                    boolean check=true;
                    for(int k=0; k<n/2; k++){
                        if(arr[i][j+k]!=arr[i][j+n-1-k]){
                            check=false;
                            break;
                        }
                    }
                    if(check) cnt++;
                }
            }

            //열 체크
            for(int i=0; i<8-n+1; i++){
                for(int j=0; j<8; j++){
                    boolean check=true;
                    for(int k=0; k<n/2; k++){
                        if(arr[i+k][j]!=arr[i+n-1-k][j]){
                            check=false;
                            break;
                        }
                    }
                    if(check) cnt++;
                }
            }
            System.out.println("#"+t+" "+cnt);
        }
    }
}
