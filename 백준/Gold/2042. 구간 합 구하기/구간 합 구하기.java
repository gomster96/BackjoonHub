
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // t값을 구해 index트리의 총 사이즈를 알아야함
        int S = 1;
        while(S < N){
            S *= 2;
        }

        long[] nInputs = new long[N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            nInputs[i] = Long.parseLong(st.nextToken());
        }
        // 인덱스 트리 생성
        IndexTree indexTree = new IndexTree();
        indexTree.init(S, nInputs);
        for(int i=0; i<M+K; i++){
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if(a==1){
                long diff = (c- indexTree.tree[(int) (S+b-1)]);
                indexTree.update(1,S, 1, b, diff);
            } else {

                System.out.println(indexTree.query(1, S, 1, b, c));
            }
        }

    }
    public static class IndexTree{
        public long[] tree;
        int S;
        public void init(int s, long[] nInputs){
            this.S = s;
            tree = new long[S*2+1];
            for(int i=0; i<N; i++){
                tree[S+i] = nInputs[i];
            }
            for(int i=S-1; i>0; i--){
                tree[i] = tree[i*2] + tree[i*2+1];
            }
        }
        public long query(long left, long right, int node,long queryLeft, long queryRight){
            // node 는 현재 트리의 인덱스
            if(left > queryRight || right < queryLeft) return 0;
            if(left >= queryLeft && right <= queryRight){
                return tree[node];
            }

            long mid = (left + right) / 2;
            long leftVal = query(left, mid, node*2, queryLeft, queryRight);
            long rightVal = query(mid+1, right, node*2+1, queryLeft, queryRight);
            return leftVal + rightVal;
        }

        public void update(long left, long right, int node, long target, long diff){
            if(left > target || right <target) return;

            tree[node] += diff;
            if(left != right){
                long mid = (left + right) / 2;
                update(left, mid, node*2, target, diff);
                update(mid+1, right, node*2+1, target, diff);
            }
        }
    }
}
