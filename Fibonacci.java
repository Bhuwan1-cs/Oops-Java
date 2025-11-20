import java.util.Scanner;
public class Fibonacci {
    public static int fibRecursive(int n) {
        if (n <= 1) return n;
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }
    public static void fibNonRecursive(int n) {
        if (n <= 0) {
            System.out.println("Fibonacci (non-recursive):");
            return;
        }
        int a = 0, b = 1;
        System.out.print("Fibonacci (non-recursive): ");
        if (n >= 1) System.out.print(a);
        if (n >= 2) System.out.print(" " + b);
        for (int i = 2; i < n; i++) {
            int c = a + b;
            System.out.print(" " + c);
            a = b;
            b = c;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of terms: ");
        int n = sc.nextInt();
        System.out.print("Fibonacci (recursive): ");
        for (int i = 0; i < n; i++) {
            System.out.print(fibRecursive(i));
            if (i < n - 1) System.out.print(" ");
        }
        System.out.println();
        fibNonRecursive(n);
        sc.close();
    }
}
