import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        ArrayList<Integer> cnt = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i=0; i<progresses.length; i++){
            int day = (int)Math.ceil((double)(100 - progresses[i]) / speeds[i]);
            // 작업 완료 일수 계산
            
            if(!cnt.isEmpty() && cnt.get(0) < day){
                ans.add(cnt.size());
                cnt.clear();
            }
            
            cnt.add(day);
        }
        ans.add(cnt.size()); // 마지막 세트는 따로
        
        answer = new int[ans.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
}