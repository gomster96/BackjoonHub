import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String num = br.readLine();
        StringBuilder answer = new StringBuilder("");

        int nextIdx = 0;
        int maxVal = -1;
        int maxIdx = 0;
        while(K < num.length() - nextIdx){
            for(int i= nextIdx; i<=nextIdx+K; i++){

                if(num.charAt(i)- '0' > maxVal){
                    maxVal = num.charAt(i) - '0';
                    maxIdx = i;
                }
                if(maxVal == 9) break;
            }
            answer.append(maxVal);
            K = K - (maxIdx - nextIdx);
            nextIdx = maxIdx + 1;
            maxVal = -1;
            maxIdx = 0;

            if(K == 0){
                for(int i= nextIdx; i<num.length(); i++){
                    answer.append(num.charAt(i));
                }
                break;
            }
        }

        System.out.println(answer);
    }
}
