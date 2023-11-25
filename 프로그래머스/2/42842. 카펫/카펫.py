def solution(brown, yellow):
    answer = []
    v = 0
    
    for i in range(1, yellow + 1):
        if (yellow % i) == 0:
            v = (yellow / i)
            if v >= i:
                if ((v+2) * 2) + (i * 2) == brown:
                    answer = [v+2, i+2]
    
    
    return answer