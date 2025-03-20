import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.chrono.MinguoChronology;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T=Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            br.readLine();
            Map<Integer, Integer> map=new HashMap<>();
            st=new StringTokenizer(br.readLine());
            for(int i=0; i<1000; i++){
                int num=Integer.parseInt(st.nextToken());
                map.put(num,map.getOrDefault(num,0)+1);
            }

            int max=Integer.MIN_VALUE;
            int key=0;
            for(int i:map.keySet()){
                if(map.get(i)>max){
                    key=i;
                    max=map.get(i);
                }else if(map.get(i)==max){
                    if(key<i){
                        key=i;
                    }
                }
            }

            System.out.println("#"+t+" "+key);

        }
    }
}