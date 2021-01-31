class Solution {
    static int[][] Keypad = {{1,2,3},{4,5,6},{7,8,9},{10,0,10}};
    static int rLeft, cLeft, rRight, cRight;
    
    public String solution(int[] numbers, String hand) {
        String answer = "";
        return answer;
    }
    
    public static String solve(int[] numbers, String hand){
        String ans = "";
        rLeft = 3;
        cLeft = 0;
        rRight = 3;
        cRight = 2; // 초기 위치
        
        for(int i=0; i<numbers.length; i++){
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                ans += "L";
            }else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                ans += "R";
            } 
        }
    }
    
    public static void changeLocation(int rl, int num){
        if(rl == 0){ // 왼손
            for(int i=0; i<Keypad.length; i++){
                for(int j=0; j<Keypad[i].length; j++){
                    if(Keypad[i][j] == num){
                        
                    }
                }
            }
        }else{ // 오른손
            
        }
    }
}