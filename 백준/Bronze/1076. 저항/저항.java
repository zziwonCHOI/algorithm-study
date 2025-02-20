import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        String[] color={"black","brown","red","orange","yellow","green","blue","violet","grey","white"};
        int[] value={0,1,2,3,4,5,6,7,8,9};
        int[] mul={1,10,100,1000,10000,100000,1000000,10000000,100000000,1000000000};

        String color1=br.readLine();
        String color2=br.readLine();
        String color3=br.readLine();

        int value1=0;
        int value2=0;
        long value3=0;

        for(int i=0; i<10; i++){
            if(color[i].equals(color1)){
                value1=value[i];
            }
            if(color[i].equals(color2)){
                value2=value[i];
            }
            if(color[i].equals(color3)){
                value3=mul[i];
            }
        }

        String values=String.valueOf(value1)+String.valueOf(value2);
        long v=(long)Integer.parseInt(values);
        long result=v*value3;

        System.out.println(result);
    }
}