#344. Reverse String
class Solution:
    def reverseString(self, s: List[str]) -> None:
        s[:] = s[::-1]