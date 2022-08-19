#1491. Average Salary Excluding the Minimum and Maximum Salary

class Solution:
    def average(self, salary: List[int]) -> float:
        max = salary[0]
        min = salary[0]
        sum = 0
        counter = 0
        for i in range(1, len(salary)):
            if salary[i] > max:
                max = salary[i]
            if salary[i] < min:
                min = salary[i]
        for i in range(0, len(salary)):
            if max == salary[i] or min == salary[i]:
                continue
            else:
                sum += salary[i]
                counter += 1
        return sum/counter
