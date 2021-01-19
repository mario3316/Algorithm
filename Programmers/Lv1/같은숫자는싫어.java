import java.util.*;

public class Solution {
    static int flag;
    
    public int[] solution(int []arr) {
        int[] answer = {};
        List<Integer> list = new ArrayList<Integer>();
        
        flag = arr[0];
        list.add(arr[0]);
        
        for(int i=0; i<arr.length; i++){
            if(arr[i] != flag){
                list.add(arr[i]);
                flag = arr[i];
            }
        }

        answer = new int[list.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = list.get(i).intValue();
        }

        return answer;
    }
}