import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[] switches;
    static int N;

    public static int toggle(int num){
        return num == 1 ? 0 : 1;
    }

    public static void mStudent(int num){
        for(int i=num-1; i<N; i+=num){
            switches[i] = toggle(switches[i]);
        }
    }

    public static void girlStudent(int num, int jump){
        if(num-jump < 0 || num+jump >= N) return;

        if(switches[num-jump] == switches[num+jump]){
            switches[num-jump] = switches[num+jump] = toggle(switches[num-jump]);
            girlStudent(num, jump+1);
        }
    }

    public static void print(){
        for(int i=0; i<N; i++){
            System.out.print(switches[i]);
            if((i+1)%20 == 0){
                System.out.println("");
            } else System.out.print(" ");
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        switches = new int[N];
        for(int i=0; i<N; i++){
            switches[i] = Integer.parseInt(st.nextToken());
        }

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if(sex == 1) mStudent(num);
            else {
                switches[num-1] = toggle(switches[num-1]);
                girlStudent(num-1, 1);
            }
        }

        // 스위치 출력은 20개 씩

        print();


        bw.flush();
        bw.close();
        br.close();
    }
}