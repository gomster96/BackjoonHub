
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

//    public static void getSubset( int[] arr, int idx, int sum, int cnt,ArrayList<Integer> subset){
//        if(idx == arr.length){
//            if(cnt!=0) subset.add(sum);
//            return;
//        }
//        getSubset(arr, idx+1, sum+arr[idx], cnt+1, subset);
//        getSubset(arr, idx+1, sum, cnt, subset);
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> subA = new ArrayList<>();
        for(int i=0; i<N; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<N; i++){
            int sum = a[i];
            subA.add(sum);
            for(int j=i+1; j<N; j++){
                sum+=a[j];
                subA.add(sum);
            }
        }

        N = Integer.parseInt(br.readLine());
        int[] b = new int[N];
        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> subB = new ArrayList<>();
        for(int i=0; i<N; i++){
            b[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<N; i++){
            int sum = b[i];
            subB.add(sum);
            for(int j=i+1; j<N; j++){
                sum+=b[j];
                subB.add(sum);
            }
        }
        Collections.sort(subA);
        Collections.sort(subB);
        int pA = 0, pB = subB.size()-1;
        long answer = 0;
        while(true){
            int aVal = subA.get(pA);
            int bVal = subB.get(pB);
            long sum = aVal + bVal;
            if(sum > T){
                pB--;
            } else if(sum == T){
                int aPCnt = 0;
                int bPCnt = 0;
                while(pA < subA.size() && subA.get(pA) == aVal){
                    aPCnt++;
                    pA++;
                }
                while(pB >=0 && subB.get(pB) == bVal){
                    bPCnt++;
                    pB--;
                }
//                System.out.println("apCnt: " + aPCnt + " bpCnt: " + bPCnt + " aVal: " + aVal + " bVal: " + bVal);

                answer += (long) aPCnt * bPCnt;
            } else {
                pA++;
            }
            if(pB < 0 || pA >= subA.size() ) break;
        }
        System.out.println(answer);
    }

}

