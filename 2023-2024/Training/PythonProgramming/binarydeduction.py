# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(S):
    value = int(S, 2) # integer value
    counter = 0
    while(value != 0):
        if value %2 == 0:
            value //= 2
        else:
            value -= 1
        counter += 1
    return counter


#print(solution("011100"))
#The code here is to count how many times did the binary got deducted.