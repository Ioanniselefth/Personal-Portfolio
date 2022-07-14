letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
def unique_english_letters(word):
  letter = []
  for i in word:
    if i in letters and i not in letter:
      letter.append(i)
  return len(letter)


print(unique_english_letters("mississippi"))
# should print 4
print(unique_english_letters("Apple"))
# should print 4
"""
# Write a function called unique_english_letters that takes the string word as a parameter. The function should return the total number of unique letters in the string. Uppercase and lowercase letters should be counted as different letters.

We ve given you a list of every uppercase and lower case letter in the English alphabet. It will be helpful to include that list in your function.
"""