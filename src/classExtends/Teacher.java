package classExtends;

class Teacher extends Person {
    private String title;
    private String department;

    public Teacher(String name, char gender, int age, String title, String department) {
        super(name, gender, age);
        this.title = title;
        this.department = department;
    }

    @Override
	public String toString() {
        return super.toString() + "," + title + "," + department;
    }
}
