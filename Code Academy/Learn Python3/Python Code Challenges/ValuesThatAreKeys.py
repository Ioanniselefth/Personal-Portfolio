def values_that_are_keys(my_dictionary):
  temp = []
  for i in my_dictionary.keys():
    if my_dictionary[i] in my_dictionary:
      temp.append(my_dictionary[i])
  return temp


print(values_that_are_keys({1:100, 2:1, 3:4, 4:10}))
# should print [1, 4]
print(values_that_are_keys({"a":"apple", "b":"a", "c":100}))
# should print ["a"]
#Create a function named values_that_are_keys that takes a dictionary named my_dictionary as a parameter.
# This function should return a list of all values in the dictionary that are also keys.