def solution(n, lost, reserve):
    answer = 0
    
    new_reserve = set(reserve) - set(lost)
    new_lost = set(lost) - set(reserve)

    
    for i in new_lost:
        if i+1 in new_reserve:
            new_reserve.remove(i+1)
        elif i-1 in new_reserve:
            new_reserve.remove(i-1)
        else:
            n -= 1
    
    answer = n
    return answer