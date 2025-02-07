

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        char[] input=sc.nextLine().toCharArray();
        String result="";

        int cntP=0;
        boolean check=true;
        for(int i=0; i<input.length; i++){
            if(input[i]=='P'){
                cntP++;
            }else if(cntP>=2&&input[i]=='A'){
                if(i<input.length-1&&input[i+1]=='P'){
                    cntP--;
                    i++;
                }else{
                    System.out.println("NP");
                    return;
                }
            }else{
                System.out.println("NP");
                return;
            }
        }

        if(cntP==1 &&check){
            result="PPAP";
        }else{
            result="NP";
        }

        System.out.println(result);
    }
}
