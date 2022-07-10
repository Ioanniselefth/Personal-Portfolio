def larger_sum(lst1,lst2):
  sum1,sum2 = 0,0
  for i in range(0,len(lst1)):
    sum1 += lst1[i]
  for i in range(0,len(lst2)):
    sum2 += lst2[i]
  if sum1>=sum2:
    return lst1
  return lst2

print(larger_sum([1, 9, 5], [2, 3, 7]))

#Create a function named larger_sum() that takes two lists of numbers as parameters named lst1 and lst2.

#The function should return the list whose elements sum to the greater number. If the sum of the elements of each list are equal, return lst1.