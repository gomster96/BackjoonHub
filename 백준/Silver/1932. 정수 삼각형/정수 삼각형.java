
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] a = new int[N+1][N+1];
        StringTokenizer st = null;
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=i; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=2; i<=N; i++){
            for(int j=1; j<=i; j++){
                a[i][j] = Math.max(a[i-1][j-1], a[i-1][j]) + a[i][j];
            }
        }
        int answer = 0;
        for(int i=1; i<=N; i++){
            answer = Math.max(a[N][i],answer);
        }
        System.out.println(answer);
    }
}
