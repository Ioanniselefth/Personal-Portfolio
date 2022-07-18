def find_short(s):
    temp = s.split()
    counter = 10
    print(temp)
    for i in temp:
        if len(i) < counter:
            counter = len(i)
    return counter
"""
Simple, given a string of words, return the length of the shortest word(s).

String will never be empty and you do not need to account for different data types.

"""