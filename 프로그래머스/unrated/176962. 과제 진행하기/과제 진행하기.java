import java.util.*;

// 과제를 시작하기로 한 시각에 시작
// 새로운 과제를 시작할 때는, 기존의 과제를 멈추고 새로운 과제 시작
// 진행중이던 과제를 끝나면 멈춰둔 과제를 이어서 함 

// 우선순위 : 새로운 과제, 멈춘과제 => 가장 최근에 멈춘 과제 우선 -> PriorityQueue
// 과제가 끝난 순서대로 이름을 배열에 담아 return 하는 solution 함수를 완성하기


class Solution {
    
    static class Assignment{
        String name;
        int start;
        int time;
        
        public Assignment(String name, String start, String time){
            this.name = name;
            String[] tmpStart = start.split(":");
            this.start = Integer.parseInt(tmpStart[0]) * 60 + Integer.parseInt(tmpStart[1]);         
            this.time = Integer.parseInt(time);
        }
        
        public Assignment(String name, int start, int time){
            this.name = name;
            this.start = start;
            this.time = time;
        }
        
    }
        
    public String[] solution(String[][] plans) {
        StringBuilder sb = new StringBuilder("");
        
//      현재의 Assignment와 PQ의 TOP이랑 비교해서
//      더 작은게 나오고, 나머지는 다시 들어감

//      PriorityQueue가 2개, new용, old용
//         new용은 시간순으로 처리 -> 시작하는 시간이 되면 무조건 바꿈
//         Old는 new로시작한 것이 끝나고, 다음 시작까지 시간이 있을경우 
        
        PriorityQueue<Assignment> newA = new PriorityQueue<>((a1, a2) -> a1.start - a2.start);
        PriorityQueue<Assignment> oldA = new PriorityQueue<>((a1, a2) -> a2.start - a1.start);
        
        for(int i=0; i<plans.length; i++){
            newA.add(new Assignment(plans[i][0],plans[i][1],plans[i][2]));
        }
        Assignment cur = newA.poll();
        // System.out.println("cur: " + cur.name);
        while(!newA.isEmpty() || !oldA.isEmpty()){
            
//          newA랑 oldA가 각각 empty일떄도 확인해야함 
            if(newA.isEmpty()){
                sb.append(cur.name + " ");
                
                cur = oldA.poll();
                continue;
            }
            
            Assignment newTop = newA.peek();
            
//          현재 과제가 끝나기 전에 새로운 과제가 있을 때
            if(newTop.start == cur.start + cur.time){
                sb.append(cur.name + " ");
                System.out.println("check1: name: " + cur.name + " start : " + cur.start +  " time: " + cur.time );
                cur = newA.poll();
            }
            else if(newTop.start < cur.start + cur.time){
                System.out.println("check2 bdfore: name: " + cur.name + " start : " + cur.start +  " time: " + cur.time );
                cur.time = cur.start + cur.time - newTop.start;
                cur.start = newTop.start;
                System.out.println("check2 after: name: " + cur.name + " start : " + cur.start +  " time: " + cur.time );
                oldA.add(cur);
                cur = newA.poll();
            } else {
                sb.append(cur.name + " ");
                System.out.println("check3 in : name: " + cur.name + " start : " + cur.start +  " time: " + cur.time );
                if(oldA.isEmpty()){
                    cur = newA.poll();
                } else {
                    int curTime = cur.start + cur.time;
                    cur = oldA.poll();
                    cur.start = curTime;
                }
            }
//          현재 과제가 끝났을 때
        }
        sb.append(cur.name + " ");
        System.out.println(sb.toString());
        return sb.toString().split(" ");
    }
}