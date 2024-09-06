# <<< we have a string with arrows and we find the maximum number to remove that will point to one location
# print("this is a debug message")

def solution(S):
    counter = 0
    up, down, left, right = 0,0,0,0
    while (counter < len(S)):
        if S[counter] == '^':
            up += 1
        elif S[counter] == 'v':
            down += 1
        elif S[counter] == '<':
            left += 1
        elif S[counter] == '>':
            right += 1
        # print("up " + str(up) + "down " + str(down) + "left "+ str(left) + "right" + str(right))
        counter += 1
    
    return len(S) - max(up, down, left, right)

# print(solution("<<<"))