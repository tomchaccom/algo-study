

def solution(n, computers):
    
    # 길이 
    clen = len(computers)
    count = 0; 
    
    # 1. 인접 그래프 만들기 
    graph = [[] for _ in range(clen)]
    
    # 2. 방문 배열 만들기 
    visited = [False for _ in range(clen)] 
    print(visited)
    
    # 3. 인접 그래프 채우기 
    # 얘를 잘못 만들었다. 
    for i in range(clen):
        for j in range(clen):
            if i == j : continue
            if computers[i][j] == 1:
                graph[i].append(j)
    
    print(graph)
    # 3. 그래프를 순회하면서 주소를 dfs로 전달하기 
    
    for i in range(clen):
        if visited[i] == True: continue
        
        dfs(i, visited, graph)
        count += 1;
        
    return count

def dfs(start, visited, graph):
    visited[start] = True
    
    print("방문하기", start)
    for next in graph[start]:
        # 이미 방문했다면 가지 말기 
        if visited[next]: continue 
        
        dfs(next,visited, graph)
        