# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
#876. Middle of the linked list
class Solution876:
    def middleNode(self, head: Optional[ListNode]) -> Optional[ListNode]:
        arr = [head]
        while arr[-1].next:
            arr.append(arr[-1].next)
        return arr[len(arr)//2]