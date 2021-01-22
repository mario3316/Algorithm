class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        
        char[] charArr = s.toCharArray();
        
        if(charArr.length != 4 && charArr.length != 6)
            return false;
        else{
            for(int i=0; i<charArr.length; i++){
                if((int)charArr[i] >= 97){
                    System.out.println("###");
                    return false;
                }
            }
        }
        
        return answer;
    }
}