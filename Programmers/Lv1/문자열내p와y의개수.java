class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        int len = s.length();
        s = s.toLowerCase();
        int n = 0;
        
        for(int i=0; i<len; i++){
            if(s.charAt(i) == 'p')
                n++;
            if(s.charAt(i) == 'y')
                n--;
        }
    
        if(n != 0)
            answer = false;
        
        return answer;
    }
}