public class Reverse {

    public static String reverseString(String text) {
    String reversed = new String("");
   
    for (int i=0; i < text.length(); i++){
      char nextCharacter = text.charAt(i);
      reversed = nextCharacter + reversed;
    }
    return reversed;
  }
  
    public static void main(String[] args) {
      String text = new String("Wassup my brotha");
  
     System.out.println(reverseString(text));
     
   }
  }