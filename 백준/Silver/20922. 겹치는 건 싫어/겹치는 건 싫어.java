import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder("");

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int lt = 0;
        int rt = -1;
        int[] numCnt = new int[100001];
        int answer = 1;
        List<Integer> nums = Arrays.stream(br.readLine().split(" "))
                                      .map(Integer::parseInt)
                                      .collect(Collectors.toList());

        for(int i=0; i<nums.size(); i++){
            int num = nums.get(i);
            while(numCnt[num] >= K && lt < rt){
                numCnt[nums.get(lt++)]--;
            }
            numCnt[num]++;
            rt++;
            answer = Math.max(rt - lt + 1, answer);
        }


        System.out.println(answer);

        bw.flush();
        bw.close();
        br.close();
    }
}