package studentScoreRank;

import java.util.Arrays;
import java.util.Scanner;

public class Student implements Comparable<Student> {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Student other) {
        // 先按成绩降序排序，如果成绩相同则按照输入顺序排序
        if (this.score != other.score) {
            return other.score - this.score;
        } else {
            return 0; // 成绩相同时，不改变它们之间的顺序
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); // 吸收换行符

        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            String name = scanner.next();
            int score = scanner.nextInt();
            students[i] = new Student(name, score);
        }

        Arrays.sort(students);

        for (Student student : students) {
            System.out.printf("%15s%5d\n", student.name, student.score);
        }
        scanner.close();
    }
}
