
import javax.swing.text.html.StyleSheet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        long maxK = 1000000000;
        long[][] C = new long[N+M+1][N+M+1];
        for(int i=0; i<=N+M; i++){
            C[i][0] = 1;
            C[i][i] = 1;
        }
        for(int i=1; i<=N+M; i++){
            for(int j=1; j<i; j++){
                long nextC =  C[i-1][j] + C[i-1][j-1];
                C[i][j] = Math.min(nextC, maxK);
            }
        }
        int length = N + M;
        StringBuilder sb = new StringBuilder("");
        if(C[N+M][M] < K){
            System.out.println(-1);
        }
        else {
            while(sb.length() < length){
                // 사용한 N 또는 M 값 줄여줘야함
                // a로 시작할 때
                if(C[N+M-1][M] >= K){
                    sb.append("a");
                    N--;
                    // 맨 마지막엔...?
                }
                // z로 시작할때
                else {
                    sb.append("z");
                    K = K - C[N+M-1][M];
                    M--;
                }
            }
            System.out.println(sb.toString());
        }

    }
}
