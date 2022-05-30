import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // call the method here
        int h = scanner.nextInt();
        int b = scanner.nextInt();
        countAreaOfParallelogram(b, h);
    }

    // Do not change code below   
    public static void countAreaOfParallelogram(int b, int h) {

        System.out.println(b * h);
    }
}