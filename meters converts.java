import java.util.Scanner;

public class MeterToFeet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value in meters: ");
        double meters = sc.nextDouble();

        double feet = meters * 3.28084;

        System.out.println("Value in feet: " + feet);

        sc.close();
    }
}
