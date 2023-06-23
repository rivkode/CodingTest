import sys

pipe = list(map(str, sys.stdin.readline().rstrip()))

stack = []

result = 0 # 결과 값

for idx, p in enumerate(pipe):

    if p == "(":
        stack.append(p)
    elif pipe[idx-1] == ")": # 입력이 ) 이면서, 이전 값이 ) 일경우 막대기가 하나 끊긴것이므로 stack에서 pop, 결과에 1을 더해줌
        stack.pop()
        result += 1
    else: # 입력이 ) 이면서, 이전 값이( 일 경우 ()가 되어 레이저를 의미하므로 stack에서 pop, stack 수 만큼 값을 더해준다
        stack.pop()
        result += len(stack)

print(result)
