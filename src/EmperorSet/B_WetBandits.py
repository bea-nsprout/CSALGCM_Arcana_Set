
"""
50mins
"""
def solve(n, k, vals):
    maxloot = []
    for i in range(n):
        if i == 0:      #if edge
            #steal
            maxloot.append(vals[i])
        elif i - k <= 0:   #if almost edge
            #can either steal or skip
            steal = vals[i]
            skip = maxloot[i - 1]       #old: didnt realize u can skip when almost edge but not edge

            if steal > skip:
                maxloot.append(steal)
            else:
                maxloot.append(skip)
        elif i - k > 0:
            #can either steal of skip
            steal = vals[i] + maxloot[i-k-1]
            skip = maxloot[i-1]

            if steal > skip:
                maxloot.append(steal)
            else:
                maxloot.append(skip)


    return maxloot[n-1]


n, k = list(map(int, input().rstrip().split(" ")))
vals = []

for i in range(n):
    vals.append(int(input().rstrip()))
print("{}".format(solve(n, k, vals)))