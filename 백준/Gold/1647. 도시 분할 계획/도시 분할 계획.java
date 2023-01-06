
import java.io.*;
import java.util.*;

public class Main {
	
	static class Edge{
		public int a, b, dis;
		public Edge(int a, int b, int dis){
			this.a = a;
			this.b = b;
			this.dis = dis;
		}
	}
	
	static int N, M;
	static int[] graph;
	static Edge[] edge;
	
	static int find(int n) {
		if(graph[n] == n) return n;
		return graph[n] = find(graph[n]);
	}
	
	static void union(int a, int b) {
		graph[find(a)] = find(b);
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		graph = new int[N+1];
		for(int i=0; i<=N; i++) {
			graph[i] = i;
		}
		edge = new Edge[M];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			edge[i] = new Edge(a,b,c);
		}
		
		
		Arrays.sort(edge, (e1, e2) -> e1.dis - e2.dis);
		int answer = 0;
		int lastCityDis = 0;
		for(int i=0; i<M; i++) {
			Edge now = edge[i];
			if(find(now.a) != find(now.b)) {
				union(now.a, now.b);
				answer+=now.dis;
				lastCityDis = now.dis;
			}
		}
		System.out.println(answer - lastCityDis);
	}
}
