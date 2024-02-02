a, b, c, d, e, f = map(int, input().split())


# 연립방정식 계산을 위한 행렬식
# 정수부분을 가져오기 위해 몫 반환
print((c*e-b*f)//(a*e-b*d), (a*f-d*c)//(a*e-b*d))