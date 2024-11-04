n, kx, ky = list(map(int, input().rstrip().split(" ")))
people = [list(map(int, input().rstrip().split(" "))) for i in range(n)]
q = int(input().rstrip())

distances = []
for x,y in people:
    distance = abs(x-kx) + abs(y-ky)
    distances.append(distance)

distances.sort()        # sort the distances in ascending order

answers = []
for cc in range(q):
    e = int(input())
    lo = 0
    hi = n
    while lo < hi:
        mid = (lo + hi) //2
        if (distances[mid] <= e):
            lo = mid + 1
        else:
            hi = mid

    answers.append(lo)
    # solve for ans


print("\n".join(list(map(str, answers))))