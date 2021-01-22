import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] strArr = s.split("");
        Arrays.sort(strArr, Collections.reverseOrder());
        
        
        answer = String.join("", strArr);
        
        
        return answer;
    }
}