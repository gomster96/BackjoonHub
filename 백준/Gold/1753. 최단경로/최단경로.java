
import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

///////
///////
///////
/////// 강사님 풀이
/////// 중요하니 잘 익히기기
public class Main {
    static class Pair{
        int node, dis;

        public Pair(int node, int distance) {
            this.node = node;
            this.dis = distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        ArrayList<Pair>[] graph = new ArrayList[V+1];
        int[] distance = new int[V+1];
        for(int i=0; i<V+1; i++){
            graph[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Pair(v,w));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((e1, e2) -> e1.dis - e2.dis);
        distance[start] = 0;
        // 도착점 & 가는데까지의 거리 저장
        pq.add(new Pair(start, 0));
        while(!pq.isEmpty()){
            Pair now = pq.poll();

            if(distance[now.node] < now.dis) continue;
            for(Pair next : graph[now.node]){
                if(distance[next.node] > distance[now.node] + next.dis){
                    distance[next.node] = distance[now.node] + next.dis;
                    pq.add(new Pair(next.node, distance[next.node]));
                }
            }
        }
        for(int i=1; i<=V; i++){
            if(distance[i] == Integer.MAX_VALUE) bw.write("INF\n");
            else bw.write(distance[i]+"\n");
        }
        bw.flush();
        bw.close();
    }
}
