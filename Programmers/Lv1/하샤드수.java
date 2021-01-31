class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        String str = Integer.toString(x);
        int total = 0;
        
        for(int i=0; i<str.length(); i++){
            total += Character.getNumericValue(str.charAt(i));
        }
        
        if(x % total == 0)
            answer = true;
        else
            answer = false;
        
        return answer;
    }
}