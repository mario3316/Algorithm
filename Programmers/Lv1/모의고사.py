def solution(answers):
    answer = []
    
    result = [0,0,0]
    one = [1,2,3,4,5]  #5개 
    two = [2,1,2,3,2,4,2,5] #8개
    three = [3,3,1,1,2,2,4,4,5,5] #10개
    
    
    l = len(answers)
    for i in range(l):
        if answers[i] == one[i%5]:
            result[0] += 1
        if answers[i] == two[i%8]:
            result[1] += 1
        if answers[i] == three[i%10]:
            result[2] += 1
            
    for i,value in enumerate(result):
        if value == max(result):
            answer.append(i+1)
        
    return answer