import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] maxSumBoard =  new int[100001][3];
        int[][] minSumBoard =  new int[100001][3];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            // 더 좋은 방법있는지 나중에 찾아보기 // 뭔가 다 적는거 같아서 비 효율정
            int num = Integer.parseInt(st.nextToken());
            maxSumBoard[i][0] = Math.max(maxSumBoard[i-1][0],maxSumBoard[i-1][1]) + num;
            minSumBoard[i][0] = Math.min(minSumBoard[i-1][0],minSumBoard[i-1][1]) + num;
            num = Integer.parseInt(st.nextToken());
            maxSumBoard[i][1] = Math.max(maxSumBoard[i-1][0],Math.max(maxSumBoard[i-1][1], maxSumBoard[i-1][2])) + num;
            minSumBoard[i][1] = Math.min(minSumBoard[i-1][0],Math.min(minSumBoard[i-1][1], minSumBoard[i-1][2]) ) + num;
            num = Integer.parseInt(st.nextToken());
            maxSumBoard[i][2] = Math.max(maxSumBoard[i-1][1],maxSumBoard[i-1][2]) + num;
            minSumBoard[i][2] = Math.min(minSumBoard[i-1][1],minSumBoard[i-1][2]) + num;
        }
        int maxAnswer = Math.max(maxSumBoard[N][0],Math.max(maxSumBoard[N][1], maxSumBoard[N][2]));
        int minAnswer = Math.min(minSumBoard[N][0],Math.min(minSumBoard[N][1], minSumBoard[N][2]));
        System.out.println(maxAnswer + " " + minAnswer);
    }

}

