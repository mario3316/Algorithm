class Solution {
    public String solution(String s, int n) {
        String answer = "";
        //a : 97 ~ z : 122
        //A : 65 ~ Z : 90
        
        char[] charArr = s.toCharArray();
        
        for(int i=0; i<charArr.length; i++){
            if(charArr[i] >= 97 && charArr[i] <= 122){
                int tmp = charArr[i] - 97;
                tmp += n;
                tmp = tmp % 26;
                charArr[i] = (char)(tmp + 97);
            }else if(charArr[i] >= 65 && charArr[i] <= 90){
                int tmp = charArr[i] - 65;
                tmp += n;
                tmp = tmp % 26;
                charArr[i] = (char)(tmp + 65);
            }
        }

        
        answer = new String(charArr);
        return answer;
    }
}