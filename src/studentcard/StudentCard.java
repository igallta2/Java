package studentcard;

public class StudentCard {
	String cardNumber;
	String studentID;
	String name;
	double balance;

	public StudentCard(String cardNumber,String studentID,String name,double balance) {
		this.cardNumber=cardNumber;
		this.studentID=studentID;
		this.name=name;
		this.balance=balance;
	}

	 public StudentCard(String cardNumber,String studentID, String name) {
	        this(cardNumber,studentID,name, 0.00); // 调用另一个构造方法进行初始化
	    }

	 public void printInfo() {
	        System.out.println(cardNumber + "," + name + "," + studentID + "," + String.format("%.1f", balance));
	    }

	    public static void main(String[] args) {
	        // 使用第一个构造方法创建学生卡对象
	        StudentCard card1 = new StudentCard("201800623","20151250623","zhangxiaohua",0.00);
	        // 使用第二个构造方法创建学生卡对象
	        StudentCard card2 = new StudentCard("201800625","20151250601","zhanghuahua",100.00);

	        // 调用对象的方法输出学生卡基本信息
	        card1.printInfo();
	        card2.printInfo();
	    }

}
