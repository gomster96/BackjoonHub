import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int answer = Integer.MAX_VALUE;
    static int N;
    static int M;
    static int[][] map;
    static int[][] virusMap;
    static ArrayList<Pos> viruses = new ArrayList<>();
    static Queue<Pos> q = new LinkedList<>();
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static void bfs() {
        while (!q.isEmpty()) {
            Pos cur = q.poll();
            if (virusMap[cur.r][cur.c] != 0 && virusMap[cur.r][cur.c] < cur.cnt)
                continue;

            for (int i = 0; i < 4; i++) {
                int rr = cur.r + dy[i];
                int cc = cur.c + dx[i];

                if (rr < 0 || cc < 0 || rr >= N || cc >= N)
                    continue;
                // 벽이 아니고, 빈칸이거나 이전 바이러스보다 수가 작으면
                // 여기서 virusMap[rr][cc] cur.cnt+1 >= 을 했어야했는데 그냥 > 를 해서 문제 발생 -> 이러면 메모리초과나옴
                // init 할때 virus도 0으로 처리해야함
                if (virusMap[rr][cc] != -1 && (virusMap[rr][cc] == 0 || virusMap[rr][cc] > cur.cnt + 1)) {
                    virusMap[rr][cc] = cur.cnt + 1;
                    q.add(new Pos(rr, cc, cur.cnt + 1));
                }
            }
        }
        checkAnswer();
    }

    static void initMap() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                virusMap[i][j] = map[i][j];
                if(map[i][j] == 2) virusMap[i][j] = 0;
            }
        }
    }

    static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(virusMap[i][j]+ " ");
            }
            System.out.println("");
        }
        System.out.println("fin");
    }

    static void combination(boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            initMap();
            for (int i = 0; i < visited.length; i++) {

                if (visited[i]) {
                    virusMap[viruses.get(i).r][viruses.get(i).c] = 1;
                    q.add(viruses.get(i));
                }
            }
            bfs();
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    static void checkAnswer() {
        int maxTime = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (virusMap[i][j] == 0)
                    return;
                // 비활성 바이러스의 경우를 위한 처리
                if(map[i][j] == 2) virusMap[i][j] = 1;
                if (virusMap[i][j] > maxTime){
                    maxTime = virusMap[i][j];
                }

            }
        }
        if (maxTime > 0 && maxTime < answer)
            answer = maxTime;
    }


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

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        virusMap = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    viruses.add(new Pos(i, j, 1));
                }
                if (map[i][j] == 1)
                    map[i][j] = -1;
            }
        }
        boolean[] visited = new boolean[viruses.size()];
        combination(visited, 0, viruses.size(), M);
        if (answer == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(answer - 1);
        bw.flush();
        bw.close();
        br.close();
    }
}