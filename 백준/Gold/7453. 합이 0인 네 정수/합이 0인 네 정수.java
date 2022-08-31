import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
// 괄호실수 주의
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] A = new long[N];
        long[] B = new long[N];
        long[] C = new long[N];
        long[] D = new long[N];
        StringTokenizer st = null;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }
//        ArrayList<Long> abSum = new ArrayList<>();
//        ArrayList<Long> cdSum = new ArrayList<>();
        long[] abSum = new long[N*N];
        long[] cdSum = new long[N*N];
        int idx = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
//                abSum.add(A[i] + B[j]);
//                cdSum.add(C[i] + D[j]);
                abSum[idx] = A[i] + B[j];
                cdSum[idx] = C[i] + D[j];
                idx++;
            }
        }
//        Collections.sort(abSum);
//        Collections.sort(cdSum);

        Arrays.sort(abSum);
        Arrays.sort(cdSum);
       // 이분탐색 깊게 공부해보기
        // 왜 이분탐색으로 안되는지 공부하기
        // 투포인터 알고리즘 공부하기
        long answer = 0;
        int abP = 0;
//        int cdP = cdSum.size()-1;
        int cdP = idx-1;
        while (true) {
//            long valAB = abSum.get(abP);
//            long valCD = cdSum.get(cdP);
            long valAB = abSum[abP];
            long valCD = cdSum[cdP];
            long sum = valAB + valCD;
            if(sum > 0){
                cdP--;
            } else if(sum == 0){
                int abCnt = 0;
                int cdCnt = 0;
                while(abP < idx && abSum[abP] == valAB){
                    abP++;
                    abCnt++;
                }
                while(cdP >= 0 && cdSum[cdP] == valCD){
                    cdP--;
                    cdCnt++;
                }
//                while(abP < abSum.size() && abSum.get(abP) == valAB){
//                    abP++;
//                    abCnt++;
//                }
//                while(cdP >= 0 && cdSum.get(cdP) == valCD){
//                    cdP--;
//                    cdCnt++;
//                }
                answer += (long) abCnt * cdCnt;
            } else{
                abP++;
            }
            if(abP >= idx || cdP < 0) break;;
        }

        System.out.println(answer);




//        for(int i=0; i<abSum.size(); i++){
//            long target = -abSum.get(i);
//            int start = 0, end = cdSum.size()-1;
//            while(start <= end){
//                int mid = (start + end) / 2; // 여기서 괄호를 안쳐줘서 실수.... 이런 실수 주의하자
//                if(target > cdSum.get(mid)){
//                    start = mid+1;
//                }  else{
//                    end = mid -1;
//                }
//            }
//            if(target == cdSum.get(start)) answer++;
//        }
    }
}
