import sys
input = sys.stdin.readline

N, M = map(int, input().split())
total = N*M

answer = (N-1) + ((M-1)*N) 

print(answer)
