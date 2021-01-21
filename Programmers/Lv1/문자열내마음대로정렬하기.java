import java.util.*;

class Solution {
    
    static char[] charArr;
     
    public String[] solution(String[] strings, int n) {
        String[] answer = {};
        answer = new String[strings.length];
        charArr = new char[strings.length];
        
        Arrays.sort(strings);
        
        for(int i=0; i<strings.length; i++){
            charArr[i] = strings[i].charAt(n);
        }
        
        Arrays.sort(charArr);
        
        for(int i=0; i<charArr.length; i++){
            char c = charArr[i];
            
            for(int j=0; j<strings.length; j++){
                if(strings[j] != "" && c == strings[j].charAt(n)){
                    answer[i] = strings[j];
                    strings[j] = "";
                    break;
                }
            }
        }
        

        return answer;
    }
}