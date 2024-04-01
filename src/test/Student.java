package test;

public class Student {
    private String name;
    private int studentId;
    private String className;
    public static int count = 0; // 静态属性 count

    // 无参构造方法
    public Student() {
        // 使用this调用有参构造方法，以便初始化属性
        this("", 0, "");
    }

    // 有参构造方法
    public Student(String name, int studentId, String className) {
        this.name = name;
        this.studentId = studentId;
        this.className = className;
        count++; // 每创建一个学生对象，count加1
    }

    // 输出学生信息的方法
    public void printInfo() {
        System.out.printf("%s, %d, %s; ", name, studentId, className);
    }

    public static void main(String[] args) {
        // 创建两个学生对象并初始化
        Student s1 = new Student("s1", 17101, "171");
        Student s2 = new Student("s2", 17102, "171");

        // 调用对象的方法输出学生的基本信息
        s1.printInfo();
        s2.printInfo();

        // 输出静态属性count的值
        System.out.println("count=" + count);
    }
}
