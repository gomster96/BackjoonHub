import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Pair{
    int x, y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Pair> pq = new PriorityQueue<>((e1, e2)-> {
            if(e1.y == e2.y) return e1.x - e2.x;
            return e1.y - e2.y;
        });

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pq.add(new Pair(x,y));
        }
        int lastTime = 0;
        int cnt = 0;
        while(!pq.isEmpty()){
            Pair top = pq.poll();
            if(lastTime > top.x) continue;
            lastTime = top.y;
            cnt++;

        }
        System.out.println(cnt);
    }
}
