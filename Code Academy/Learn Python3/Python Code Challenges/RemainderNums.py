def remainder(num1, num2):
  num1 *= 2
  num2 /= 2
  return num1 % num2


print(remainder(15, 14))
# should print 2
print(remainder(9, 6))
# should print 0
#Write a function named remainder() that has two parameters named num1 and num2.
#The function should return the remainder of twice num1 divided by half of num2.
