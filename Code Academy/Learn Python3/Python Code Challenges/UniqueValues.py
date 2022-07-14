def unique_values(my_dictionary):
  values = []
  for value in my_dictionary.values():
    if value not in values:
      values.append(value)
  return len(values)


print(unique_values({0:3, 1:1, 4:1, 5:3}))
# should print 2
print(unique_values({0:3, 1:3, 4:3, 5:3}))
# should print 1
#Create a function named unique_values that takes a dictionary named my_dictionary as a parameter. 
# The function should return the number of unique values in the dictionary.

