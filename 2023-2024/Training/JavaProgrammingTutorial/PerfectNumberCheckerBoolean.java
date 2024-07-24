public class PerfectNumberCheckerBoolean {
    public boolean isPerfectNumber(int number) {
        int sum=0;
        int i=1;
        if(number <= 0)
            return false;
        while(i <= number/2){
            if(number % i == 0)
                sum += i;
            i++;
        }
        if(sum==number)
            return true;
        return false;
    }
}
