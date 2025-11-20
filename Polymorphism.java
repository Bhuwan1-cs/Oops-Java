public class PolymorphismSum {
    public int sum(int a, int b) {
        return a + b;
    }
    public double sum(double a, double b) {
        return a + b;
    }
    public int sum(int a, int b, int c) {
        return a + b + c;
    }
    public static void main(String[] args) {
        PolymorphismSum obj = new PolymorphismSum();
        System.out.println("Sum (int, int): " + obj.sum(2, 3));
        System.out.println("Sum (double, double): " + obj.sum(2.5, 3.5));
        System.out.println("Sum (int, int, int): " + obj.sum(1, 2, 3));
    }
}
