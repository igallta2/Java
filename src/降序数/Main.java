package 降序数;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 读取输入
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.close();
        // 判断是否为降序数并输出结果
        System.out.println(isDescendingNumber(number));
    }

    // 判断是否为降序数的方法
    public static boolean isDescendingNumber(int n) {
        String numStr = String.valueOf(n);
        for (int i = 0; i < numStr.length() - 1; i++) {
            if (numStr.charAt(i) < numStr.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
