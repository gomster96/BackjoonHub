
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Integer> arr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(arr, (a, b)-> b-a);

        long sum = 0;
        int treeIdx = 0;
        int height = arr.get(treeIdx++);
        int treeCnt = 1;
        while(sum < M){
            // height를 낮춘다.
            height--;

            // 기준선 보다 높은 나무의 수를 구한다.
            while(treeIdx < arr.size() && height < arr.get(treeIdx)){
                treeIdx++;
                treeCnt++;
            }
            // height를 낮추면, 기준선 보다 높은 나무의 수만큼 sum에 더해줘야한다.
            sum += treeCnt;
        }
        System.out.println(height);
    }
}
