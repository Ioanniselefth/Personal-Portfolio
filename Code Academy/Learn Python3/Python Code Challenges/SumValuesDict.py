def sum_values(my_dictionary):
  temp = 0
  for i in my_dictionary.values():
    temp += i
  return temp



print(sum_values({"milk":5, "eggs":2, "flour": 3}))
# should print 10
print(sum_values({10:1, 100:2, 1000:3}))
# should print 6
#Write a function named sum_values that takes a dictionary named my_dictionary as a parameter. 
#The function should return the sum of the values of the dictionary