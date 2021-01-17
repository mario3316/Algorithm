def ten_to_three(n):
    num = []
    
    while True:
        if n < 3:
            num.append(n)
            break
        else:
            num.append(n%3)
            n = n//3
    
    return num
        

def solution(n):
    answer = 0
    
    num = ten_to_three(n)
    num.reverse()

    for i in range(len(num)):
        answer += num[i] * (3**i)
    
    
    return answer