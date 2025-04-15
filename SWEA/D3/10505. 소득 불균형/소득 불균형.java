
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T;t++) {
			int n=Integer.parseInt(br.readLine());
			String[] input=br.readLine().split(" ");
			long[] nums=new long[n];
			for(int i=0; i<n;i++) {
				nums[i]=(long)Integer.parseInt(input[i]);
			}
			long sum=0;
			long avg=0;
			int cnt=0;
			for(int i=0; i<n;i++) {
				sum+=nums[i];
			}
			avg=sum/n;
			
			for(int i=0; i<n;i++) {
				if(avg>=nums[i]) {
					cnt++;
				}
			}
			
			System.out.println("#"+t+" "+cnt);
		}
		
	}

}
