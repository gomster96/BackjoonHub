
import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Lec{
        int p, d;

        public Lec(int p, int d) {
            this.p = p;
            this.d = d;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder("");

        PriorityQueue<Lec> pq = new PriorityQueue<>((l1, l2) -> {
            if(l1.d == l2.d) return l2.p - l1.p;
            return l1.d - l2.d;
        });

        PriorityQueue<Integer> minQ = new PriorityQueue<>((i1, i2) -> i1 - i2);

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            pq.add(new Lec(p,d));
        }

        int ret = 0;
        int day = 0;
        while(!pq.isEmpty()){
            Lec cur = pq.poll();
            if(cur.d > day) {
                day++;
                ret += cur.p;
                minQ.add(cur.p);
            } else if(!minQ.isEmpty() && minQ.peek() < cur.p){
                Integer min = minQ.poll();
                minQ.add(cur.p);
                ret -= min;
                ret += cur.p;
            }
        }

        bw.write(ret+"\n");

        bw.flush();
        bw.close();
        br.close();
    }
}