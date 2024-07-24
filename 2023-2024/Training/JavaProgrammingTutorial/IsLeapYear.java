public class IsLeapYear {
    public boolean isLeapYear(int year) {
        if(year < 1)
            return false;
        if (year % 4 != 0)
            return false;
        if (year % 100 != 0)
            return true;
        if(year % 400 != 0)
            return false;
        return true;
    }
}

/*
 * Not Divisible by 4 - NOT Leap Year (2041)
 * Divisible by 4 and NOT divisible by 100 - Leap Year (2048)
 * Divisible by 4 and divisible by 100 - Additional check needed
 * Divisible by 4, divisible by 100, divisible by 400 - Leap Year (2000, 2400)
 * Divisible by 4, divisible by 100, NOT divisible by 400 - NOT Leap Year (2100, 2200, 2300)
*/