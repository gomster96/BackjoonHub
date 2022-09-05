
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
// https://2youngjae.tistory.com/60
// 탐색중 방문이라는 개념이 있음 -> 중요
public class Main {

    static ArrayList<Integer>[] graph;
    static boolean isCycle;
    static int[] visited;
    static int N;
    // -1은 탐색끝, 0 미방문, 1 탐색중
    public static void DFS(int idx){
        visited[idx] = 1;
        for(int i=0; i<graph[idx].size(); i++){
            int num = graph[idx].get(i);
            if(num!=N && visited[num]==1){
                isCycle = true;
                return;
            }
            else if(visited[num] == 0){
                DFS(num);
            }
        }
        visited[idx] = -1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];
        for(int i=0; i<=N; i++){
            graph[i] = new ArrayList<Integer>();
        }
        for(int i=1; i<N; i++){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                graph[i].add(Integer.parseInt(st.nextToken()));
            }
        }
        visited = new int[N+1];
        isCycle = false;
        DFS(1);
        if(isCycle) System.out.println("CYCLE");
        else System.out.println("NO CYCLE");

        bw.flush();
        bw.close();
    }
}