
import java.io.*;
import java.util.*;
public class Main {
    static int size, h;
    static ArrayList<Integer>[] tree;
    static int[] node;

    static void solve(int start, int end, int depth){
        if(start > end) return;
        // 중위 순회이기 떄문에 분할정복을 통해 가운데를 계속 탐색
        int mid = (start + end) /2;

        tree[depth].add(node[mid]);

        solve(start, mid-1, depth+1);
        solve(mid+1, end, depth+1);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder("");

        int K = Integer.parseInt(br.readLine());
        size = (int)Math.pow(2,K) -1;

        node = new int[size];


        st = new StringTokenizer(br.readLine());
        for(int i=0; i<size; i++){
            node[i] = Integer.parseInt(st.nextToken());
        }
        h = (int)Math.ceil(Math.log(size)/ Math.log(2)) +1;
        tree = new ArrayList[h+1];
        for(int i=0; i<=h; i++){
            tree[i] = new ArrayList<>();
        }

        solve(0, size-1, 1);
        for(int i=1; i<=h; i++){
            for(int el: tree[i]){
                sb.append(el + " ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());


        bw.flush();
        bw.close();
    }
}
