public class SumOfTwoDice {
    public static void main(String[] args) {
        int a = 1 + (int) (Math.random() * 6);
        int b = 1 + (int) (Math.random() * 6);
        System.out.println("a = " + a + ", b = " + b);

        int sum = a + b;
        System.out.println(sum);
    }
}
