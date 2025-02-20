import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	//궁수를 배정하는 것은 조합으로 구현
	//적을 공격하는 함수는 브루트포스를 활용하여 구현 
	//1. 조합을 이용하여 궁수의 x좌표를 뽑아낸다.
	//2. 각 궁수에 대해 전체 맵에서 적이 존재하는 좌표를 구한 뒤, 거리를 구한다. 
	//3. 2번 과정에서 최단거리, 최단거리가 가리키는 x,y 좌표를 구한다.
	//4. 3번 과정에서 구한 x,y 좌표를 visited[x][y]=true 처리
	//5. visited에서 true인 부분만 개수를 센다.
	//6. i번째 배열을 i-1번째 배열로 초기화한다.
	//7. 1~6번 과정을 n번 반복하고 종료한다. 

	
	static int[][] map;
	static int[][] copyMap;
	static int n,m,d;
	static int ans;
	public static void main(String[] args) {
		Scanner  sc=new Scanner(System.in);
		
		n=sc.nextInt(); //행의 수
		m=sc.nextInt(); //열의 수
		d=sc.nextInt(); //궁수의 공격 거리 제한 
		
		map=new int[n+1][m+1];
		copyMap=new int[n+1][m+1];
		
		for(int i=1; i<=n;i++) {
			for(int j=1; j<=m; j++) {
				map[i][j]=sc.nextInt();
				copyMap[i][j]=map[i][j];
			}
		}
		
		ArrayList<Integer> archer= new ArrayList<>();
		ans=0;
		comb(1,m,3, archer); //궁수 조합 만들기 
		
		System.out.println(ans);
	}
	
	//맵을 원래 상태로 되돌린다. 
	public static void init() {
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				map[i][j]=copyMap[i][j];
			}
		}
	}
	public static void comb(int start, int n, int r, ArrayList<Integer> archer ) {
		if(r==0) {
			init();
			attack(archer); //선택된 궁수들의 조합에 대해 공격 실행 
			return;
		}
		for(int i=start; i<=n; i++) {
			archer.add(i); 
			comb(i+1, n, r-1, archer); //다음 숫자 선택하기 위해 재귀호출 
			archer.remove(archer.size()-1); //선택을 취소하고 원상복구(백트래킹) 
		}
	}
	
	//거리
	public static int distance(int r1, int r2, int c1, int c2) {
		return Math.abs(r1-r2)+Math.abs(c1-c2);
	}
	
	//궁수가 적을 공격하는 함수
	public static void attack(ArrayList<Integer> archer) {
		int res=0;
		
		for(int l=1; l<=n; l++) {
			boolean[][] visited=new boolean[n+1][m+1];
			for(int k=0; k<archer.size();k++) {
				int temp=archer.get(k); //궁수가 서 있는 x 좌표 
				int minD=Integer.MAX_VALUE;//최소 거리 
				int minR=Integer.MAX_VALUE;//최소 거리의 y좌표 
				int minC=Integer.MAX_VALUE;//최소 거리의 x좌표 
				
				//맵 전체를 탐색해서 최단 거리를 찾아내는 것이 목적 
				for(int i=1; i<=n; i++ ) {
					for(int j=1; j<=m; j++) {
						if(map[i][j]==1) {//적이 있을 경우 
							if(minD>=distance(i,n+1,j,temp)) {
								//현재 구한 최소 거리보다 더 짧은 거리가 발생한 경우
								//최단 거리와 좌표들을 다시 초기화  
								if(minD>distance(i,n+1, j, temp)) {
									minD=distance(i,n+1,j,temp);
									minR=i;
									minC=j; 
								}else {
									//현재 구한 최소 거리과 지금 구한 최소 거리가 같을 경우,
									//가장 왼쪽 적부터 처리해야 하므로 x좌표가 더 작은지 검사 
									if(minC>j) {
										minR=i;
										minC=j; 
									}
								}
							}
						}
					}
				}
				
				//최단 거리를 찾아내고나서 최소 거리가 d보다 작으면 그 좌표에 visited 처리를 해 준다. 
				if(minD<=d) {
					visited[minR][minC]=true;
				}
			}
			//visited가 true인 좌표만 적을 처리한다. 
			//궁수가 같은 적을 쏠 수도 있기 때문에 바로바로 map[i][j]=0 하면 안된다. 
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=m; j++) {
					if(visited[i][j]) {
						map[i][j]=0;
						res++; 
					}
				}
			}
			
			//성 바로 위 줄을 모두 0으로 초기화 
			for(int i=1; i<=m; i++) {
				map[n][i]=0; 
			}
			
			//i번째 줄을 i-1번째 줄로 초기화 
			for(int i=n; i>=1; i--) {
				for(int j=1; j<=m; j++) {
					map[i][j]=map[i-1][j];
				}
			}
		}
		ans=Math.max(ans,res);
	}

}