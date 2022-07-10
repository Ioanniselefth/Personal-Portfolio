def introduction(first_name, last_name):
  return last_name+", "+first_name+" "+last_name


print(introduction("James", "Bond"))
# should print Bond, James Bond
print(introduction("Maya", "Angelou"))
# should print Angelou, Maya Angelou
#Write a function named introduction() that has two parameters named first_name and last_name.
#The function should return the last_name, followed by a comma, a space, first_name another space, and finally last_name.