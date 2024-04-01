package calculateFunction;

import java.util.Scanner;

public class F {
    private int x;
    private int y;
    private int z;

    public F(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int calculate() {
        if (x >= 0 && y >= 0 && z >= 0) {
            return x * x + y * y + z * z;
        }
        if (x >= 0 && y >= 0 && z < 0) {
            return x * x + y * y;
        }
        if (x >= 0 && y < 0) {
            return x * x;
        }
        if (x < 0) {
            return 0;
        }
        // 添加默认返回语句
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();

        F f = new F(x, y, z);
        // 使用对象实例调用calculate方法
        int result = f.calculate();
        System.out.println(result);
        scanner.close();
    }
}
