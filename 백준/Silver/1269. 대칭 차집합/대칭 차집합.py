import sys


class Node:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

class BinarySeachTree:
    def __init__(self, root):
        self.root = root

    def insert(self, value):
        # current_node = 루트 노드로 초기화
        self.current_node = self.root
        while True:
            # 삽입 value가 루트 노드보다 작다면
            if value < self.current_node.value:
                # 루트 노드의 왼쪽 자식노드가 있는지 여부를 확인한다
                if self.current_node.left != None:
                    # 있으면 value를 다시 비교해야 하므로 current_node를 left로 갱신한다
                    self.current_node = self.current_node.left
                else:
                    # 없다면 insert value를 노드로 넣어준다
                    self.current_node.left = Node(value)
                    break
            else:
                # 삽입 value가 루트 노드보다 크다면
                # 루트 노드의 오른쪽 자식 노드 여부를 확인한다
                if self.current_node.right != None:
                    # 오른쪽 자식이 있다면 current_node를 갱신한다
                    self.current_node = self.current_node.right
                else:
                    # 없다면 insert value를 노드로 넣어준다
                    self.current_node.right = Node(value)
                    break

    def search(self, value):
        # 루트 노드부터 탐색 시작
        # current_node를 초기화
        self.current_node = self.root
        # current_node 가 있을때 까지
        # 최초로 root의 자식 노드를 None으로 설정했으므로 None을 만나면 탈출
        while self.current_node:
            # 찾은 현재 노드 value가 찾고자 하는 노드의 value와 같다면 True 반환
            if self.current_node.value == value:
                return True
            # 찾은 현재 노드 value가 찾고자 하는 노드의 value 보다 크다면 (찾고자 하는 value가 현재 노드보다 작은경우)
            # 왼쪽 자식 node 로 current_node 초기화
            # 왜냐하면 찾고자 하는 value가 현재 노드보다 작기때문에
            # 부모 노드보다 작은 값을 가진 노드들은 이진탐색트리에서 항상 왼쪽 subTree에 있으므로
            elif self.current_node.value > value:
                self.current_node = self.current_node.left
            else:
                # 동일한 이유로찾고자 하는 노드의 value보다 작다면 (찾고자 하는 value가 현재 노드보다 클 경우)
                # 오른쪽 node로 current_node 초기화
                self.current_node = self.current_node.right
        # 원하는 결과가 없을때 False 반환
        # current_node가 None을 만날 경우 return False가 됨됨
        return False

    def delete(self, value):
        # 삭제할 노드가 있는지 검사하고 없으면 False리턴
        # 검사를 한 후에는 삭제할 노드가 current_node, 삭제할 노드의 부모 노드가 parent가 된다.
        is_search = False
        self.current_node = self.root
        self.parent = self.root
        while self.current_node:
            if self.current_node.value == value:
                is_search = True
                break
            elif value < self.current_node.value:
                self.parent = self.current_node
                self.current_node = self.current_node.left
            else:
                self.parent = self.current_node
                self.current_node = self.current_node.right
        if is_search == False:
            return False

        # 삭제할 노드가 자식 노드를 갖고 있지 않을 때
        if self.current_node.left == None and self.current_node.right == None:
            if value < self.parent.value:
                self.parent.left = None
            else:
                self.parent.right = None

        # 삭제할 노드가 자식 노드를 한 개 가지고 있을 때(왼쪽 자식 노드)
        if self.current_node.left != None and self.current_node.right == None:
            if value < self.parent.value:
                self.parent.left = self.current_node.left
            else:
                self.parent.right = self.current_node.left

        # 삭제할 노드가 자식 노드를 한 개 가지고 있을 때(오른쪽 자식 노드)
        if self.current_node.left == None and self.current_node.right != None:
            if value < self.parent.value:
                self.parent.left = self.current_node.right
            else:
                self.parent.right = self.current_node.right

                # 삭제할 노드가 자식 노드를 두 개 가지고 있을 때
        if self.current_node.left != None and self.current_node.right != None:
            self.change_node = self.current_node.right
            self.change_node_parent = self.current_node.right
            while self.change_node.left != None:
                self.change_node_parent = self.change_node
                self.change_node = self.change_node.left
            if self.change_node.right != None:
                self.change_node_parent.left = self.change_node.right
            else:
                self.change_node_parent.left = None

            if value < self.parent.value:
                self.parent.left = self.change_node
                self.change_node.right = self.current_node.right
                self.change_node.left = self.current_node.left
            else:
                self.parent.right = self.change_node
                self.change_node.left = self.current_node.left
                self.change_node.right = self.current_node.right

        return True


N, M = map(int, sys.stdin.readline().rstrip().split())

A = list(map(int, sys.stdin.readline().rstrip().split()))
B = list(map(int, sys.stdin.readline().rstrip().split()))


# 루트노드 인덱스
root_Node_Index = None
SearchList = None
BinaryST = None

# 검색 원소 리스트

if N <= M:
    # 검색 원소 리스트 A로 설정
    SearchList = A
    # BST 를 B로 설정
    BinaryST = B
    # 중앙 값으로 root 설정
    root_Node_Index = int(M/2)
    root = Node(B[root_Node_Index])
    BST = BinarySeachTree(root)

else:
    SearchList = B
    BinaryST = A
    root_Node_Index = int(N/2)
    root = Node(A[root_Node_Index])
    BST = BinarySeachTree(root)


for i in BinaryST:
    BST.insert(i)

cnt = 0

for j in SearchList:
    if BST.search(j):
        cnt += 1

# 차집합의 합은 A + B - (교집합 *2)
result = N + M - (2*cnt)

print(result)

