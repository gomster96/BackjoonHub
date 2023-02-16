
import java.io.*;
import java.util.*;
public class Main {
    static char[][] map;
    static int R;
    static int C;
    static int val;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        // 깔끔하게 저장하는 방법
        for(int i=0; i<R; i++){
            map[i] = br.readLine().toCharArray();
        }

        for(int i=0; i<R; i++){
            if(check(i,0)) val++;
        }
        System.out.println(val);;
    }

    public static boolean check(int x, int y){
        map[x][y] = '-';

        if(y == C-1) // 마지막 열에 도착했을 때
                return true;
        if(x > 0 && map[x-1][y+1] == '.'){
            if(check(x-1, y+1)) return true;
        }

        if(map[x][y+1] == '.')
            if(check(x,  y+1)) return true;

        if(x+1 < R && map[x+1][y+1] == '.')
            if(check(x+1, y+1)) return true;

        return false;
    }
}
