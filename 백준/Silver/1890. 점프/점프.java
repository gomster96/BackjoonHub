//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Scanner;
//import java.util.StringTokenizer;
//
//public class B_1890 {
//    static int[][] board;
//    static long[][] dp;
//    static int N;
//
//    static long sol(int r, int c){
//        if(r >= N || c >= N) return 0;
//        if(dp[r][c] != -1) return dp[r][c];
//        int jump = board[r][c];
//        if(jump == 0 && r == N-1 && c == N-1) return 1;
//        if(jump == 0) return 0;
//        dp[r][c] = sol(r+jump, c) + + sol(r, c+jump);
//        return dp[r][c];
//    }
//
//    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
//        N = sc.nextInt();
//        board = new int[N][N];
//        dp = new long[N][N];
//        for(int i=0; i<N; i++){
//            for(int j=0; j<N; j++){
//                board[i][j] = sc.nextInt();
//                dp[i][j] = -1;
//            }
//        }
//
//        System.out.println(sol(0, 0));
//    }
//}


import java.util.Scanner;
// 참고 https://yeoeun-ji.tistory.com/55
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int graph[][] = new int[N+1][N+1];
        long dp[][] = new long[N+1][N+1];
        
        for(int i=1; i<=N; i++)
            for(int j=1; j<=N; j++)
                graph[i][j] = sc.nextInt();
        
        dp[1][1] = 1;
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if((i==N && j==N) && graph[i][j] == 0) break;
                else{
                    int right = j + graph[i][j];
                    int down = i + graph[i][j];
                    
                    if(right <=N) dp[i][right] += dp[i][j];
                    if(down <= N) dp[down][j] += dp[i][j];
                }
            }
        }
        System.out.println(dp[N][N]);
    }
}