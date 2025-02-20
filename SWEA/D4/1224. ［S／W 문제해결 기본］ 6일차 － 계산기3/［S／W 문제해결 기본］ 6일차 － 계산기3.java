import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int t = 1; t <= 10; t++) {
            int n = sc.nextInt();
            sc.nextLine();

            Stack<Character> operator = new Stack<>();
            StringBuilder postfix = new StringBuilder();
            char[] line = sc.nextLine().toCharArray();

            for (int i = 0; i < n; i++) {
                char ch = line[i];

                if (ch == '(') {
                    operator.push('(');
                } else if (Character.isDigit(ch)) {
                    postfix.append(ch);
                } else if (ch == ')') {
                    while (!operator.isEmpty() && operator.peek() != '(') {
                        postfix.append(operator.pop());
                    }
                    operator.pop();
                } else {
                    while (!operator.isEmpty() && operator.peek() != '(' && check(operator.peek()) >= check(ch)) {
                        postfix.append(operator.pop());
                    }
                    operator.push(ch);
                }
            }

            while (!operator.isEmpty()) {
                postfix.append(operator.pop());
            }

            Stack<Integer> calculator = new Stack<>();
            for (int i = 0; i < postfix.length(); i++) {
                char c = postfix.charAt(i);
                if (Character.isDigit(c)) {
                    calculator.push(c - '0');
                } else {
                    int b = calculator.pop();
                    int a = calculator.pop();
                    if (c == '+') {
                        calculator.push(a + b);
                    } else if (c == '*') {
                        calculator.push(a * b);
                    }
                }
            }

            System.out.println("#" + t + " " + calculator.pop());
        }

        sc.close();
    }

    public static int check(char c) {
        if (c == '(') {
            return 0;
        } else if (c == '+') {
            return 1;
        } else if (c == '*') {
            return 2;
        }
        return -1;
    }
}