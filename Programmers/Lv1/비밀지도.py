def ten_to_binary(n, num):
    binary = []
    
    for i in range(n):
        binary.append(num%2)
        num = num//2
    
    binary.reverse()
    return binary

def solution(n, arr1, arr2):
    answer = []
    
    for i in range(n):
        str = ""
        first = ten_to_binary(n, arr1[i])
        second = ten_to_binary(n, arr2[i])
        
        for j in range(n):
            and_result = first[j] | second[j]
            if and_result == 1:
                str += "#"
            else:
                str += " "
        
        answer.append(str)
            
    
    return answer