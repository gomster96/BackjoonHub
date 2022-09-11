
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static class Pos {
        int r, c, cnt;

        public Pos(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder("");

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        int[][] visited = new int[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < line.length(); j++) {
                map[i][j] = line.charAt(j) - '0';
                visited[i][j] = Integer.MAX_VALUE;
            }
        }
        visited[0][0] = 0;
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(0, 0, 0));

        while(!q.isEmpty()){
            Pos cur = q.poll();
            for(int i=0; i<4; i++){
                int rr = cur.r + dy[i];
                int cc = cur.c + dx[i];

                if(rr < 0 || cc < 0 || rr >=N || cc >=N){
                    continue;
                }
                // 하얀 벽일 때
                if(map[rr][cc] == 1){
                    int nextCnt = cur.cnt;
                    if(nextCnt >= visited[rr][cc]) continue;
                    visited[rr][cc] = nextCnt;
                    q.add(new Pos(rr, cc, nextCnt));
                }
                // 검은 벽일 때
                else {
                    int nextCnt = cur.cnt + 1;
                    if(nextCnt >= visited[rr][cc]) continue;
                    visited[rr][cc] = nextCnt;
                    q.add(new Pos(rr, cc, nextCnt));
                }
            }
        }

        System.out.println(visited[N-1][N-1]);

        bw.flush();
        bw.close();
        br.close();
    }
}