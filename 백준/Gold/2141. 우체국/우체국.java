import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main{
    static class Pair{
        public long first,second;
        Pair(long x,long y){
            this.first = x;
            this.second = y;
        }
    }
    static int n;
    static long total = 0;
    static Vector<Pair> v = new Vector<Pair>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long a = Long.parseLong(st.nextToken());
            total+= a;
            v.add(new Pair(x,a));
        }
        Collections.sort(v, (p1, p2) ->{
            if(p1.first > p2.first) return 1;
            else return -1;
        });
        long people = 0;
        for(Pair p : v){
            people += p.second;
            if(people >= (total+1)/2){
                bw.write(String.valueOf(p.first)+"\n");
                break;
            }
        }
        bw.flush();
        bw.close();
    }
}