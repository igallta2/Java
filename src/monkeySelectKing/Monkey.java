package monkeySelectKing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Monkey{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.close();

        List<Integer> monkeys = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            monkeys.add(i);
        }

        List<Integer> outSequence = new ArrayList<>();
        int index = k - 1;
        while (monkeys.size() > 1) {
            index = (index + m - 1) % monkeys.size();
            outSequence.add(monkeys.get(index));
            monkeys.remove(index);
        }

        for (Integer element : outSequence) {
            System.out.print(element + " ");
        }
        System.out.println();

        System.out.println(monkeys.get(0));
    }
}
