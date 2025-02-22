import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        int n=Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0; i<n; i++){
            list.add(Integer.parseInt(br.readLine()));
        }

        for(int i:list){
            if(i==0){
                if(pq.isEmpty()){
                    sb.append(0+" ");
                }else{
                    sb.append(pq.poll()).append(" ");
                }
            }else{
                pq.add(i);
            }
        }
        System.out.println(sb);
    }
}