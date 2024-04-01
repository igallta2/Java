package classExtends;

class Student extends Person {
    private String studentID;
    private String enrollmentDate;
    private String major;

    public Student(String name, char gender, int age, String studentID, String enrollmentDate, String major) {
        super(name, gender, age);
        this.studentID = studentID;
        this.enrollmentDate = enrollmentDate;
        this.major = major;
    }

    @Override
	public String toString() {
        return super.toString() + "," + studentID + "," + enrollmentDate + "," + major;
    }
}