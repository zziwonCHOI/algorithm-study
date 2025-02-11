
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String line= sc.nextLine();
        String result="";
        for(int i=0; i<line.length(); i++){
            if(Character.isUpperCase(line.charAt(i))){
                result+=line.charAt(i);
            }
        }
        System.out.println(result);
    }
}
