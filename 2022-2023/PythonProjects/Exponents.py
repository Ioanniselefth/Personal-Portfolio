def exponents(bases, powers):
  new_lst = []
  for i in range(0, len(bases)):
    for j in range(0, len(powers)):
      temp = bases[i] ** powers[j]
      new_lst.append(temp)
  return new_lst


print(exponents([2, 3, 4], [1, 2, 3]))

#Create a function named exponents() that takes two lists as parameters named bases and powers. Return a new list containing every number in bases raised to every number in powers.

#For example, consider the following code.

#exponents([2, 3, 4], [1, 2, 3])
#the result would be the list[2, 4, 8, 3, 9, 27, 4, 16, 64]. It would first add two to the first. Then two to the second. Then two to the third, and so on.
