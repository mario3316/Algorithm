import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        ArrayList<Integer> L = new ArrayList<>();
        
        int[] day = new int[progresses.length];
        
        for(int i=0; i<progresses.length; i++){
            day[i] = (int)Math.ceil((double)(100 - progresses[i]) / speeds[i]);
        } // 작업 완료 일수 계산
        System.out.println(Arrays.toString(day));

        int current = day[0];
        for(int i=0; i<progresses.length; i++){
            if(day[i] <= current){
                day[i] = current;
            }else{
                current = day[i];
            }
        } // 현재 완료 일수보다 작은 뒤 작업들 덮어쓰기
        System.out.println(Arrays.toString(day));
        
        current = day[0];
        int cnt = 0;
        for(int i=0; i<progresses.length; i++){
            if(day[i] == current){
                cnt++;
            }else{
                current = day[i];
                L.add(cnt);
                cnt = 1;
            }
        } // 같은 일수 카운트해서 List에 넣기
        L.add(cnt); // 마지막꺼
        
        answer = new int[L.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = L.get(i);
        }
        
        return answer;
    }
}