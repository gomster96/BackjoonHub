
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] dp;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder("");


        N = Integer.parseInt(br.readLine());
        dp = new int[N];
        arr = new int[N];
        int LIS = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++){
            int idx = BinarySearch(arr[i], 0, LIS, LIS + 1);

            if(idx == -1){
                dp[LIS++] =arr[i];
            } else {
                dp[idx] = arr[i];
            }
        }

        System.out.println(LIS);
        bw.flush();
        bw.close();
        br.close();
    }

    private static int BinarySearch(int num,int start, int end, int size){
        int res = 0;
        while(start <= end){
            int mid = (start + end)/2;
            if(num <= dp[mid]){
                res = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if(start == size) return -1;
        return res;
    }
}