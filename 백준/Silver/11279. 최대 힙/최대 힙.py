import sys

class maxHeap():

    def __init__(self): # 생성자
        self.data = list()

    def push(self, value): # 새로운 원소를 삽입하는 push
        self.data.append(value)
        now_index = len(self.data) - 1
        while(True): # 부모노드와 비교하며 자식노드가 부모 노드보다 크면 바꿔줌
            parent_index = (now_index - 1) // 2 # 부모 인덱스
            if (parent_index < 0): # 부모 노드 인덱스가 0보다 작다는 것은 원소가 1개인 것
                break


            if (self.data[now_index] <= self.data[parent_index]): # 부모노드가 자식 노드보다 큰 경우는 swap 없이 그대로
                break
            else: # 자식 node 가 부모 node보다 클 경우에만 swap
                self.data[now_index], self.data[parent_index] = self.data[parent_index], self.data[now_index]
                now_index = parent_index


    def pop(self): # Root Node를 제거하는 Pop
        now_index = len(self.data) - 1 # 최하단의 index
        # self.data[0], self.data[now_index] = self.data[now_index], self.data[0] # 최하단, 최우측의 node를 Root로 swap하여 변경
        self.data[0] = self.data[now_index]
        del self.data[now_index] # 기존 Root node 제거
        now_index = 0 # index 0으로 초기화

        while(True): # 자식 node 들과 비교하며 부모노드가 더 작을 경우 더 큰 자식노드와 바꿔줌
            left_child_index = now_index * 2 + 1 # 바로 아래 자식의 왼쪽 노드
            right_child_index = now_index * 2 + 2 # 바로 아래 자식의 오른쪽 노드
            if left_child_index >= len(self.data): # 자식의 오른쪽 노드의 인덱스 위치가 힙 전체 길이보다 크거나 같다면 탈출
                break
            elif len(self.data) < 3: # 길이가 2 이하인 경우 예외처리 해줌
                if self.data[now_index] >= self.data[left_child_index]:
                    break # root node 와 자식 node 를 비교하여 더 큰 값을 root에 설정
                else:
                    self.data[now_index], self.data[left_child_index] = self.data[left_child_index], self.data[now_index]
                    break # root 가 더 작으면 바꾼 후 탈출
            '''자식이 없는 경우'''
            if left_child_index == len(self.data):
                break
            '''왼쪽 자식만 있는 경우'''
            if left_child_index == len(self.data)-1:
                '''왼쪽 자식이 부모보다 더 클 경우 서로 switch'''
                if (self.data[now_index] < self.data[left_child_index]):
                    self.data[now_index], self.data[left_child_index] = self.data[left_child_index], self.data[now_index]
                else:
                    break
            elif (self.data[now_index] >= self.data[left_child_index]) and (self.data[now_index] >= self.data[right_child_index]): # 둘 다 있는 경우
                # 부모 now_index 가 왼쪽 자식보다 크고, 오른쪽 자식보다 클 경우 바로 탈출
                break
            else: # 부모 now_index 가 왼쪽 혹은 오른쪽 자식 둘중 하나보다 작을 경우
                if (self.data[left_child_index] > self.data[right_child_index]): # 왼쪽 자식보다 오른쪽 자식이 작을 경우
                    self.data[now_index], self.data[left_child_index] = self.data[left_child_index], self.data[now_index] # 왼쪽 자식과 부모 를 서로 바꾼다
                    now_index = left_child_index # 현재 index를 왼쪽 자식으로 바꾼다 (while문을 통해 계속 비교하기 위해)
                else: # 왼쪽 자식보다 오른쪽 자식이 클경우
                    self.data[now_index], self.data[right_child_index] = self.data[right_child_index], self.data[now_index] # 부모와 오른쪽 자식을 서로 바꾼다
                    now_index = right_child_index # 현재 인덱스를 오른쪽 자식으로 바꾼다


heap = maxHeap()

n = int(sys.stdin.readline())

command_lst = list()

for i in range(n):
    command_lst.append(int(sys.stdin.readline()))

for j in command_lst:
    if j == 0:
        if len(heap.data) < 1:
            print(0)
        else:
            print(heap.data[0])
            heap.pop()
    else:
        heap.push(j)