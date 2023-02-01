
import java.io.*;
import java.util.*;
public class Main {
    static int N, K;
    static long[][] dp;

    static long solve(int n, int k){
        if(dp[n][k] != 0) return dp[n][k];
        if(k==1) return 1;
        for(int i=0; i<=n; i++){
            dp[n][k] += (solve(n-i, k-1) % 1000000000) ;
        }
        return (dp[n][k]%1000000000);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new long[N+1][K+1];

        System.out.println(solve(N,K));
    }
}
