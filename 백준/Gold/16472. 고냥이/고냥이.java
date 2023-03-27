
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {




    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String line = br.readLine();
        //        char[] alphas = new char[N];

        int alpahSize = 0;
        int maxLength = 1;
        int[] ch = new int[26];
        int lo = 0;
        for(int i=0; i<line.length(); i++){


            int nextAlpha = line.charAt(i) - 'a';

            if(ch[nextAlpha] == 0){
                alpahSize++;
            }
            ch[nextAlpha]++;
            while(alpahSize > N){
                int eraseNum = line.charAt(lo) - 'a';
                ch[eraseNum]--;
                lo++;
                if(ch[eraseNum]==0){
                    alpahSize--;
                }
            }

            maxLength = Math.max(maxLength, i-lo+1);
        }



        System.out.println(maxLength);

        bw.flush();
        bw.close();
        br.close();
    }
}

//public class Main {
//
//    public static class Pair{
//        int idx, character;
//
//        public Pair(int idx, int character) {
//            this.idx = idx;
//            this.character = character;
//        }
//    }
//
//    public static boolean isAlphaExist(ArrayList<Pair> alphas, char nextAlpha){
//        return alphas.stream().anyMatch(el -> el.character==nextAlpha);
//    }
//
//    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/backjoon/input.txt"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int N = Integer.parseInt(br.readLine());
//        String line = br.readLine();
////        char[] alphas = new char[N];
//        ArrayList<Pair> alphas = new ArrayList<>();
//        int firstAlphaIdx = 0;
//        int alpahSize = 0;
//        int maxLength = 1;
//        for(int i=0; i<line.length(); i++){
//
//            if(isAlphaExist(alphas, line.charAt(i))) continue;
//
//            if(alpahSize < N){
//                alpahSize++;
//                alphas.add(new Pair(i, line.charAt(i)));
//                continue;
//            }
//
//            int curLength = i - alphas.get(firstAlphaIdx).idx;
//            if(curLength > maxLength) maxLength = curLength;
//
//            alphas.set(firstAlphaIdx, new Pair(i, line.charAt(i)));
//            firstAlphaIdx = (firstAlphaIdx + 1) % N;
//        }
//
//        int curLength = line.length() - alphas.get(firstAlphaIdx).idx;
//        if(curLength > maxLength) maxLength = curLength;
//
//        System.out.println(maxLength);
//
//        bw.flush();
//        bw.close();
//        br.close();
//    }
//}