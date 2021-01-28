import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;

        double sqr = Math.sqrt(n);
        String s = new String(sqr + "");
        
        if(s.charAt(s.length()-1) == '0' && s.charAt(s.length()-2) == '.'){
            answer = ((long)sqr+1) * ((long)sqr+1);
        }else{
            answer = -1;
        }
        
        return answer;
    }
}