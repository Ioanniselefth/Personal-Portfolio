
public class CreatePhoneNumber {
  public static String createPhoneNumber(int[] numbers) {
    String str = "(";
    for (int i = 0; i < numbers.length; i++) {
      if (i < 2) {
        str += "" + numbers[i];
      } else if (i == 2) {
        str += "" + numbers[i] + ") ";
      } else if (i > 2 && i < 5) {
        str += "" + numbers[i];
      } else if (i == 5) {
        str += "" + numbers[i] + "-";
      } else {
        str += "" + numbers[i];
      }
    }
    return str;
  }
}
/*
 * Write a function that accepts an array of 10 integers (between 0 and 9), that
 * returns a string of those numbers in the form of a phone number.
 * Kata.createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}) // =>
 * returns "(123) 456-7890"
 * The returned format must be correct in order to complete this challenge.
 * Don't forget the space after the closing parentheses!
 */