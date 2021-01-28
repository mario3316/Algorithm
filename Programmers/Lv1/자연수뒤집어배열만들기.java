import java.util.*;

class Solution {
    public int[] solution(long n) {
        int[] answer = {};
        
        String str = Long.toString(n);
        String[] strArr = str.split("");
        List<String> list = Arrays.asList(strArr);
        Collections.reverse(list);
        
        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = Integer.parseInt(list.get(i));
        }
        
        return answer;
    }
}