def count_char_x(word,x):
  temp = 0
  for i in range(0,len(word)):
    if x == word[i]:
      temp += 1
  return temp


print(count_char_x("mississippi", "s"))
# should print 4
print(count_char_x("mississippi", "m"))
# should print 1
#Write a function named count_char_x that takes a string named word and a single character named x as parameters. 
#The function should return the number of times x appears in word.
