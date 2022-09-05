import java.util.*;
import java.io.*;
public class Main {
    public static boolean isPossible(String str, int startIdx, int endIdx){

        if(startIdx >= endIdx){
            return true;
        }

        int left = startIdx;
        int right = endIdx;

        while(left < right){
            if(str.charAt(left++) == str.charAt(right--)){
                return false;
            }
        }
        // 이미 전체가 대칭인 것은 검사했으니... 나머지 반만 검사하는 방법
        // 참고블로그 https://jaimemin.tistory.com/1784
        return isPossible(str, startIdx, right-1);
    }
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(bf.readLine());
        for(int i=0; i<N; i++){
            String str = bf.readLine();
            if(isPossible(str, 0, str.length()-1)) bw.write("YES\n");
            else bw.write("NO\n");
        }
        bw.flush();
        bw.close();
    }
}
