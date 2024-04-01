package classExtends;

public class Main {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Mary", 'W', 45, "professor", "computer");
        Student student = new Student("John", 'M', 20, "923001", "2023/8/23", "computer");

        System.out.println(teacher.toString());
        System.out.println(student.toString());
    }
}
