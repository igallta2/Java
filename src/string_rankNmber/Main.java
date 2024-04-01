package string_rankNmber;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入10个10-90之间的不重复整数，以空格分隔：");
        String input = scanner.nextLine();
        scanner.close();

        String[] tokens = input.split(" ");
        int[] numbers = new int[10];
        int count = 0;
        StringBuilder concatenatedString = new StringBuilder();

        for (String token : tokens) {
            int num = Integer.parseInt(token);
            if (num >= 10 && num <= 90 && !contains(numbers, count, num)) {
                numbers[count++] = num;
                concatenatedString.append(num).append(",");
            }
        }

        String concatenatedNumbers = concatenatedString.toString();
        System.out.println(concatenatedNumbers);

        Arrays.sort(numbers, 0, count);
        System.out.println(Arrays.toString(Arrays.copyOf(numbers, count)));
    }

    public static boolean contains(int[] arr, int count, int num) {
        for (int i = 0; i < count; i++) {
            if (arr[i] == num) {
                return true;
            }
        }
        return false;
    }
}
