public class Reverse {

  public static String reverseString(String text) {
    String reversed = "";

    for (int i = text.length() - 1; i >= 0; i--) {
      char next = text.charAt(i);
      reversed += next;
    }
    return reversed;
  }

  public static void main(String[] args) {
    String text = new String("Wassup my brotha");
    System.out.println(reverseString("abc"));
    System.out.println(reverseString(text));

  }
}