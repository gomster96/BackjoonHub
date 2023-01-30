
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Mirror implements Comparable<Mirror> {
    int x;
    int y;
    int dir; // 거울의 현재 방향
    int cnt; // 사용한 거울의 개수

    public Mirror(int x, int y, int dir, int cnt) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Mirror o) {
        return this.cnt - o.cnt;
    }
}

public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int N;
    static int sx, sy, ex, ey; // 문 좌표
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new char[N][N];

        int idx = 0;
        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < N; j++) {
                // 문 좌표 저장
                map[i][j] = line.charAt(j);

                if (map[i][j] == '#') {
                    if (idx == 0) {
                        sx = i;
                        sy = j;
                    } else {
                        ex = i;
                        ey = j;
                    }
                    idx++;
                }
            }
        }
        bfs();
    }
    public static void bfs(){
        PriorityQueue<Mirror> pq = new PriorityQueue<>();

        // 좌표와 어느 방향으로부터 왔는지를 visited 처리해야함
        boolean[][][] visited = new boolean[N][N][4];

        // 처음 문 위치를 기준으로 4 방향 모두 추가하기
        for(int i=0; i<4; i++){
            pq.add(new Mirror(sx, sy, i, 0));
        }

        while(!pq.isEmpty()){
            Mirror cur = pq.poll();

            int x = cur.x;
            int y = cur.y;
            int dir = cur.dir;
            int cnt = cur.cnt;

            // 큐에서 꺼냈으니 방문 처리함
            visited[x][y][dir] = true;

            // 다른 쪽 문을 만난 경우 거울 개수 출력
            if(x == ex && y == ey){
                System.out.println(cnt);
                return;
            }
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 다음 좌표가 범위를 벗어나지 않음 && 방문 하지 않은 곳 && 빛이 통과할 수 없는 곳이 아닌 경우
            if( nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny][dir] && map[nx][ny] != '*'){
                // 거울을 설치할 수 있는 곳인 경우
                if(map[nx][ny] == '!'){
                    // 거울이 정방향에서 45도 기울어진 대각선 방향으로 추가해야하므로
                    // '/' 시계방향 또는 '\' 반시계 방향 모양으로 설치 될 수 있음
                    // 해당 설치마다 방향을 45도 각도로 기울여 줘야하기 때문에 2가지 경우가 나옴
                    // 뱡향에서 +3 을 해주는 경우 또는 +1을 해주는 경우


                    // 시계방향 (오른쪽)
                    int nDir = (dir + 3) % 4;
                    pq.add(new Mirror(nx, ny,nDir, cnt+1));

                    nDir = (dir + 1) % 4;
                    pq.add(new Mirror(nx, ny, nDir, cnt + 1));
                }
                // '!' 인 경우에 반드시 거울을 설치할 필요는 없음
                // 거울을 설치 안하는 경우를 추가하기
                pq.add(new Mirror(nx, ny, dir, cnt));
            }
        }
    }
}