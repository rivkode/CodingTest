'''
1. 제거한 0의 zero_count 변수, 회차 정보 초기화
2. 입력값 s에 대해 0의 개수를 zero_count에 더함
3. 0을 공백으로 변환
4. 해당 s를 이진수로 변환
5. s 가 1일때 까지 위를 반복
'''


def solution(s):
    answer = []
    cnt = 0     
    zero_count = 0
    
    #"1"이 남을 때까지 반복
    while True:
        if s == "1":
            break
            
        zero_count += s.count("0")  #문자열의 0의 개수 세기
        s = s.replace("0",'')    #0을 공백으로 변환
        s = bin(len(s))[2:]      #2진수로 변환
        
        cnt +=1
        
    answer = [cnt, zero_count]    
    return answer
    
    
    