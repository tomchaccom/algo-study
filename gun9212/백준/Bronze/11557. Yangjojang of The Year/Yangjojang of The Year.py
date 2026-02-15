import sys
input = sys.stdin.readline

T = int(input())
school = ""
i = 0

for _ in range (T):
    N = int(input())
    for _ in range (N):
        S, L = input().split()
        L = int(L)
        if(L > i):
            i=L
            school=S
    print(school)