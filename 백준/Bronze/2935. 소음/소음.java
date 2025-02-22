import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        String a=br.readLine();
        String b=br.readLine();
        String c=br.readLine();


        if(b.equals("+")){
            String biglen="";
            String smallen="";
            if(a.length()>c.length()){
                sb.append('1');
                biglen=a;
                smallen=c;
                for(int i=0; i<biglen.length()-smallen.length()-1;i++){
                    sb.append('0');
                }
                sb.append(smallen);
            }else if(a.length()<c.length()){
                sb.append('1');
                biglen=c;
                smallen=a;
                for(int i=0; i<biglen.length()-smallen.length()-1;i++){
                    sb.append('0');
                }
                sb.append(smallen);
            }else{
                sb.append('2');
                for(int i=0; i<a.length()-1; i++){
                    sb.append('0');
                }
            }


        }else{
            sb.append('1');
            int cnt=0;
            for(char i:a.toCharArray()){
                if(i=='0'){
                    cnt++;
                }
            }
            for(char i:c.toCharArray()){
                if(i=='0'){
                    cnt++;
                }
            }
            for(int i=0; i<cnt;i++){
                sb.append("0");
            }
        }
        System.out.println(sb);
    }
}