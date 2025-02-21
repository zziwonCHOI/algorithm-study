import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		
		int T=Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			String[]  line=br.readLine().split(" ");
			
			int n=Integer.parseInt(line[0]);
			int totalSum=0;
			double avg=0.0;
			int targetCnt=0;
			double result=0.0;
			
			for(int i=1; i<=n;i++) {
				totalSum+=Integer.parseInt(line[i]);
			}
			
			avg=(double)totalSum/n;
			
			for(int i=1; i<=n; i++) {
				if(Integer.parseInt(line[i])>avg){
					targetCnt++;
				}
			}
			
			result=((double)targetCnt/n)*100.0;
	
			System.out.printf("%.3f%%\n", result);
		}
	}

}