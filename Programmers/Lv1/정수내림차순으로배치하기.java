import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        
        String str = new String(n + "");
        String[] strArr = str.split("");
        Integer[] intArr = new Integer[strArr.length];
        
        for(int i=0; i<intArr.length; i++){
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        
        Arrays.sort(intArr, Collections.reverseOrder());
        String s = "";
        for(int i=0; i<intArr.length; i++){
            s += intArr[i];
        }
        
        answer = Long.parseLong(s);
        System.out.println(answer.reverseLong());
        
        return answer;
    }
}