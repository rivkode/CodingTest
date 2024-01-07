
'''
1. people 데이터를 정렬 후 deque()에 넣어준다
2. 순차적으로 가장 작은값과 큰값을 더한 후 limit을 초과하는지 비교한다
3. 만약 초과한다면 가장 큰 값만 빼준다
4. 위 과정을 deque가 없어질때까지 반복한다.
'''
	
from collections import deque

def solution(people, limit):
    people.sort()
    p_deque = deque(people)
    cnt = 0
    
    while p_deque:
        front = p_deque.popleft()
        
        if p_deque:  # p_deque가 비어있지 않을 때에만 pop 수행
            end = p_deque.pop()
            val = front + end

            # 합이 limit을 초과한다면
            # front를 다시 넣어주고, end만 제거한다
            # cnt를 증가시킨다
            # 만약 초과하지 않는다면 모두 제거 후 cnt를 증가시킨다
            if val > limit:
                p_deque.appendleft(front)
        
        cnt += 1
        
    
    return cnt