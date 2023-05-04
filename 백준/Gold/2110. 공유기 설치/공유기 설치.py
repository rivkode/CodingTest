import sys

N, C = map(int, sys.stdin.readline().split())
houses = [int(sys.stdin.readline()) for _ in range(N)]
houses.sort() # O(NlogN)


def is_valid(x): # x가 유효한지 판별, O(N)
    last_idx, c = 0, C - 1
    while c > 0:
        next_val = houses[last_idx] + x
        idx = last_idx
        while houses[idx] < next_val: # x만큼 계속 더함
            idx += 1
            if idx == len(houses): # 이 조건문을 안타고 idx를 계속 더했음에도 불구하고 next_val가 크다고 하면 고를 수 있는 값임
                return False
        c -= 1 # 현재 idx에 공유기를 하나 놓을 수 있다는 의미
        last_idx = idx
    return True

answer = 1 # 문제 조건에서 1은 보장하므로, 거리를 1로 준수하면서 놓는것은 항상 가능함
L, R = 1, houses[-1] - houses[0] # R도 후보군에 포함 ?

while L <= R: # 최대 30, O(logN) 이므로, = 는 L과 R의 중복 조건을 피하기 위해
    mid = (L + R) // 2
    if is_valid(mid): # mid가 유효하다면 1씩 증가하며 answer을 최댓값으로 갱신
        answer = max(answer, mid)
        L = mid + 1 # mid가 3이었을때 mid가 3보다 작은 값에 대해서는 항상 valid함
        # 그러므로 이미 판정을 받은 mid가 아닌 mid + 1에 대해서 진행해야 함
    else:
        R = mid - 1

print(answer)