'''
1. 스택 생성
2. '('가 들어오면 스택에 push
3. ')'가 들어오면 '('를 스택에서 pop
4. 위 과정을 모든 입력에 대해서 반복한다
5. 모든 입력이 끝났을때 스택이 비었을 경우 True, 아닐경우 false를 반환한다
'''

def solution(s):
    answer = True
    stack = []
    # 괄호 리스트를 만듦
    lst = list(s)
    
    # in을 사용하여 원소를 하나씩 호출
    for b in lst:
        if b == "(":
            stack.append(b)
        elif b == ")":
            # 스택이 빌 경우 pop을 하면 False를 반환
            if not stack:
                return False
            stack.pop()
    
    if stack:
        answer = False

    return answer