import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String s = Integer.toString(n);
        String[] strArr = s.split("");
        
        for(int i=0; i<strArr.length; i++){
            answer += Integer.parseInt(strArr[i]);
        }
        
        return answer;
    }
}