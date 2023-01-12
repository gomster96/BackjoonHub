
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] notPrime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String P = st.nextToken();
        int K = Integer.parseInt(st.nextToken());
        notPrime = new boolean[K+1];
        for(int i=2; i<K; i++){
            if(!notPrime[i]){
                // 만약에 2~10까지 구할때 최대 구할 수 있는 수는 10, 2 4 6 8 10 없애기
                for(int j=i+i; j<K; j+=i){
                    notPrime[j] = true;
                }
            }
        }
        for(int i=2; i<K; i++){
            if(!notPrime[i]){
                int div = 0, temp = 1;
                for(int j=P.length()-1; j>=0; j-- ){
                    div = (div + (P.charAt(j)-'0') * temp) % i;

                    temp *= 10;
                    temp %= i;
                }
                if(div == 0){
                    System.out.println("BAD " + i);
                    System.exit(0);
                }
            }
        }
        System.out.println("GOOD");
    }
}
