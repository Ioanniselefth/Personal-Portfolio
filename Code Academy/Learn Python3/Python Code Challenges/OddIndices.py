def odd_indices(lst):
  lst2 = []
  for i in range(1, len(lst), 2):
    lst2.append(lst[i])
  return lst2


print(odd_indices([4, 3, 7, 10, 11, -2]))
#Create a function named odd_indices() that has one parameter named lst.
#The function should create a new empty list and add every element from lst that has an odd index. The function should then return this new list.
#For example, odd_indices([4, 3, 7, 10, 11, -2]) should return the list[3, 10, -2].
