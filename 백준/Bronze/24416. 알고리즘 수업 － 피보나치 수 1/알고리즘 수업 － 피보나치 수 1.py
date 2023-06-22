def fib(n): # 재귀 호출 피보나치
    global count1
    if n <=2: return 1
    count1 += 1
    return fib(n-1) + fib(n - 2) # 피보나치 함수를 그대로 다시 호출함으로써 이전 연산들에 대한 내용을 기억하지 않는다

def fibonacci(n): # 동적 프로그래밍 피보나치
    global count2
    f = [1] * (n + 1)
    for i in range(3, n + 1):
        count2 += 1
        f[i] = f[i-1] + f[i-2]
    return f[n] # 피보나치 함수를 for 문을 돌며 카운터를 증가시키므로 재귀호출이 일어나지 않는다

N = int(input())
count1 = 1
count2 = 0

fib(N)
fibonacci(N)
print(count1, count2)