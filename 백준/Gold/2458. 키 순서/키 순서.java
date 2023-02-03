import java.util.*;
import java.io.*;

// 키 순서를 안다 ->그래프가 다른 정점들로 모두 이동할 수 있음을 의미한다. -> 플로이드 와샬을 이용하여 모든 정점으로 이동이 가능한지 찾는다. 

// 플로이드와샬 알고리즘을 사용해서 해당 정점에서 다른 정점으로 갈 수 있는수가 n-1이면 순서를 안다 식으로 문제를 해결해도 된다. 

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 문제에서 주어진 대로 이동할 수 있는지 파
		int[][] arr = new int[N+1][N+1];
		// 문제에서 주어진 것과 반대로 이동할 수 있는지 파
		
		final int INF = 99999999;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				arr[i][j] = INF;
			}
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1;
		}
		
		// 플로이드 와샬 알고리즘 수행
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(arr[i][j] > arr[i][k] + arr[k][j]) {
						arr[i][j] = arr[i][k] + arr[k][j];
					}
				}
			}
		}
		
		int ans = 0;
		for(int i=1; i<=N; i++) {
			int cnt = 0;
			for(int j=1; j<=N; j++) {
				if(arr[i][j] != INF || arr[j][i] != INF) cnt++;
			}
			if(cnt == N-1) ans++;
		}
		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
		br.close();
	}
}
