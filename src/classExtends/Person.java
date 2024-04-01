package classExtends;

class Person {
    private String name;
    private char gender;
    private int age;

    public Person(String name, char gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    @Override
	public String toString() {
        return name + "," + gender + "," + age;
    }
}
