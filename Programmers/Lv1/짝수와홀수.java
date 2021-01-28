class Solution {
    public String solution(int num) {
        String answer = "";
        
        if(num%2 == 0){
            answer = new String("Even");
        }else{
            answer = new String("Odd");
        }
        
        return answer;
    }
}