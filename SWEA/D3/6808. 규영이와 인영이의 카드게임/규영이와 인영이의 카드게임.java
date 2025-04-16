import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[] guCards;
    static int[] inCards;
    static int winCnt;
    static int loseCnt;
    static boolean[] isSelected;
    static int[] cards;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            guCards = new int[9];
            boolean[] isChecked = new boolean[19];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 9; i++) {
                guCards[i] = Integer.parseInt(st.nextToken());
                isChecked[guCards[i]] = true;
            }

            int cnt = 0;
            inCards = new int[9];
            for (int i = 1; i <= 18; i++) {
                if (!isChecked[i]) {
                    inCards[cnt++] = i;
                }
            }

            winCnt = 0;
            loseCnt = 0;
            isSelected = new boolean[9];
            cards = new int[9];

            gamePerm(0);
            System.out.println("#" + t + " " + winCnt + " " + loseCnt);
        }
    }

    public static void gamePerm(int idx) {
        if (idx == 9) {
            int guSum = 0;
            int inSum = 0;
            for (int i = 0; i < 9; i++) {
                if (guCards[i] > cards[i]) {
                    guSum += guCards[i] + cards[i];
                } else if (guCards[i] < cards[i]) {
                    inSum += guCards[i] + cards[i];
                }
            }

            if (guSum < inSum) {
                loseCnt++;
            } else if (guSum > inSum) {
                winCnt++;
            }
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (isSelected[i]) continue;
            cards[idx] = inCards[i];
            isSelected[i] = true;
            gamePerm(idx + 1);
            isSelected[i] = false;
        }
    }
}