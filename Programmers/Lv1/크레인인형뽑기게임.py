def solution(board, moves):
    answer = 0
    bucket = []
    board_len = len(board)
    
    for i in range(len(moves)):
        j = 0
        move = moves[i] - 1  #이번 움직임 받아오기
            
        for j in range(board_len):
            if board[j][move] != 0 and j != board_len:  # 해당 줄에서 0이 아닐때 까지 이동
                pick = board[j][move] # 뽑기
                board[j][move] = 0  # 뽑았으면 0으로 초기화
                
                if bucket:
                    if pick == bucket[-1]: # 바구니 맨 위와 같으면 터짐
                        answer = answer + 2
                        del(bucket[-1])
                    else:
                        bucket.append(pick) # 바구니에 삽입
                else:
                    bucket.append(pick) # 바구니에 삽입     
                
                break
    
        
    return answer