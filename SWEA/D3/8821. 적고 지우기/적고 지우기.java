import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            String line=br.readLine();

            Set<Integer> set=new HashSet<>();
            for(int i=0; i<line.length(); i++){
                int cur=line.charAt(i)-'0';
                if(!set.isEmpty()&&set.contains(cur)){
                    set.remove(cur);
                }else{
                    set.add(cur);
                }
            }

            System.out.println("#"+t+" "+set.size());
        }

    }
}