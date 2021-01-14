def solution(numbers):
    answer = []
    
    l = len(numbers)
    
    for i in range(0, l):
        for j in range (i+1, l):
            sum = numbers[i] + numbers[j]
            if sum not in answer:
                answer.append(sum)
    
    answer.sort()
    
    return answer