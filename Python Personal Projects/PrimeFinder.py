def prime_finder(n):
  list_of_primes = []
  for x in range(2, n+1):
    num = x
    p = False
    for y in range(2, num):
      if num % y == 0:
        p = True
        break
    if p:
      continue
    else:
      list_of_primes.append(num)
  return list_of_primes
 
print(prime_finder(11))