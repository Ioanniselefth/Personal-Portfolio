def binary_array_to_number(arr):
    temp = 1
    counter = 0
    i = len(arr)-1
    while i >= 0:
        if arr[i] == 1:
            counter += temp
        temp *= 2
        i -= 1
    return counter
"""
import codewars_test as test
from solution import binary_array_to_number

@test.describe("Fixed Tests")
def fixed_tests():
    @test.it('Basic Test Cases')
    def basic_test_cases():
        test.assert_equals(binary_array_to_number([0,0,0,1]), 1)
        test.assert_equals(binary_array_to_number([0,0,1,0]), 2)
        test.assert_equals(binary_array_to_number([1,1,1,1]), 15)
        test.assert_equals(binary_array_to_number([0,1,1,0]), 6)

Given an array of ones and zeroes, convert the equivalent binary value to an integer.
Eg: [0, 0, 0, 1] is treated as 0001 which is the binary representation of 1.
Examples:
Testing: [0, 0, 0, 1] ==> 1
Testing: [0, 0, 1, 0] ==> 2
Testing: [0, 1, 0, 1] ==> 5
Testing: [1, 0, 0, 1] ==> 9
Testing: [0, 0, 1, 0] ==> 2
Testing: [0, 1, 1, 0] ==> 6
Testing: [1, 1, 1, 1] ==> 15
Testing: [1, 0, 1, 1] ==> 11
However, the arrays can have varying lengths, not just limited to 4.
"""