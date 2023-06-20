'''
언제든지 왼쪽 카드만 통에 버릴 수 있고 왼쪽 카드와 오른쪽 카드를 둘 다 통에 버릴 수도 있다
이때 얻는 점수는 없다
오른쪽 카드에 적힌 수가 왼쪽 카드에 적힌 수보다 작은 경우에는 오른쪽 카드만 통에 버릴 수도 있다
오른쪽 카드만 버리는 경우에만 오른쪽 카드에 적힌 수만큼 점수를 얻는다
'''


import sys
sys.setrecursionlimit(10**6)

def dfs(x, y):
  if x >= n or y >= n:
    return 0

  if dp[x][y] != -1: # dp[x][y] 에서 값이 -1 이면 빈 값이므로 비교 시작
    return dp[x][y] # -1이 아니면 이미 계산된 값이므로 해당 배열값 그대로 반환

  if left[x] > right[y]: # 점수를 획들할 경우
    # 오른쪽 값이 더 작을 경우 오른쪽 값을 버리고 점수 획득
    dp[x][y] = dfs(x, y+1) + right[y]  # 오른쪽 버리기
  else: # 점수를 획득하지 못할 경우
    # 왼쪽을 버릴까, 오른쪽을 버릴까
    discard_left = dfs(x+1, y)
    discard_both = dfs(x+1, y+1)
    dp[x][y] = max(discard_left, discard_both)  # max(왼쪽 버리기, 둘 다 버리기)

  return dp[x][y]


if __name__ == "__main__":
  n = int(input())
  left = list(map(int, sys.stdin.readline().rstrip().split()))
  right = list(map(int, sys.stdin.readline().rstrip().split()))

  dp = [[-1 for _ in range(n)] for _ in range(n)]
  dfs(0, 0)
  print(dp[0][0])


