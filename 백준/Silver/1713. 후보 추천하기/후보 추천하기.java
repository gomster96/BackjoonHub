
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Pair{
        int num, cnt;

        public Pair(int num) {
            this.num = num;
            this.cnt = 1;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Pair> arr = new ArrayList<>();
        for(int i=0; i<M; i++){
            int nextNum = Integer.parseInt(st.nextToken());
            int numIdx = - 1;
            for(int j=0; j<arr.size(); j++){
                if(nextNum == arr.get(j).num){
                    numIdx = j;
                    break;
                }
            }
            if(numIdx == -1){
                if(arr.size() == N){
                    // 추천 개수가 가장 적은 학생을 삭제
                    int min = Integer.MAX_VALUE;
                    int minIdx = -1;
                    for(int j=0; j<arr.size(); j++){
                        if(min > arr.get(j).cnt){
                            min = arr.get(j).cnt;
                            minIdx = j;
                        }
                    }
                    arr.remove(minIdx);
                }
                arr.add(new Pair(nextNum));

            } else{
                arr.get(numIdx).cnt++;
            }
        }
        Collections.sort(arr, (e1, e2) ->{
            return e1.num - e2.num;
        });
        arr.forEach(el ->{
            System.out.print(el.num+" ");
        });
    }
}
