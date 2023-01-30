import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    static int N;
    static int[] arr;
    static int[][] dp;
    public static int sol(int cnt, int n){
        if(cnt < 0) return 0;
        if(n > N) return 0;
        if(dp[cnt][n] != -1) return dp[cnt][n];
        // 먹고가기
        if(cnt != 0) dp[cnt][n] = arr[n] + sol(cnt-1, n+1);
        // 안먹고 점프
        dp[cnt][n] = Math.max(dp[cnt][n], sol(2, n+1 ));

        return dp[cnt][n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        dp = new int[3][N+1];
        for(int i=0; i<3; i++){
            for(int j=0; j<=N; j++){
                dp[i][j] = -1;
            }
        }
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(sol(2, 1));
    }
}
