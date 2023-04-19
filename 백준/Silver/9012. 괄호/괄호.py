n = int(input())
for i in range(n):

    PS = input()
    stack = []
    check = True

    for i in range(0, len(PS)):
        if PS[0] == ")":
            check = False
            break
        if PS[i] == ")":
            if len(stack) == 0:
                check = False
                break

            if stack[-1] != "(":
                check = False
                break
            stack.pop()
        else:
            stack.append(PS[i])

    if len(stack) != 0:
        check = False

    result = None

    if check:
        result = "YES"
    else:
        result = "NO"

    print(result)

