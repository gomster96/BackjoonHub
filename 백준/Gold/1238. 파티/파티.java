import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static class Node{
        public int next, time;

        public Node(int next, int time) {
            this.next = next;
            this.time = time;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N+1][N+1];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            graph[start][end] = t;
        }

        // X에서 다른 모든 정점으로 가는 최소 길이를 찾으면 된다.!
        // 다른 정점에서 X로 가는 최소걸이는? -> 플로이드와샬이 맞는거같은디

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                for(int k=1; k<=N; k++){

                    if(j!=k && graph[j][i] != 0 && graph[i][k] != 0){
                        if(graph[j][k] == 0 || graph[j][k] > graph[j][i] + graph[i][k]){
                            graph[j][k] = graph[j][i] + graph[i][k];
                        }
                    }
                }
            }
        }
        int answer = Integer.MIN_VALUE;
        for(int i=1; i<=N; i++){
            if(i==X) continue;
            if(answer < graph[i][X] + graph[X][i]){
                answer = graph[i][X] + graph[X][i];
            }
        }
        System.out.println(answer);
        bw.flush();
        bw.close();
    }
}