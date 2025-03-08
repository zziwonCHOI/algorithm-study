import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        for(int t=1; t<=10; t++){
            br.readLine();
            String part=br.readLine();
            String line=br.readLine();

            int result=0;
           for(int i=0; i<=line.length()-part.length();i++){
               String check=line.substring(i,i+part.length());
               if(check.equals(part)){
                   result++;
               }
           }
            System.out.println("#"+t+" "+result);
        }
    }
}