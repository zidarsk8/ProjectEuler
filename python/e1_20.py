

result = sum([i for i in range(1000) if i % 5 == 0 or i % 3 == 0])
print "Problem 1: {}".format(result)
###############################################################################

def fib_gen():
  a = b = 1
  while a < 4000000:
    yield a
    a, b = a + b, a

result = sum([i for i in fib_gen() if i % 2 == 0])
print "Problem 2: {}".format(result)
###############################################################################


def factor(num):
  i = 2
  while i<=num and num > 1:
    if num % i == 0:
      num = num // i
    else:
      i += 1
  return i

result = factor(600851475143)
print "Problem 3: {}".format(result)
###############################################################################


palindromes = [int(str(i) + str(i)[::-1]) for i in range(100, 1000)]

divisible = [p for p in palindromes for d in range(100, 1000)
             if p % d == 0 and p // d < 1000 and p // d >= 100]

result = divisible[-1]
print "Problem 4: {}".format(result)
###############################################################################


def multiple(n):
  divisor = 2
  number = 1
  step = 1
  while divisor < n:
    while number % divisor != 0:
      number += step
    step = number
    divisor += 1
  return number

result = multiple(20)
print "Problem 5: {}".format(result)
###############################################################################


def sum_difference(n):
  nums = [i for i in range(1,n+1)]
  return sum(nums)**2 - sum([i**2 for i in nums])


result = sum_difference(100)
print "Problem 6: {}".format(result)
