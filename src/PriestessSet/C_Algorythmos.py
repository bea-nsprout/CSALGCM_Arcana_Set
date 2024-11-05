import math

"""
Takes in the key input values and returns a list of strings containing the 
answers.

Parameters:
n : int - number of pillars
k : int - number of attacks
d_i : array-like - list of shape (k,) containing the damage dealt by each attack
s_i : array_like - list of shape (n,) containing the strength of each pillar

Returns:

list of strings to be printed. For example, if the answer to be printed is:

5
2
0

return ["5","2","0"]
"""
#find the number of elements to the left of e
def binary_search(s_i, e):
    lo = 0
    hi = n
    while lo < hi:
        mid = (lo + hi) // 2
        if s_i[mid] <= e:
            lo = mid + 1
        else:
            hi = mid
    return lo


def solve(n,k,d_i,s_i):
    remaining_pillars = []
    s_i.sort()  # sort in ascending order

    dmg_accumulated = 0
    dead_pillars = 0
    d = 0               #current damage index
    while dead_pillars < n:
        dmg_accumulated += d_i[d]
        dead_pillars = binary_search(s_i, dmg_accumulated)
        remaining_pillars.append(str(n - dead_pillars))

        d+=1
        if d == k:
            d = 0          #to reset it


    return remaining_pillars

n,k = list(map(int,input().strip().split(" ")))
d_i = [int(input()) for i in range(k)]
s_i = [int(input()) for i in range(n)]

print("\n".join(solve(n,k,d_i,s_i)) + "\n")