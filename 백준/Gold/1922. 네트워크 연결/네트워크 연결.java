
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[] chArr;
    static class Com{
        int a, b, c;
        public Com(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    static int find(int n){
        if(chArr[n] == n) return n;
        return chArr[n] = find(chArr[n]);
    }

    static void union(int a, int b){
        chArr[find(a)] = chArr[find(b)];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        chArr = new int[N+1];
        for(int i=1; i<=N; i++){
            chArr[i] = i;
        }
        ArrayList<Com> comList = new ArrayList<>();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            comList.add(new Com(a,b,c));
        }
        comList.sort((c1, c2) -> c1.c - c2.c);
        int answer = 0;
        for(int i=0; i<comList.size(); i++){
            Com com = comList.get(i);
            if(find(com.a) != find(com.b)){
                union(com.a, com.b);
                answer += com.c;
            }
        }
        System.out.println(answer);
    }
}
