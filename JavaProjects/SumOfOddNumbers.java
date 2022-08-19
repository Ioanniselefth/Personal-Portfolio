package JavaProjects;

public class SumOfOddNumbers {
    public static int rowSumOddNumbers(int n) {
        return n * n * n;
    }
}
/*
 * Given the triangle of consecutive odd numbers:
 * 
 * 1
 * 3 5
 * 7 9 11
 * 13 15 17 19
 * 21 23 25 27 29
 * ...
 * Calculate the sum of the numbers in the nth row of this triangle (starting at
 * index 1) e.g.: (Input --> Output)
 * 
 * 1 --> 1
 * 2 --> 3 + 5 = 8
 * import static org.junit.Assert.*;
 * import org.junit.Test;
 * 
 * public class RowSumOddNumbersTest {
 * 
 * @Test
 * public void test1() {
 * assertEquals(1, RowSumOddNumbers.rowSumOddNumbers(1));
 * assertEquals(74088, RowSumOddNumbers.rowSumOddNumbers(42));
 * }
 * }
 */