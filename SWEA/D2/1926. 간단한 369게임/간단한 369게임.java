import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		
		for(int i=1; i<=n; i++) {
			String num=String.valueOf(i);
			if(num.contains("3")||num.contains("6")||num.contains("9")) {
				char[] arr=num.toCharArray();
				for(int j=0; j<arr.length;j++) {
					if(arr[j]=='3'||arr[j]=='6'||arr[j]=='9') {
						sb.append("-");
					}
				}
				sb.append(" ");
			}else {
				sb.append(i).append(" ");
			}
		}
		System.out.println(sb);
	}
}