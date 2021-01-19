import java.util.*;

class Solution {
    
    public static boolean isDivided(int num, int divisor){
        if(num % divisor == 0)
            return true;
        else
            return false;
    }
    
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        int count = 0;
        
        for(int i=0; i<arr.length; i++){
            if(isDivided(arr[i], divisor))
               count++;
        }
        
        if(count == 0){
            answer = new int[1];
            answer[0] = -1;
        }else{
            answer = new int[count];
            count = 0;
               
            for(int i=0; i<arr.length; i++){
                if(isDivided(arr[i], divisor)){
                    answer[count++] = arr[i];
                }
            }
            
            Arrays.sort(answer);
        }

        return answer;
    }
}