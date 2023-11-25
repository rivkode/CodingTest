def solution(x):
    answer = True
    
    s = str(x)
    total = 0
    
    for i in range(len(s)):
        total += int(s[i])
    
    if (x % total) != 0:
        answer = False
    
    
    return answer