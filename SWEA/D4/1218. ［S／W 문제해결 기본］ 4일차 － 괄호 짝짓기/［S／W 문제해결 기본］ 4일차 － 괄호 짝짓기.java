
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        for(int t=1; t<=10; t++){
            int n=sc.nextInt();
            sc.nextLine();
            String line=sc.nextLine();
            int result=1;

            Deque<Character> deque=new ArrayDeque<>();

            for(char c:line.toCharArray()){
                //여는 괄호부터 스택에 넣어주기
                if (c == '(' || c == '{' || c == '[' || c == '<') {
                    deque.push(c);
                }else{ //닫는 괄호일때 하나씩 빼면서 비교하기
                    if(deque.isEmpty()){ //닫는 괄호가 나왔는데 스택이 비어잇을 경우
                        result=0;
                        break;
                    }
                    char top=deque.pop();
                    if((c==')'&&top!='(')|| (c=='>'&&top!='<')|| (c=='}'&&top!='{'||(c==']'&&top!='['))){
                        result=0;
                        break;
                    }
                    
                }
            }
            if(!deque.isEmpty()){
                result=0;
            }
            System.out.println("#"+t+" "+result);
        }
    }

}
