
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] board = new int[N+1][M+1];
		int answer = 0;
		for(int i=1; i<=N; i++) {
//			String line = br.readLine();
			char[] line = br.readLine().toCharArray();
			for(int j=1; j<=M; j++) {
//				board[i][j] = line.charAt(j-1) - '0';
				board[i][j] = line[j-1] - '0';
				if(board[i][j] == 1) answer = 1;
			}
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				//대각위,위, left 의 합을 구함
				if(board[i][j] == 0) continue;
				int daegak = board[i-1][j-1];
				int up = board[i-1][j];
				int left = board[i][j-1];
				if(daegak > 0 && up > 0 && left > 0) {
					board[i][j] = Math.min(daegak, Math.min(up, left)) + 1;
					if(board[i][j] > answer) answer = board[i][j];
				}
			}
		}
		
		System.out.println(answer*answer);
		
	}	
}
