import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int T=Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            int n=Integer.parseInt(br.readLine());
            int hour=0;
            int min=0;

            if(n*2>=60) {
                hour = n * 2 / 60;
                min = n * 2 % 60;
                if (hour >12) {
                    hour -= 12;
                }else if(hour==0){
                    hour=12;
                }

                System.out.println("#" + t + " " + hour + " " + min);
            }else{
                min=n*2;
                System.out.println("#"+t+" "+0+" "+min);
            }
        }
    }
}