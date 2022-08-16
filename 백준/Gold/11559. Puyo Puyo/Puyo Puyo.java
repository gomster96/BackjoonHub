import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int H = 12;
    static int W = 6;
    static char[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int sameCnt = 0;
    public static void DFS(int r, int c, char val){

        for(int i=0; i<4; i++){
            int rr = r + dy[i];
            int cc = c + dx[i];
            if(rr >= H || rr < 0 || cc >= W || cc < 0) continue;
            if(!visited[rr][cc] && map[rr][cc] == val){
                visited[rr][cc] = true;
                sameCnt++;
                DFS(rr, cc, val);
            }
        }
    }

    public static void markX(int r, int c, char val){
        for(int i=0; i<4; i++){
            int rr = r + dy[i];
            int cc = c + dx[i];
            if(rr >= H || rr < 0 || cc >= W || cc < 0) continue;
            if(map[rr][cc] == val){
                map[rr][cc] = 'X';
                markX(rr, cc, val);
            }
        }
    }

    public static void moveRow(int row, int col){
        for(int i=row; i>=1; i--){
            map[i][col] = map[i-1][col];
        }
        map[0][col] = '.';
    }

    public static void moveMap(){
        for(int j=0; j<W; j++){
            int i = H-1;
            while(i >= 0){
                if(map[i][j] == 'X'){
                    moveRow(i,j);
                } else i--;
            }
        }
    }

    public static void print(){
        for(int i=0; i<H; i++){
            for(int j=0; j<W; j++){
                System.out.print(map[i][j]);
            }
            System.out.println("");
        }
        System.out.println("|||||||||||||||||||||");
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder("");

        map = new char[H][W];
        visited = new boolean[H][W];
        for(int i=0; i<H; i++){
            String line = br.readLine();
            for(int j=0; j<line.length(); j++){
                map[i][j] = line.charAt(j);
            }
        }
        boolean flag = true;
        int answer = -1;
        while(flag){
            flag = false;
            answer++;
            for(int i=0; i<H; i++){
                for(int j=0; j<W; j++){
                    if(map[i][j] =='.' || visited[i][j]) continue;
                    visited[i][j] = true;
                    sameCnt = 1;
                    DFS(i, j, map[i][j]);
                    if(sameCnt >= 4){
                        flag = true;
                        markX(i,j,map[i][j]);
                    }
                }
            }
            for(int i=0; i<H; i++){
                for(int j=0; j<W; j++){
                    visited[i][j] = false;
                }
            }
            moveMap();

        }
        System.out.println(answer);



        bw.flush();
        bw.close();
        br.close();
    }
}