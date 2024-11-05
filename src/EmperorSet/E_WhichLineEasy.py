"""
Solves a test case

Parameters:
n    : int        - number of station levels
k    : int        - cost to transfer to the other line
vals : array-like - array of shape (n,2) containing the finishing times for each
                    station at each assembly line
"""
def solve(n,k,vals):
    mincost = [[0, 0] for _ in range(n)]

    for i in range(n):
        if i == 0:
            mincost[0][0] = vals[0][0]
            mincost[0][1] = vals[0][1]
        else:
            for c in range(2):
                stay = mincost[i-1][c]
                switch = mincost[i-1][(c+1)%2] + k

                mincost[i][c] = min(stay, switch) + vals[i][c]

    return min(mincost[n-1][0], mincost[n-1][1])


n, k = list(map(int,input().rstrip().split(" ")))
vals = []
for i in range(n):
    vals.append(list(map(int,input().rstrip().split(" "))))
print("{}".format(solve(n,k,vals)))