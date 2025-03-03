import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        for(int t=1; t<=10; t++){
            int n=Integer.parseInt(br.readLine());
            char[] line=br.readLine().toCharArray();
            Stack<Character> stack=new Stack<>();
            boolean check=true;

            for(int i=0; i<n; i++){
                char cur=line[i];
                if(cur=='{'||cur=='('||cur=='['||cur=='<'){
                    stack.push(cur);
                }else{
                    if(cur=='}') {
                        if(stack.pop()!='{') {
                            check=false;
                            break;
                        }

                    }if(cur==')'){
                        if(stack.pop()!='(') {
                            check=false;
                            break;
                        }
                    }if(cur==']'){
                        if(stack.pop()!='[') {
                            check=false;
                            break;
                        }
                    }if(cur=='>'){
                        if(stack.pop()!='<') {
                            check=false;
                            break;
                        }
                    }


                }

            }
            System.out.println("#"+t+" "+(check?1:0));
        }
    }
}