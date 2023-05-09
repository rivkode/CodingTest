import sys

def multiple(n, m):
    num = str(m)
    num1 = int(num[2]) # 1의 자리
    num2 = int(num[1]) # 10의 자리
    num3 = int(num[0]) # 100의 자리


    result1 = n * num1
    result2 = n * num2
    result3 = n * num3

    result = result1 + (result2 * 10) + (result3 * 100)
    
    print(result1)
    print(result2)
    print(result3)
    print(result)

    return "SUCCESS"

n = int(sys.stdin.readline())

m = int(sys.stdin.readline())


multiple(n, m)


