//1491. Average Salary Excluding the Minimum and Maximum Salary

class Solution1491 {
    public double average(int[] salary) {
        int min = salary[0];
        int max = salary[0];
        int sum = salary[0];
        for (int i = 1; i < salary.length; i++) {
            if (salary[i] < min) { // salary[i]=100,min=10
                min = salary[i];
            } else if (salary[i] > max) { // salary[i]=100,max=100
                max = salary[i];
            }
            sum += salary[i];
        }
        return (double) (sum - min - max) / (salary.length - 2);
    }
}