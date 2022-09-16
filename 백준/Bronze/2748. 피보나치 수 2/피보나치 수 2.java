
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static long[] dp;
    public static long Fibo(int n){
        if(dp[n] != -1) return dp[n];
        return dp[n] = Fibo(n-1) + Fibo(n-2);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        dp = new long[N+1];
        for(int i=0; i<dp.length; i++){
            dp[i] = -1;
        }
        dp[0] = 0;
        dp[1] = 1;
        Fibo(N);
        System.out.println(dp[N]);
    }
}
