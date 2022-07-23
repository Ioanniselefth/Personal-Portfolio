def firstUniqChar(s) -> int:
    for i in range(0,len(s)):
        temp = 0
        for j in range(i+1,len(s)):
            if s[i] == s[j]:
                temp = 1
        for x in range(0,i):
            if s[i] == s[x]:
                temp = 1
        if temp == 0:
            return i
    return -1

"""
387. First Unique Character in a String
Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

Example 1:

Input: s = "leetcode"
Output: 0
Example 2:

Input: s = "loveleetcode"
Output: 2

Example 3:

Input: s = "aabb"
Output: -1
"""

print(firstUniqChar('leetcode'))
print(firstUniqChar('loveleetcode'))
print(firstUniqChar('aabb'))