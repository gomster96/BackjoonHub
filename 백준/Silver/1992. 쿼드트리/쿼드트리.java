import java.io.*;
import java.util.*;
public class Main {
    public static int[][] board;
    public static int isQuad(int row, int col, int size){
        int color = board[row][col];
        for(int i=row; i<row+size; i++){
            for(int j=col; j<col+size; j++){
                if(board[i][j] != color) return -1;
            }
        }
        return color;
    }
//    public static String partition(StringBuilder sb, int row, int col, int size){
    public static String partition(int row, int col, int size){
        if(size == 1) return Integer.toString(board[row][col]);
        int result = isQuad(row, col, size);
        if(result == -1){
            int nSize = size/2;
            return "("+partition(row, col, nSize) + partition(row,col+nSize,nSize) + partition(row+nSize, col, nSize) + partition(row+nSize, col+nSize, nSize) + ")";
        }
        else{
            return Integer.toString(result);
        }


    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(bf.readLine());
        board = new int[N][N];
        for(int i=0; i<N; i++){
            String tmp = bf.readLine();
            for(int j=0; j<tmp.length(); j++){
                board[i][j] = tmp.charAt(j) - '0';
            }
        }

        System.out.println(partition(0, 0, N));
        bw.flush();
        bw.close();
    }
}
