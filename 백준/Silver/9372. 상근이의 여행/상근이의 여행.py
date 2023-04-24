import sys

# 깊이 우선 탐색
def DFS(node, cnt):
    # 노드 방문 표시
    visited[node] = 1
    # 해당 노드와 인접한 노드를 모두 방문하는 for loop 문
    for adj_node in graph[node]:
        # 만약 노드를 방문하지 않았다면
        if visited[adj_node] == 0:
            # 해당 노드 DFS 탐색 시작
            cnt = DFS(adj_node, cnt+1)
    return cnt

t = int(sys.stdin.readline())

for _ in range(t):
    # 국가수 N, 비행기 수 M
    N, M = map(int, sys.stdin.readline().split())

    # 이차원 배열 Tree
    graph = [[] for _ in range(N+1)]
    # 방문
    visited = [0] * (N+1)

    # 비행기 수 만큼 반복
    for _ in range(M):
        a, b = map(int, sys.stdin.readline().split())
        # a 번째 리스트에 노드 b 추가
        graph[a].append(b)
        # b 번째 리스트에 노드 a 추가
        graph[b].append(a)
        # 이렇게 서로 append를 하게 되면 서로의 리스트에 추가되어 연결의 의미를 갖는다다
    print(DFS(1, 0))