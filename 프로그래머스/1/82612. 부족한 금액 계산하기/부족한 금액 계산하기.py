def solution(price, money, count):
    answer = -1
    res = price * (((count+1)*(count))/2)
    if res > money:
        answer = res - money
    else:
        answer = 0

    return answer