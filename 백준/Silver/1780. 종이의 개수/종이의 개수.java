import java.io.*;
import java.util.*;
public class Main {
    public static int[][] board;
    public static int minusOne = 0;
    public static int zero = 0;
    public static int plusOne = 0;

    public static void increseNum(int num){
        if(num == -1) minusOne++;
        else if(num == 0) zero++;
        else plusOne++;
    }
    public static boolean numCheck(int row, int col, int size){
        int num = board[row][col];
        for(int i=row; i<row+size; i++){
            for(int j=col; j<col+size; j++){
                if(board[i][j]!=num) return true;
            }
        }
        increseNum(num);
        return false;
    }
    public static void partition(int row, int col, int size){
        
        if(size == 1){
            increseNum(board[row][col]);
            return;
        }
        int nextSize = size/3;
        if(numCheck(row, col, nextSize)) partition(row, col, nextSize);
        if(numCheck(row + nextSize, col, nextSize)) partition(row+nextSize, col, nextSize);
        if(numCheck(row + nextSize * 2, col, nextSize)) partition(row+nextSize*2, col, nextSize);
        if(numCheck(row, col + nextSize, nextSize)) partition(row, col+nextSize, nextSize);
        if(numCheck(row + nextSize, col + nextSize, nextSize)) partition(row+nextSize, col+nextSize, nextSize);
        if(numCheck(row + nextSize * 2, col + nextSize, nextSize)) partition(row+nextSize*2, col+nextSize, nextSize);
        if(numCheck(row, col + nextSize * 2, nextSize)) partition(row, col+nextSize*2, nextSize);
        if(numCheck(row + nextSize, col + nextSize * 2, nextSize)) partition(row+nextSize, col+nextSize*2, nextSize);
        if(numCheck(row + nextSize * 2, col + nextSize * 2, nextSize)) partition(row+nextSize*2, col+nextSize*2, nextSize);
    }
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        board = new int[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                board[i][j] = sc.nextInt();
            }
        }
        if(numCheck(0,0,N)) partition(0,0,N);
        System.out.println(minusOne);
        System.out.println(zero);
        System.out.println(plusOne);
    }
}
