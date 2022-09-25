
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = 1;
        while(S < 1000000){
            S *= 2;
        }
        tree = new int[2*S];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            if(A == 1){
                // 사탕 꺼내기
                int idx = query(1, S, 1, B);
                System.out.println(idx);
                update(1, S, 1, idx, -1);
            } else {
                // 사탕 넣기
                long C = Long.parseLong(st.nextToken());
                update(1, S, 1, B, C);
            }
        }

    }
    static int query(int left, int right, int node, int count){
        // 1. Leaf 에 도착했을 때 -> 사탕 번호 반환 , 도착했을 땐 아무거나 해줘도 됌
        if(left == right){
            return left;
        }
        int mid = (left + right) / 2;
        // 2. 왼쪽 >= count -> 왼쪽으로 이동
        if(tree[node*2] >= count){
           return query(left, mid, node * 2, count);
        }
        // 3. 왼쪽 < count -> 오른쪽으로 이동
        else{
            return query(mid+1, right, node * 2 + 1, count - tree[node*2]);
        }
    }

    static void update(int left, int right, int node, int index, long diff){
        if(left <= index && index <= right){
            tree[node] += diff;
            if(left != right){
                int mid = (left + right) / 2;
                update(left, mid, node*2, index, diff);
                update(mid+1, right, node*2+1, index, diff);
            }
        }
    }
}
