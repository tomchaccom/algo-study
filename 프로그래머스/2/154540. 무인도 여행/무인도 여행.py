from collections import deque

dx = [0,0,-1,1]
dy = [-1,1,0,0]

def solution(maps):
    answer = []
    
    """
    X 5 9 1 X
    X 1 X 5 X
    X 2 3 1 X
    1 X X X 1
    """
    # 1. X가 아닐때 먼저 BFS로 탐색해도 될듯, DFS도 되고 그러나 하고 나서 합계를 구하도록 하려면.. 뭐가 더 좋을지 고려해보기 
    # maps[i][j] ! =x 일때 BFS 상하좌우를 확인해서 숫자인 경우를 큐에 추가하기
    # visited 배열을 만들어야 하려나? 
    # BFS는 섬의 체류 기간 합계를 반환하면 이걸 결과 배열에 넣으면 될듯
    # 섬 자체가 존재하지 않을 경우에는 -1 반환 answer 값이 0이면 된다. 
    # 100 곱하기 100 의 사이즈. 완탐 10000 번 연산 * BFS 연산량(? 이건 알아보기)
    
    
    # 직사각형 형태라서 먼저 가로, 세로 길이 저장하기 
    N = len(maps) # 요게 세로 길이 
    M = len(maps[0]) # 이게 가로
    

    # 1. 방문 배열 만들기 
    visited = [[False] * M  for _ in range(N)]
    # print(visited)
    # 2. BFS를 호출하는 반복문 만들기 
    
    print(N,M)
    for i in range(N):
        for j in range(M):
            if visited[i][j]: continue
            if maps[i][j] == "X": continue
            answer.append(bfs(i,j,visited, N, M, maps))
    
    if len(answer) == 0:
        answer.append(-1)
    
    return sorted(answer)

def bfs(x, y, visited, n, m, maps):
    # 1. 방문 처리 
    food = 0
    que = deque()
    que.append((x,y))
    visited[x][y] = True
    
    while(que):
        cx, cy = que.popleft()
        food += int(maps[cx][cy])
        
        for i in range(4):
            tx = cx + dx[i]
            ty = cy + dy[i]
            
            # 범위를 벗어났을 경우. 탐색 중지 
            if tx < 0 or ty < 0 or tx >= n or ty >= m: continue
            
            # 바다일 경우 탐색 중지 
            if maps[tx][ty] == "X": continue

            # 방문했을 경우 중지 
            if visited[tx][ty]: continue

            # 아니라면 큐에 넣기 그리고 현재 위치의 식량값 저장하기 
            que.append((tx,ty))
            visited[tx][ty] = True
            
        
    return food
    