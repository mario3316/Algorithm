import java.util.*; 

class Solution {
    static int[][] Keypad = {{1,2,3},{4,5,6},{7,8,9},{10,0,10}};
    static int rLeft, cLeft, rRight, cRight;
    
    public String solution(int[] numbers, String hand) {
        String answer = "";
        answer = solve(numbers, hand);
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
                changeLocation(0, numbers[i]);
            }else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                ans += "R";
                changeLocation(1, numbers[i]);
            }else{ // 2 5 8 0
                for(int j=0; j<4; j++){
                    if(numbers[i] == Keypad[j][1]){
                        int rDist = Math.abs(rRight - j) + Math.abs(cRight - 1);
                        int lDist = Math.abs(rLeft - j) + Math.abs(cLeft - 1);
                        if(rDist > lDist){
                            ans += "L";
                            changeLocation(0, numbers[i]);
                        }else if(rDist < lDist){
                            ans += "R";
                            changeLocation(1,numbers[i]);
                        }else{
                            if(hand.equals("left")){
                                ans += "L";
                                changeLocation(0, numbers[i]);
                            }else{
                                ans += "R";
                                changeLocation(1, numbers[i]);
                            }
                        }
                    }
                }
            }
        }
        
        System.out.println(ans);
        return ans;
    }
    
    public static void changeLocation(int rl, int num){
        if(rl == 0){ // 왼손
            for(int i=0; i<Keypad.length; i++){
                for(int j=0; j<Keypad[i].length; j++){
                    if(Keypad[i][j] == num){
                        rLeft = i;
                        cLeft = j;
                        return;
                    }
                }
            }
        }else{ // 오른손
            for(int i=0; i<Keypad.length; i++){
                for(int j=0; j<Keypad[i].length; j++){
                    if(Keypad[i][j] == num){
                        rRight = i;
                        cRight = j;
                        return;
                    }
                }
            }
        }
    }
}