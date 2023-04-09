import java.util.*;

// R, T
// C, F
// J, M
// A, N

// 1 : 매우 비동의 : + 3, 4 = 0, 7 매우 동의  + 3 


class Solution {
    
    public String solution(String[] survey, int[] choices) {
        StringBuilder sb = new StringBuilder("");
        
        
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('R', 0);
        map.put('T', 0);
        map.put('C', 0);
        map.put('F', 0);
        map.put('J', 0);
        map.put('M', 0);
        map.put('A', 0);
        map.put('N', 0);
        for(int i=0; i<survey.length; i++){
            int point = choices[i] - 4;
            
            if(point < 0){
                int val =  map.get(survey[i].charAt(0));
                map.put(survey[i].charAt(0), val + Math.abs(point));
            } else {
                int val =  map.get(survey[i].charAt(1));
                map.put(survey[i].charAt(1), val + point);
            }
        }
        
        if(map.get('R') >= map.get('T')){
            sb.append('R');
        } else sb.append('T');
            
        if(map.get('C') >= map.get('F')){
            sb.append('C');
        } else sb.append('F');
        
        if(map.get('J') >= map.get('M')){
            sb.append('J');
        } else sb.append('M');
        
        if(map.get('A') >= map.get('N')){
            sb.append('A');
        } else sb.append('N');
        
        return sb.toString();
    }
}