import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder("");

        int N = Integer.parseInt(br.readLine());

        int S, E;
        int[] calender = new int[366];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            for(int j=S; j<=E; j++){
                calender[j]++;
            }
        }


        int answer = 0;
        int maxHeight = 0;
        int cnt = 0;
        for(int i=1; i<calender.length; i++){
            if(maxHeight < calender[i]){
                maxHeight = calender[i];
            } else if(calender[i] == 0){
                answer += maxHeight * cnt;
                cnt = 0;
                maxHeight = 0;
                continue;
            }
            cnt++;
        }
        answer += maxHeight * cnt;

        System.out.println(answer);

        bw.flush();
        bw.close();
        br.close();
    }
}