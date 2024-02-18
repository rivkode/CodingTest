'''
capacity - 포켓몬을 가질 수 있는 최대 개수
dupication_remove_num - 포켓몬 종류의 중복을 제거한 수
'''

def solution(nums):
    capacity = len(nums) // 2
    s = set(nums)
    duplication_remove_num = len(s)
    
    if duplication_remove_num < capacity:
        answer = duplication_remove_num
    else:
        answer = capacity
    
    return answer