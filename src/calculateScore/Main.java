package calculateScore;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取学生人数
        int n = scanner.nextInt();
        int[] scores = new int[n];

        // 读取学生成绩并存入数组
        for (int i = 0; i < n; i++) {
            scores[i] = scanner.nextInt();
        }

        // 计算最高分和平均分
        double max = findMax(scores);
        double avg = findAverage(scores);

        // 统计各分数段的人数
        int fail = 0, pass = 0, middle = 0, good = 0, excellent = 0;
        for (int score : scores) {
            if (score < 60) {
                fail++;
            } else if (score >= 60 && score < 70) {
                pass++;
            } else if (score >= 70 && score < 80) {
                middle++;
            } else if (score >= 80 && score < 90) {
                good++;
            } else {
                excellent++;
            }
        }

        // 输出结果
        System.out.println("max:" + max);
        System.out.printf("avg:%.2f\n", avg);
        System.out.println("fail:" + fail);
        System.out.println("pass:" + pass);
        System.out.println("middle:" + middle);
        System.out.println("good:" + good);
        System.out.println("excellent:" + excellent);

        scanner.close();
    }

    // 寻找数组中的最大值
    public static double findMax(int[] array) {
        double max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    // 计算数组的平均值
    public static double findAverage(int[] array) {
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return (double) sum / array.length;
    }
}
