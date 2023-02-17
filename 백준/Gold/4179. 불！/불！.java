
import java.io.*;
import java.util.*;
public class Main {
    static class Pos{
        public int r, c, cnt;
        public boolean isJihun;

        public Pos(int r, int c, int cnt, boolean isJihun) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.isJihun = isJihun;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder("");

        st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] map = new char[R][C];
        boolean[][] fireVisited = new boolean[R][C];
        boolean[][] jihunVisited = new boolean[R][C];
        Queue<Pos> q = new LinkedList<>();
        Pos jihun = new Pos(0,0,1, true);
        for(int i=0; i<R; i++){
            String line = br.readLine();
            for(int j=0; j<C; j++){
                map[i][j] = line.charAt(j);
                if(map[i][j] == 'F'){
                    q.add(new Pos(i,j,1, false));
                    fireVisited[i][j] = true;
                }
                if(map[i][j] == 'J') {
                    jihun = new Pos(i,j, 1, true);
                    map[i][j] = '.';
                    jihunVisited[i][j] = true;
                }
            }
        }
        q.add(jihun);
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};
        while(!q.isEmpty()){
            Pos cur = q.poll();
            if(cur.isJihun && (cur.r == 0 || cur.c == 0 || cur.r == R-1 || cur.c == C-1)){
                System.out.println(cur.cnt);
                System.exit(0);
            }
            for(int i=0; i<4; i++){
                int rr = cur.r + dy[i];
                int cc = cur.c + dx[i];

                if(rr < 0 || cc < 0 || rr >= R || cc >= C) continue;

                if(cur.isJihun){
                    // 지훈이 일때
                    if(map[rr][cc] == '.' && !jihunVisited[rr][cc]){
                        q.add(new Pos(rr,cc,cur.cnt+1, cur.isJihun));
                        jihunVisited[rr][cc] = true;
                    }
                } else {
                    // 지훈이가 아닐 때
                    if (map[rr][cc] == '.' && !fireVisited[rr][cc]) {
                        map[rr][cc] = 'F';
                        q.add(new Pos(rr, cc, cur.cnt + 1, cur.isJihun));
                        fireVisited[rr][cc] = true;
                    }
                }

            }

        }
        System.out.println("IMPOSSIBLE");

        bw.flush();
        bw.close();
    }
}
