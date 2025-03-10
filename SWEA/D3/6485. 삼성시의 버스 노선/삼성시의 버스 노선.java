import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws  IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T=Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			int n=Integer.parseInt(br.readLine()); //버스 노선 개수 
			int[] stopPoint=new int[5001]; // 노선 정보 저장 
			for(int i=0; i<n; i++) {
				st=new StringTokenizer(br.readLine());
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				for(int j=a; j<=b; j++) {
					stopPoint[j]++; //헤당 정류장 범위에 속하는 정류자의 노선 수를 ++ 해주기 
				}
			}
			int p=Integer.parseInt(br.readLine()); //정류장의 개수 
			int[] busstop=new int[p]; //버스 정류장들 
			for(int i=0; i<p; i++) {
				int num=Integer.parseInt(br.readLine());
				busstop[i]=stopPoint[num];
			}
			
			System.out.print("#"+t+" ");
			for(int i=0; i<p; i++) {
				System.out.print(busstop[i]+" ");
			} 
			System.out.println();
			
		}

	}

}