import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int caseNum=1;
        while(true){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int l=Integer.parseInt(st.nextToken());
            int p=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            if(p==0){
                break;
            }

            int total=0;

            total+=v/p*l;
            if(v%p<=l){
                total+=v%p;
            }else{
                total+=l;
            }

            System.out.println("Case "+caseNum+": "+total);
            caseNum++;
        }

    }
}