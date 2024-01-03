def solution(s):
    words = s.split(" ")
    answer_list = []
    
    for r in words:
        if r:
            if (r[0].isdigit()):
                alpha = r[0] + r[1:].lower()
                print(alpha)
                answer_list.append(alpha)
            else:
                a = r[0].upper()
                alpha = a + r[1:].lower()
                print(alpha)
                answer_list.append(alpha)
        else:
            answer_list.append(r)
    
    answer = ' '.join(answer_list)
    print(answer)
    return answer