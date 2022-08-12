import java.util.Scanner;

public class Main {
    static int[] dp;
    // 그리디 알고리즘을 적용한 잘못된 풀이방법
//    public static int sol(int n){
//        if(n <= 0) return 0;
//        if(dp[n] != 0) return dp[n];
//        double sqrtN = Math.sqrt(n);
//        if(sqrtN == (int) sqrtN) return dp[n]=1;
//        int k = (int)Math.pow(Math.floor(sqrtN),2);
//        System.out.println("제곱하기전 : " + sqrtN);
//        return dp[n] = 1 + sol(n-k);
//    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        dp = new int[N+1];
        dp[1] = 1;
        int min = 0;
        for(int i=2; i<=N; i++){
            min = Integer.MAX_VALUE;
            // dp[i - j*j] 중 최소를 선택해야함
            for(int j=1; j*j <= i; j++){
                int temp = i - j * j;
                // 사실상 이전에 있는 모든 수들을 파악하여 최솟값을 찾기
                min = Math.min(min, dp[temp]);
            }
            dp[i] = min + 1;
        }
        System.out.println(dp[N]);
    }
}
// 참고 : https://steady-coding.tistory.com/18