def reverse_string(word):
  #return word[::-1]
  j = len(word)-1
  str1 = ""
  while j>=0:
    str1 += word[j]
    j -= 1
  return str1  

print(reverse_string("Codecademy"))
# should print ymedacedoC
print(reverse_string("Hello world!"))
# should print !dlrow olleH
print(reverse_string(""))
# should print
#Write a function named reverse_string that has a string named word as a parameter. 
# The function should return word in reverse.