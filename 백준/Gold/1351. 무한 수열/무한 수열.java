import java.io.*;
import java.util.*;

public class Main {
    static Map<Long, Long> map = new HashMap<>();
    static long n;
    static long p;
    static long q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Long.parseLong(st.nextToken());
        p = Long.parseLong(st.nextToken());
        q = Long.parseLong(st.nextToken());
        map.put(0L, 1L);
        find(n);
        System.out.println(map.get(n));
    }

    public static long find(long n) {
        if (map.containsKey(n)) return map.get(n);
        long first = find((long)Math.floor(n/p));
        long second = find((long)Math.floor(n/q));
        map.put(n, first+second);
        return first + second;
    }

}