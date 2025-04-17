import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] scores = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                scores[i] = Integer.parseInt(st.nextToken());
            }

            Set<Integer> set = new HashSet<>();
            set.add(0); // 아무것도 안 풀었을 때 0점

            for (int score : scores) {
                Set<Integer> temp = new HashSet<>();
                for (int s : set) {
                    temp.add(s + score); // 현재 점수 포함
                }
                set.addAll(temp); // 기존에 있던 합들과 새롭게 만든 합들 합치기
            }

            System.out.println("#" + t + " " + set.size());
        }
    }
}