from collections import deque
import sys
input = sys.stdin.readline

#함수로 만들기
#전처리
#input, 과정, output 순으로 만들자


def dfs(graph, v, visited):
    visited[v] = True
    print(v, end=" ")
    for i in graph[v]:
        if not visited[i]:
            dfs(graph, i, visited)


def bfs(graph, start, visited):
    queue = deque([start])
    visited[start] = True
    while queue:
        v = queue.popleft()
        print(v, end=' ')
        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True

N, M, V = (map(int, input().split()))

graph = [[] for _ in range(N+1)]

for _ in range(M):
    a, b = map(int, (input().split()))
    graph[a].append(b)
    graph[b].append(a)
    graph[a].sort()
    graph[b].sort()


visited = [False] * (N+1)
dfs(graph, V, visited)
visited = [False] * (N+1)
print()
bfs(graph, V, visited)