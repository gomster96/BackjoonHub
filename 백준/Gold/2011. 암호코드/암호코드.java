import java.io.*;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {

    static int[] dp = new int[5001];
    static int divider = 1000000;
    public static int getDp(int n){
        if(n < 0) return 0;
        if(n == 0) return 1;
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(dp[n] != 0) return dp[n];

        return dp[n] = (getDp(n-1) + getDp(n-2)) % divider;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = br.readLine();

        long answer = 1;
        int preNum = 0;
        int n = 0;
        if(Objects.isNull(line)){
            System.out.println(0);
            return;
        }
        for(int i=0; i<line.length(); i++){
            int num = line.charAt(i) - '0';

            if(num == 0){
                if(preNum == 0 || preNum >= 3){
                    System.out.println(0);
                    return;
                }
                if(preNum < 3){
                    answer = (answer * getDp(n-1)) % divider;
                    n = preNum = 0;
                    continue;
                }
            }


            if(num > 6){
                if(preNum == 1){
                  n++;
                  answer = (answer * getDp(n)) % divider;
                } else if(preNum > 1){
                    answer = (answer * getDp(n)) % divider;
                }
                n = 0;
            } else if(num > 2){
                n++;
                answer = (answer * getDp(n)) % divider;
                n = 0;
            } else if(num == 1 || num == 2){
                n++;
            }

            preNum = num;
        }

        if(n != 0){
            answer = (answer * getDp(n)) % divider;
        }

        System.out.println(answer);

        bw.flush();
        bw.close();
        br.close();
    }
}