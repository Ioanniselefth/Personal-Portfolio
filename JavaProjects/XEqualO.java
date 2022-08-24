package JavaProjects;

import java.util.Scanner;

class XEqualO {
    final static Scanner scanner = new Scanner(System.in);

    // Function that returns true if count of Xs and Os are equal
    static Boolean xequalo(String temp) {
        int countx = 0;
        int counto = 0;
        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) == 'X' || temp.charAt(i) == 'x')
                countx += 1;
            if (temp.charAt(i) == 'O' || temp.charAt(i) == 'o')
                counto += 1;
        }
        if (countx != counto)
            return false;
        return true;
    }

    // Main function
    public static void main(String[] args) {
        System.out.println("Give a string: ");
        String temp = scanner.nextLine();
        Boolean booltemp = xequalo(temp);
        System.out.println("Your string is: " + temp);
        if (booltemp == true)
            System.out.println("The count of Xs and Os are the same ");
        else
            System.out.println("The count of Xs and Os are not the same ");
    }
}
