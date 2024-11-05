import math

def f(n):
    return int(math.ceil(n * math.log2(n) / 1e8))       #old: forgot to cast to int


def compute_ans(t):         # t= time limit
    lo = 0
    hi = int(1e18)          # old: t, but t is the goal lol

    while lo < hi:          #old: lo <= hi, idk why it's wrong
        mid = (lo + hi) // 2
        if f(mid) <= t:
            lo = mid + 1
        else:
            hi = mid

    return lo -1

# compute for and return answer here


t = int(input())
print(compute_ans(t))