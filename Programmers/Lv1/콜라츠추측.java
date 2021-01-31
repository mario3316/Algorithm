class Solution {
    public int solution(int num) {
        int answer = 0;
        long n = num;
        
        while(answer < 500){
            if(n == 1)
                return answer;
            if(n % 2 == 0){
                n = n / 2;
            }else{
                n = n * 3 + 1;
            }
            answer++;
        }
        
        return -1;
    }
}