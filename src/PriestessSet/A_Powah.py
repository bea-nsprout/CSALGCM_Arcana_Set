def solve(e, t):
    if t == 0:
        return 1
    if t % 2 == 0:
        return pow(solve(e, t//2), 2)  % 10000000
    else:
        return pow(solve(e, t//2), 2)*e  % 10000000


e, t = list(map(int, input().rstrip().split(" ")))
print(solve(e, t))