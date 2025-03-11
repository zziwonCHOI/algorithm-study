import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            char[][] arr = new char[n][n];

            // 입력 받기
            for (int i = 0; i < n; i++) {
                arr[i] = br.readLine().toCharArray();
            }

            boolean result = false;

            // 가로 검사
            for (int i = 0; i < n && !result; i++) {
                for (int j = 0; j <= n - 5 && !result; j++) {
                    boolean flag = true;
                    for (int k = 0; k < 5; k++) {
                        if (arr[i][j + k] != 'o') {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) result = true;
                }
            }

            // 세로 검사
            for (int i = 0; i <= n - 5 && !result; i++) {
                for (int j = 0; j < n && !result; j++) {
                    boolean flag = true;
                    for (int k = 0; k < 5; k++) {
                        if (arr[i + k][j] != 'o') {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) result = true;
                }
            }

            // 대각선 검사
            for (int i = 0; i <= n - 5 && !result; i++) {
                for (int j = 0; j <= n - 5 && !result; j++) {
                    boolean flag = true;
                    for (int k = 0; k < 5; k++) {
                        if (arr[i + k][j + k] != 'o') {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) result = true;
                }
            }

            // 대각선  검사
            for (int i = 0; i <= n - 5 && !result; i++) {
                for (int j = 4; j < n && !result; j++) {
                    boolean flag = true;
                    for (int k = 0; k < 5; k++) {
                        if (arr[i + k][j - k] != 'o') {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) result = true;
                }
            }

            System.out.println("#" + t + " " + (result ? "YES" : "NO"));
        }
    }
}