# We have number with 5 always there and we find the maximum one that will have 5 there
# print("this is a debug message")

def solution(N):
    num_str = str(N)
    posibilities = []
    
    for i in range(len(num_str)):
        if num_str[i] == '5':
            result = ""
            for j in range(len(num_str)):
                if j != i:
                    result += num_str[j]
            posibilities.append(int(result))
    
    return max(posibilities)