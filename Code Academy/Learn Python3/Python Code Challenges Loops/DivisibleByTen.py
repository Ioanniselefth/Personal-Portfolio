def divisible_by_ten(lst):
  counter = 0
  for i in range(0,len(lst)):
    if lst[i]%10==0:
      counter += 1
  return counter


print(divisible_by_ten([20, 25, 30, 35, 40]))
#Create a function named divisible_by_ten() that takes a list of numbers named nums as a parameter.
#Return the count of how many numbers in the list are divisible by 10.
