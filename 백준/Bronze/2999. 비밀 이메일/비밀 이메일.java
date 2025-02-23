
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        String input=br.readLine();

        int r=0;
        int c=0;
        int n=input.length();
        for(int i=1; i*i<=n; i++){
            if((n%i)==0){
                r=i;
                c=n/i;
            }
        }
        char[][] matrix=new char[r][c];

        for(int i=0; i<c; i++){
            for(int j=0; j<r; j++){
                matrix[j][i]=input.charAt(i*r+j);
            }
        }

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                sb.append(matrix[i][j]);
            }
        }

        System.out.println(sb);
    }
}