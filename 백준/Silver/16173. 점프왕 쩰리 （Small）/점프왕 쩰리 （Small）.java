import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int n;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();
        System.out.println("Hing");
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            int jump = map[x][y];

            if (map[x][y] == -1) {
                System.out.println("HaruHaru");
                System.exit(0); 
            }

            if (jump == 0) continue;

            int ny = y + jump;
            if (ny < n && !visited[x][ny]) {
                queue.add(new int[]{x, ny});
                visited[x][ny] = true;
            }

            int nx = x + jump;
            if (nx < n && !visited[nx][y]) {
                queue.add(new int[]{nx, y});
                visited[nx][y] = true;
            }
        }
    }
}