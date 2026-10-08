def solution(participant, completion):
    answer = ''
    dic = dict()
    
    for p in participant:
        if p not in dic:
            dic[p] = 1
        else:
            dic[p] +=1
    
    for c in completion:
        if c in dic:
            dic[c] -= 1
    
    for k,v in dic.items():
        if v > 0:
            answer = k
            break
    
    return answer