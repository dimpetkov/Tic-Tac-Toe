import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        String[] input = scanner.nextLine().split("\\s+");
        int[] numbers = new int[input.length];
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i] = Integer.parseInt(input[i]));
        }
    }
}