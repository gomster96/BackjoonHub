import java.util.*;
class Solution {
    public int solution(int[] q1, int[] q2) {
        int answer = -2;
        long leftSum = 0;
        long rightSum = 0;
        int[] arr = new int[q1.length + q2.length];
        for(int i=0; i<q1.length; i++){
            arr[i] = q1[i];
            leftSum += arr[i];
        }
        for(int i=q1.length; i<arr.length; i++){
            arr[i] = q2[i-q1.length];
            rightSum += arr[i];
        }
        
        int lp = 0;
        int rp = q1.length;
        boolean chL = false;
        boolean chR = false;
        boolean leftM = false;
        boolean rightM = false;
        int cnt = 0;
        while(!(chL && chR)){
            
            if(chL && chR){
                return -1;
            }
            
            if(leftSum == rightSum){
                break;
            } else if(leftSum > rightSum){
                leftSum -= arr[lp];
                rightSum += arr[lp];
                lp++;
                if(lp >= arr.length){
                    chL = true;
                    lp = 0;
                }
            } else {
                rightSum -= arr[rp];
                leftSum += arr[rp];
                rp++;
                if(rp >= arr.length){
                    rp = 0;
                }
                if(rp == q1.length){
                    chR = true;
                }
            }
            // System.out.println("leftSUm : " + leftSum + " rightSum: " + rightSum);
            cnt++;
        }
        if(chL && chR) return -1;
        return cnt;
    }
}