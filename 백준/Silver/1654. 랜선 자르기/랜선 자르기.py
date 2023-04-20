import sys

# 입력값
k, n = map(int, sys.stdin.readline().split(" "))


line = list()
for i in range(k):
    line.append(int(input()))

start = 1
# 최대값 초기화
end = max(line)

# start 와 end 를 비교하여 start가 더 크다면 while문 탈출
# start가 같거나 더 크다는 의미는 start와 end가 서로 만났다는 것
while start <= end:
    # mid는 start와 end의 중간 값
    mid = (start + end) // 2
    lines = 0

    for i in line:
        lines = lines + i//mid
    # line 개수가 필요한 n 개 보다 많을경우 = line이 더 여유롭다는 의미
    if lines >= n:
        # start의 값을 상승한다
        start = mid + 1
    else:
        # end 값을 줄인다
        end = mid - 1

print(end)

