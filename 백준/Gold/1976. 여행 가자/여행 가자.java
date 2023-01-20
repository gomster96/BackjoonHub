

import java.io.*;
import java.util.*;

// 틀린이유 : 부모의 방향성을 줘야함. 이 문제같은 경우 각 find하는 순서가 다르므로 방향이 반대가되어 부모가 바뀌는 오류가나올 수 있기 때문이다. 

public class Main {
	static int[] arr;
	
	static int find(int n){
		if(n == arr[n]) return n;
		return arr[n] = find(arr[n]);
	}
	
	static void union(int a, int b) {
//		int fir = find(arr[a]);
//		int sec = find(arr[b]);
//		
//		
//		if(fir> sec) arr[fir] = sec;
//		else arr[sec] = fir;
		
//		arr[a] = find(arr[b]); 
		arr[find(a)] = find(b);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		arr = new int[N+1]; 
		for(int i=0; i<=N; i++) {
			arr[i] = i;
		}
		for(int i=1; i<=N; i++){
			st = new StringTokenizer(br.readLine());
			int j = 1;
			while(st.hasMoreTokens()) {
				int next = Integer.parseInt(st.nextToken());
				if(next == 1) {
					union(i,j);
				}
				j++;
			}
		}
		st = new StringTokenizer(br.readLine());
		int before = Integer.parseInt(st.nextToken());
		boolean flag = false;
		while(st.hasMoreTokens() && !flag) {
			int next = Integer.parseInt(st.nextToken());
			if(find(before) != find(next)) {
				flag = true;
			}
			before = next;
		}
		if(flag) System.out.println("NO");
		else System.out.println("YES"); 
		
		
	}
}
