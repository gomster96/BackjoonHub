
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;

    public static long getNumOfPerson(long time){
        long numOfPerson = 0;
        for(int i=0; i<arr.length; i++){
            numOfPerson += time / arr[i];
        }
        return numOfPerson;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder("");
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int minTime = Integer.MAX_VALUE;
        arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(arr[i] < minTime) minTime = arr[i];
        }

        long right = (long) minTime * M;
        long left = 1;
        // 여기서 실수가 나옴 .... Long.MAX_VALUE로 해야하는데 습관적으로 INTEger.MAXVALUE를 해버림
        long answer = Long.MAX_VALUE;
        while(left <= right){
            long mid = (left + right) /2;
            long numOfPerson = getNumOfPerson(mid);

            if(numOfPerson >= M){
                if(answer > mid) answer = mid;
                right = mid-1;
            } else if(numOfPerson < M) left = mid + 1;
        }
        System.out.println(answer);

        bw.flush();
        bw.close();
        br.close();
    }


}