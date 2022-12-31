
import java.io.*;
import java.util.*;
public class Main {

    // 반례 1 : root 는 꼭 0이 아님, 다른 숫자가 root가능
    // 반례 2 : 자식이 하나뿐인 트리에서 자신의 자식이 없어지면 자기 자식이 리프노드가 됌


    static class Node{
        ArrayList<Integer> childs;
        public Node(){
            childs = new ArrayList<>();
        }

    }
    static Node[] nodes;
    static int N;
    static int answer = 0;
    static int removeLeaf;
    public static void findLeaf(int nodeIdx){
//        System.out.println("node: " + nodeIdx);

        for(int i=0; i<nodes[nodeIdx].childs.size(); i++){
            int nextNode = nodes[nodeIdx].childs.get(i);
            if(nextNode == removeLeaf){
                if(nodes[nodeIdx].childs.size() == 1) answer++;
            } else if(nodes[nextNode].childs.size() == 0) answer ++;
            else {
                findLeaf(nextNode);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        nodes = new Node[51];
        int root = -1;
        for(int i=0; i<=50; i++){
            nodes[i] = new Node();
        }
        for(int i=0; i<N; i++){
            int parent = Integer.parseInt(st.nextToken());
            if(parent == -1) root = i;
            else{
                nodes[parent].childs.add(i);
            }
        }

        removeLeaf = Integer.parseInt(br.readLine());
        if(removeLeaf == root) System.out.println(0);
        else {
            findLeaf(root);
            System.out.println(answer);
        }


    }
}