import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[] in;
	static int[] gu;
	static int winCnt;
	static int loseCnt;
	static boolean[] isSelected;
	static int[] cards; //인영이가 내는 카드의 순서를 저장 
	
	public static void main(String[] args) throws  IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T=Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			in=new int[9];
			gu=new int[9];
			boolean[] isGyu=new boolean[19]; //1~18의 카드 중 규영이가 가진 카드 여부 체크 
			st=new StringTokenizer(br.readLine());
			
			//규영이 카드 저장 
			for(int i=0; i<9;i++) {
				gu[i]=Integer.parseInt(st.nextToken());
				isGyu[gu[i]]=true;
			}
			//인영이가 가질 수 있는 카드 추출(1~18중에서 규여잉 카드 제외)
			int idx=0;
			for(int i=1; i<=18; i++) {
				if(!isGyu[i]) {
					in[idx++]=i;
				}
			}
			
			winCnt=0;
			loseCnt=0;
			isSelected=new boolean[9];
			cards=new int[9];
			permute(0); //인영이의 카드 순열을 만들고, 게임을 진횅하면서 승패 계산 
			
			
			System.out.println("#"+t+" "+winCnt+" "+loseCnt);
		}
	}

	public static void permute(int start) {
		
		if(start==9) {
			int gyuScore=0;
			int inScore=0; //규영이와 인영이 점수 초기화 
			
			//9라운드 동안 게임 진행 
			for(int i=0; i<9; i++) {
				int gCard=gu[i]; //규영이의 i 번째 카드
				int inCard=cards[i];// 인영이의 i번째 카드
				//더 높은 숫자를 낸 사람이 두 카드의 합만큼 점수를 얻는다. 
				if(gCard>inCard) {
					gyuScore+=gCard+inCard; //규영이 승리 시 점수 증가
				}else if(gCard<inCard) {
					inScore+=gCard+inCard;//인영이 승리 시 점수 증가 
				}
				
				
			}
			
			if(gyuScore>inScore) {
				winCnt++;
			}else if(gyuScore<inScore) {
				loseCnt++;
			}
			
			return;
		}
		
		for(int i=0; i<9; i++) {
			if(!isSelected[i]) {
				cards[start]=in[i];
				isSelected[i]=true;
				permute(start+1);
				isSelected[i]=false;
			}
		}
	}
}