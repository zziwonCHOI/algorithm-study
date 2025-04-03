import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		int N = 0;
		int K = 0;
		double result = 0;
		String[] s = null;
		int[] arr = null;
		for(int t=1; t<=T; t++) {
			result = 0;
			s = br.readLine().split(" ");
			N = Integer.parseInt(s[0]);
			K = Integer.parseInt(s[1]);
			s = br.readLine().split(" ");
			arr = new int[N];
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(s[i]);
			}
			Arrays.sort(arr);
			for(int i=arr.length-K; i<arr.length; i++) {
				result = (result+arr[i])/2;
			}
			bw.write("#"+t+" "+result+"\n");
		}
		br.close();
		bw.close();
	}
}