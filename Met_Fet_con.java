import java.util.Scanner;
public class Met_Fet_con {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter length in meters: ");
        double meters = scanner.nextDouble();

        // 1 meter = 3.28084 feet
        double feet = meters * 3.28084;

        System.out.println(meters + " meters is equal to " + feet + " feet.");

        scanner.close();
    }
}

