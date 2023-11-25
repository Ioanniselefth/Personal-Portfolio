#Implementation of Binary Search Algorithm
#Basic search: Scan entire list 
#Ask if its equal to the target
#If yes return index 
#If not return -1

def BasicSearch(lst,target):
    for i in range(0,len(lst)):
        if lst[i] == target :
            return i
    return -1

#Binary search uses divide and conquer
#sorted list
def BinarySearch(lst, target, low = 0, high=None):
    if high is None:
        high = len(lst)-1
    #If you did not find it 
    if high < low:
        return -1

    #find the middle of the list 
    Mid = len(lst) //2

    if lst[Mid] == target:
        return Mid
    elif target < lst[Mid]:
        return BinarySearch(lst, target, low, Mid-1)
    else:
        #target > bigger
        return BinarySearch(lst, target, Mid+1 ,high)

list1 = [1,2,3,6,10,12]
target = 10
print(BasicSearch(list1, target))
print(BasicSearch(list1, target))