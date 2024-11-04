"""
~3 hours because python is stupid
hackerrank doesn't want to accept recursion more than 1000 times
hackerrank also called for abort on this... but moving on now
"""

fibo = []
def dp_fibonacci(n):
    for i in range(n):
        if i == 0 or i == 1:
            fibo.append(1)
        else:
            fibo.append(fibo[i - 1] + fibo[i - 2])

def solve(n,k):
    # solve problem here. Return correct answer
    while n > 1:
        if k < fibo[n - 2]:  # in first half
            n -= 2
        else:
            k -= fibo[n-2]
            n -= 1

    if n == 0:
        return "H"
    elif n == 1:
        return "A"


n, k = list(map(int,input().rstrip().split(" ")))
dp_fibonacci(n)

print(solve(n,k))