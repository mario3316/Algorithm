def solution(participant, completion):
    answer = ''
    
    hash = {}
    for i in participant:
        if i in hash:
            hash[i] += 1
        else:
            hash[i] = 1
    # 해시 생성 / 동명이인이 있으면 Value++
    
    for i in completion:
        if hash[i] == 1:
            del hash[i]
        else:
            hash[i] -= 1
    
    # 동명이인이 없는 참가자 Key는 삭제 / 동명이인 있으면 --
    
    answer = list(hash.keys())[0]
    
        
    
    return answer