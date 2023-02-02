import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static Pair[] arr;
    static class Pair{
        public int num;
        public int beforeCnt;
        public ArrayList<Integer> next = new ArrayList<>();
        public Pair(int num) {
            this.num = num;
            beforeCnt = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new Pair[N+1];
        for(int i=1; i<=N; i++){
            arr[i] = new Pair(i);
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int small = Integer.parseInt(st.nextToken());
            int tall = Integer.parseInt(st.nextToken());
            arr[small].next.add(tall);
            arr[tall].beforeCnt++;
        }
        Queue<Pair> q = new LinkedList();
        for(int i=1; i<=N; i++){
            if(arr[i].beforeCnt == 0) q.add(arr[i]);
        }
        while(!q.isEmpty()){
            Pair top = q.poll();
            System.out.print(top.num + " ");
            for(int i=0; i<top.next.size(); i++){
                Pair el = arr[top.next.get(i)];
                el.beforeCnt--;
                if(el.beforeCnt == 0) q.add(el);
            }
        }
    }
}
