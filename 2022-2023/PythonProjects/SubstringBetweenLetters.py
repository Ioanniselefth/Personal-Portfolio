def substring_between_letters(word,start,end):
  starti = word.find(start)
  endi = word.find(end)
  if starti > -1 and endi > -1:
    return(word[starti+1:endi])
  return word

print(substring_between_letters("apple", "p", "e"))
# should print "pl"
print(substring_between_letters("apple", "p", "c"))
# should print "apple"
#Write a function named substring_between_letters that takes a string named word, a single character named start, and another character named end. 
# This function should return the substring between the first occurrence of start and end in word. If start or end are not in word, the function should return word.
#For example, substring_between_letters("apple", "p", "e") should return "pl".