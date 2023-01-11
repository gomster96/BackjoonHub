
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Character> arr;
    static char[] vowel = {'a', 'e', 'i', 'o', 'u'};
    static int L, C;

    public static boolean isAnswer(String str){
        int vowelCnt = 0;
        int consonantCnt = 0;
        boolean addConsonanat = true;
        for(int i=0; i<str.length(); i++){
            for(int j=0; j<vowel.length; j++){
                addConsonanat = true;
                if(str.charAt(i) == vowel[j]){
                    addConsonanat = false;
                    vowelCnt++;
                    break;
                }
            }
            if(addConsonanat) consonantCnt++;
            if(vowelCnt >= 1 && consonantCnt >=2) return true;
        }
        return false;
    }

    public static void DFS(int idx){
        // 목적지 체크인
        sb.append(arr.get(idx));
        // 목적지인가?
        if(sb.length() == L){
            if(isAnswer(sb.toString())) System.out.println(sb.toString());
            sb.delete(sb.length()-1, sb.length());
            return;
        }
        // 갈수있는가?
        for(int i=idx+1; i<arr.size(); i++){
            // 간다
            DFS(i);
        }
        //체크아웃  맨 뒤에값 삭제하기
        sb.delete(sb.length()-1, sb.length());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<C; i++){
            arr.add(st.nextToken().charAt(0));
        }
        Collections.sort(arr);
        for(int i=0; i<arr.size(); i++){
            DFS(i);
        }

    }
}
