def every_other_letter(word):
  str1 = ""
  for i in range(0,len(word),2):
    str1 += word[i]
  return str1


print(every_other_letter("Codecademy"))
# should print Cdcdm
print(every_other_letter("Hello world!"))
# should print Hlowrd
print(every_other_letter(""))
# should print 
#Create a function named every_other_letter that takes a string named word as a parameter. 
# The function should return a string containing every other letter in word.