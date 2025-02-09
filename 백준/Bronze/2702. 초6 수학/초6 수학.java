
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int T=sc.nextInt();
        sc.nextLine();

        for(int t=0; t<T; t++){
            int max=0;
            int min=0;

            int a=sc.nextInt();
            int b=sc.nextInt();

            int A=Math.max(a,b);
            int B=Math.min(a,b);

            ArrayList<Integer> arrA=new ArrayList<>();
            ArrayList<Integer> arrB=new ArrayList<>();

            //약수 구하기
            for(int i=1; i<=A; i++){
                if(A%i==0){
                    arrA.add(i);
                }
            }
            for(int i=1; i<=B; i++){
                if(B%i==0){
                    arrB.add(i);
                }
            }

            int index=1;
            ArrayList<Integer> multiA=new ArrayList<>();
            ArrayList<Integer> multiB=new ArrayList<>();

            //최소공배수
            while (true){
                multiA.add(A*index);
                multiB.add(B*index);
                if(multiA.contains(multiB.get(index-1))){
                    min=multiB.get(index-1);
                    break;
                }
                index++;
            }

            //최대공약수
            for(int i=arrA.size()-1; i>=0; i--){
                if(arrB.contains(arrA.get(i))){
                    max=arrA.get(i);
                    break;
                }
            }

            System.out.println(min+" "+max);
        }
    }
}
