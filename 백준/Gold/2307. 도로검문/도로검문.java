
import java.io.FileInputStream;
import java.io.*;
import java.util.*;

public class Main {
	
	static class Node{
		public int v, dis;

		public Node(int v, int dis) {
			super();
			this.v = v;
			this.dis = dis;
		}
		
	}
	
	
	static ArrayList<Node>[] graph;
	static int[] distance; 
	static int[] path;
	static int N, M;
	
	static int shortPath() {
		Arrays.fill(distance, Integer.MAX_VALUE);
		PriorityQueue<Node> pq = new PriorityQueue<>((e1,e2)->{return e1.dis - e2.dis;});
		distance[1] = 0;
		pq.add(new Node(1,0));
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			if(distance[now.v] < now.dis ) continue;
			
			for(Node next : graph[now.v]) {
				
				if(distance[next.v] > distance[now.v] + next.dis) {
					distance[next.v] = distance[now.v] + next.dis;
					pq.add(new Node(next.v, distance[next.v]));
					path[next.v] = now.v;
				}
			}
		}
		return distance[N];
	}
	
	static int otherPath(int from, int to) {
		PriorityQueue<Node> pq = new PriorityQueue<>((e1,e2)->{return e1.dis - e2.dis;});
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[1] = 0;
		pq.add(new Node(1,0));
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			if(distance[now.v] < now.dis ) continue;
			
			for(Node next : graph[now.v]) {
				if(now.v == from && next.v == to) continue;
				
				if(distance[next.v] > distance[now.v] + next.dis) {
					distance[next.v] = distance[now.v] + next.dis;
					pq.add(new Node(next.v, distance[next.v]));
				}
			}
		}
		return distance[N];
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		distance = new int[N+1];
		// 최단 경로의 path구하기 
		path = new int[N+1];
		
		for(int i=0; i<=N; i++) {
			graph[i] = new ArrayList<Node>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			graph[a].add(new Node(  b, t));
			graph[b].add(new Node(  a, t));
		}
		
		
		int shortestPath = shortPath();
		int maxPath = 0;
		
		// 스킬 
		// https://katastrophe.tistory.com/76 참
		// path 대로 순차적으로 이동할 수 있도록 하는 for
		for(int i=N; i>0; i=path[i])
			maxPath = Math.max(maxPath, otherPath(path[i], i));
		
		
		
		if(maxPath == Integer.MAX_VALUE) bw.write("-1\n");
		else bw.write(Integer.toString(maxPath - shortestPath) + "\n");
		
		bw.flush();
		bw.close();
	}
}
