
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder("");

        int distance, town;
        st = new StringTokenizer(br.readLine());

        distance = Integer.parseInt(st.nextToken());
        town = Integer.parseInt(st.nextToken());
        int[] dp = new int[distance+1];
        dp[0] = Integer.MAX_VALUE;

        for(int i=0; i<town; i++){
            int length, capacity;

            StringTokenizer pipe = new StringTokenizer(br.readLine());

            length = Integer.parseInt(pipe.nextToken());
            capacity = Integer.parseInt(pipe.nextToken());

            for(int y=distance; y>=length; y--){
                dp[y] = Math.max(dp[y], Math.min(capacity, dp[y-length]));
            }
        }
        System.out.println(dp[distance]);
        bw.flush();
        bw.close();
    }
}