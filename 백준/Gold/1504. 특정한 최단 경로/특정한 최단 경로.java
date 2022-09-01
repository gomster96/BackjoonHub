import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Node{
        int v, dis;

        public Node(int v, int dis) {
            this.v = v;
            this.dis = dis;
        }
    }

    static int[] distance;
    static int INF = 200000000;
    static  ArrayList<ArrayList<Node>> graph;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();

        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));

        }



        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        distance = new int[N+1];

        // 1 -> v1 -> v2 -> N
        int res1 = 0;
        res1 += dijkstra(1, v1);
        res1 += dijkstra(v1, v2);
        res1 += dijkstra(v2, N);



        // 1 -> v2 -> v1 -> N
        int res2 = 0;
        res2 += dijkstra(1, v2);
        res2 += dijkstra(v2, v1);
        res2 += dijkstra(v1, N);
        int answer = (res1 >= INF && res2 >= INF)? -1 : Math.min(res1, res2);
        System.out.println(answer);
    }


    public static int dijkstra(int start, int end){
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> {
            return n1.dis - n2.dis;
        });

        Arrays.fill(distance, INF);

        distance[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(distance[cur.v] < cur.dis) continue;

            for(Node node : graph.get(cur.v)){

                if(distance[cur.v] + node.dis < distance[node.v] ){

                    distance[node.v] = distance[cur.v] + node.dis;
                    pq.add(new Node(node.v, distance[cur.v] + node.dis));
                }
            }

        }

        return distance[end];
    }
}