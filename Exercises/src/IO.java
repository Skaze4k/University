
public class IO {

    public static int readInt(String prompt) {
        System.out.print(prompt);
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int value = sc.nextInt();
        return value;
    }

    public static char readChar(String prompt) {
        System.out.print(prompt);
        java.util.Scanner sc = new java.util.Scanner(System.in);
        char value = sc.next().charAt(0);
        return value;
    }

    public static String readString(String prompt) {
        System.out.print(prompt);
        java.util.Scanner sc = new java.util.Scanner(System.in);
        String value = sc.next();
        return value;
    }

    public static double readDouble(String prompt) {
        System.out.print(prompt);
        java.util.Scanner sc = new java.util.Scanner(System.in);
        double value = sc.nextDouble();
        return value;
    }

    public static void print(String str) {
        System.out.print(str);
    }

    public static void println(String str) {
        System.out.println(str);
    }

    // test program
    public static void main(String[] args) {
        int input = IO.readInt("Enter value: ");
        IO.println("Your input = " + input);
    }

}
