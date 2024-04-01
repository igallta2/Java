package practice;

class Student {
    private int num;
    private String name;
    private int age;

    public Student(int num, String name, int age) {
        this.num = num;
        this.name = name;
        this.age = age;
    }

    public void increaseAge() {
        age++;
    }

    public int getAge() {
        return age;
    }

    @Override
	public String toString() {
        return "num:" + num + ",name:" + name + ",age:" + age;
    }

    public static void main(String[] args) {
        Student[] students = {
            new Student(1, "zhang", 19),
            new Student(2, "wang", 21),
            new Student(3, "li", 20),
            new Student(4, "yang", 18)
        };

        for (Student student : students) {
            student.increaseAge();
        }

        for (Student student : students) {
            System.out.println(student);
        }

        for (Student student : students) {
            if (student.getAge() > 20) {
                System.out.println(student);
            }
        }
    }
}

