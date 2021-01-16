def solution(a, b):
    answer = ''
    
    days = ["FRI", "SAT", "SUN","MON", "TUE", "WED", "THU"]
    months = [30,29,31,30,31,30,31,31,30,31,30,31]
    
    gap = 0
    if a != 1:
        for i in range(a-1):
            gap += months[i]
        gap += b
    else:
        gap = b - 1
    
    answer = days[gap % 7]
    
    return answer