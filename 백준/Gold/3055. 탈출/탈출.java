import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Pair{
        int r, c;
        Pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] board = new char[R][C];
        int[][] visited = new int[R][C];
        Pair gosum = new Pair(0,0);
        Queue<Pair> q = new LinkedList<>();
        for(int i=0; i<R; i++){
            String s = br.readLine();
            for(int j=0; j<C; j++){
                board[i][j] = s.charAt(j);
                if(board[i][j] == '*') q.add(new Pair(i,j));
                if(board[i][j] == 'S') gosum = new Pair(i,j);
            }
        }
        q.add(gosum);


        visited[gosum.r][gosum.c] = 1;
        while(!q.isEmpty()){
//            for(int i=0; i<R; i++){
//                for(int j=0; j<C; j++){
//                    System.out.print(board[i][j]);
//                }
//                System.out.println("");
//            }
            Pair next = q.poll();
            int r = next.r;
            int c = next.c;

            for(int i=0; i<4; i++){
                int rr = r + dy[i];
                int cc = c + dx[i];
                // 영역 안에 있는지
                if(rr >= R || rr < 0 || cc >=C || cc < 0 ) continue;
                // 이동지점이 물이나 돌일 경우 이동 불가
                if(board[rr][cc] == '*' || board[rr][cc] == 'X') continue;

                // 고슴도치일때
                if(visited[r][c] != 0){

                    if(board[rr][cc] == 'D'){
                        System.out.println(visited[r][c]);
                        System.exit(0);
                    } else {
                        if(visited[rr][cc] == 0){

                            visited[rr][cc] = visited[r][c] + 1;
                            q.add(new Pair(rr,cc));
                        }
                    }
                }
                // 물일 때
                else if(board[r][c] == '*' && board[rr][cc] != 'D'){

                    board[rr][cc] = '*';
                    q.add(new Pair(rr,cc));
                }



            }
        }

        System.out.println("KAKTUS");
    }
}
