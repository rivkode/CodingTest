# 기본 아이디어
'''
수족관의 최대 넓이를 구하기 위해 투포인터를 사용
만약 모두 동일한 높이였다면 양 끝점을 사용할 것 이므로
양끝점부터 시작해서 높이가 더 높은게 있는지 체크하면서 이동한다
이때 양쪽중 어느지점을 가운데로 이동할지는 둘중 작은 막대를 사용한다
그리고 막대를 이동할때마다 수족관의 넓이를 구하여 기존의 수족관과 비교하여 최대값을 구한다.
'''

'''
sudo

s와 e가 교차할때까지 루프를 돈다
최초로 수족관의 넓이를 구한다.
그리고 s와 e 값을 비교하여 더 작은값의 index를 가운데로 이동시킨다.
그리고 현재 s와 e 값을 사용하여 수족관의 넓이를 구한다
max()를 사용해 수족관의 넓이를 업데이트 한다
'''


class Solution(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """

        s = 0
        e = len(height) - 1
        result = self.calculate_amount(e - s, height[s], height[e])

        while s < e:
            s_val = height[s]
            e_val = height[e]

            if s_val > e_val:
                e -= 1
            else:
                s += 1

            new_result = self.calculate_amount(e - s, height[s], height[e])
            result = max(result, new_result)

        return result

    def calculate_amount(self, weight, s_val, e_val):
        if s_val > e_val:
            result = e_val * weight
            return result
        else:
            result = s_val * weight
            return result
