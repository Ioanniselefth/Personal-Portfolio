package JavaProjects;

public class DecimalToBinary {

    // function to convert decimal to binary
    static void decimalToBinary(int n) {
        // array to store binary number
        int[] binaryNum = new int[1000];
        // counter for binary array
        int i = 0;
        while (n > 0) {
            // storing remainder in binary array
            binaryNum[i] = n % 2;
            n = n / 2;
            i += 1;
        }
        // printing binary array in reverse order
        for (int j = i - 1; j >= 0; j--)
            System.out.print(binaryNum[j]);
        System.out.println();
    }

    // Main program
    public static void main(String[] args) {
        int n = 17;
        System.out.println("Decimal: " + n);
        System.out.println("Binary: ");
        decimalToBinary(n);

    }
}
