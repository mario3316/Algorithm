class Solution {
    public String solution(String s) {
        String answer = "";
        
        char[] charArr = s.toCharArray();
        int cnt = 0;
        
        for(int i=0; i<charArr.length; i++){
            if(charArr[i] >= 65){ // 단어 시작
                if(cnt % 2 == 0)
                    charArr[i] = Character.toUpperCase(charArr[i]);
                else
                    charArr[i] = Character.toLowerCase(charArr[i]);
                
                cnt++;
            }else{
                cnt = 0;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(char c : charArr){
            sb.append(c);
        }
        
        answer = sb.toString();
        
        return answer;
    }
}