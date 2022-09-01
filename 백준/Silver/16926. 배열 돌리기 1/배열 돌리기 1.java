import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M, R;
    static int[][] map;

    public static void rotateOne(int r, int c, int w, int h) {
        int tmp = map[r][c];
        // 윗줄 가로 옮김
        for (int i = c; i < c + w - 1; i++) {
            map[r][i] = map[r][i + 1];
        }
        // 오른쪽 세로 옮김
        for (int i = r; i < r + h - 1; i++) {
            map[i][c + w - 1] = map[i + 1][c + w - 1];
        }
        // 아랫줄 옮김
        for (int i = c + w - 1; i > c; i--) {
            map[r + h - 1][i] = map[r + h - 1][i - 1];
        }
        // 왼쪽 세로 옮김
        for (int i = r + h - 1; i > r; i--) {
            map[i][c] = map[i - 1][c];
        }
        map[r + 1][c] = tmp;
    }

    public static void rotate(int r, int c, int w, int h) {
        if (w == 0 || h == 0)
            return;

        int rotateMod = w * h - (w - 2) * (h - 2);
        int rotateCnt = R % rotateMod;

        for (int i = 0; i < rotateCnt; i++) {
            rotateOne(r, c, w, h);
        }
        rotate(r + 1, c + 1, w - 2, h - 2);
    }

    public static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder("");

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        rotate(0, 0, M, N);
        print();
        bw.flush();
        bw.close();
        br.close();
    }
}