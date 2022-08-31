import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder("");

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Integer[] nums = new Integer[N];
        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> minusNums = new ArrayList<>();
        ArrayList<Integer> plusNums = new ArrayList<>();
        int maxValue = 0;
        for (int i = 0; i < N; i++) {

            int num = Integer.parseInt(st.nextToken());
            maxValue = Math.max(maxValue, Math.abs(num));
            if (num < 0)
                minusNums.add(num);
            else if (num > 0)
                plusNums.add(num);
        }

        minusNums.sort((n1, n2) -> n1 - n2);
        plusNums.sort((n1, n2) -> n2 - n1);

        int cnt = 0;
        int answer = 0;


        if(!minusNums.isEmpty()){
            for (int i = 0; i < minusNums.size(); i++) {
                if (cnt == M) {
                    answer += 2 * Math.abs(minusNums.get(i - M));
                    cnt = 1;
                } else
                    cnt++;
            }
            answer += 2 * Math.abs(minusNums.get(minusNums.size() - cnt));
        }


        cnt = 0;
        if(!plusNums.isEmpty()){
            for (int i = 0; i < plusNums.size(); i++) {
                if (cnt == M) {
                    answer += 2 * Math.abs(plusNums.get(i - M));
                    cnt = 1;
                } else
                    cnt++;
            }
            answer += 2 * Math.abs(plusNums.get(plusNums.size() - cnt));
        }

        System.out.println(answer - maxValue);



        bw.flush();
        bw.close();
        br.close();
    }
}