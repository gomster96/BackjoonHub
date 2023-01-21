
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer> arr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr.add(Integer.parseInt(st.nextToken()));
        }
        int lt = 0, rt = 0;
        int sum = arr.get(lt);
        int answer = 0;
        while(!(rt == N-1 && sum < M)){
           if(sum < M) sum += arr.get(++rt);
           else {
               if(sum == M) answer++;
               sum -= arr.get(lt++);
           }
        }
        System.out.println(answer);
    }
}
