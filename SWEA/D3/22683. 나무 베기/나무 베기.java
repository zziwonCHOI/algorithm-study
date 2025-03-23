import java.io.*;
import java.util.*;

public class Solution {
    static int n, k;
    static char[][] map;
    static boolean[][][][] visited;
    static int startx, starty, endx, endy;


    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    // 상태 클래스 정의
    static class State {
        int x, y, dir, cut, cost;

        public State(int x, int y, int dir, int cut, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cut = cut;
            this.cost = cost;
        }
    }

    public static int bfs() {
        Queue<State> q = new LinkedList<>();
        q.add(new State(startx, starty, 0, 0, 0)); // 시작: 위쪽 방향(0), 나무 0개 벰, 조작 0
        visited[startx][starty][0][0] = true;

        while (!q.isEmpty()) {
            State cur = q.poll();

            // 도착 지점 도달
            if (cur.x == endx && cur.y == endy) {
                return cur.cost;
            }

            // 1. 전진
            int nx = cur.x + dx[cur.dir];
            int ny = cur.y + dy[cur.dir];

            if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                char next = map[nx][ny];

                // 이동 가능
                if ((next == 'G' || next == '.') && !visited[nx][ny][cur.dir][cur.cut]) {
                    visited[nx][ny][cur.dir][cur.cut] = true;
                    q.add(new State(nx, ny, cur.dir, cur.cut, cur.cost + 1));
                }

                // 나무 베기
                if (next == 'T' && cur.cut < k && !visited[nx][ny][cur.dir][cur.cut + 1]) {
                    visited[nx][ny][cur.dir][cur.cut + 1] = true;
                    q.add(new State(nx, ny, cur.dir, cur.cut + 1, cur.cost + 1));
                }
            }

            // 2. 좌회전
            int left = (cur.dir + 3) % 4;
            if (!visited[cur.x][cur.y][left][cur.cut]) {
                visited[cur.x][cur.y][left][cur.cut] = true;
                q.add(new State(cur.x, cur.y, left, cur.cut, cur.cost + 1));
            }

            // 3. 우회전
            int right = (cur.dir + 1) % 4;
            if (!visited[cur.x][cur.y][right][cur.cut]) {
                visited[cur.x][cur.y][right][cur.cut] = true;
                q.add(new State(cur.x, cur.y, right, cur.cut, cur.cost + 1));
            }
        }

        return -1; // 도달 불가
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            map = new char[n][n];
            visited = new boolean[n][n][4][k + 1];

            for (int i = 0; i < n; i++) {
                String row = br.readLine();
                for (int j = 0; j < n; j++) {
                    map[i][j] = row.charAt(j);

                    if (map[i][j] == 'X') {
                        startx = i;
                        starty = j;
                        map[i][j] = '.';
                    } else if (map[i][j] == 'Y') {
                        endx = i;
                        endy = j;
                        map[i][j] = '.';
                    }
                }
            }

            int result = bfs();
            System.out.println("#" + t + " " + result);
        }
    }
}