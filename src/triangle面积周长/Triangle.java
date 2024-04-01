package triangle面积周长;
import java.util.Scanner;
public class Triangle {
	public static void main(String args[]) {
		double a,b,c;
		Scanner scan = new Scanner(System.in);
		System.out.print("请输入三角形的三边值，用空格隔开：");
		a = scan.nextDouble();
		b = scan.nextDouble();
		c = scan.nextDouble();
		scan.close();
		double perimeter = a+b+c;
		double p = (a+b+c)/2;
		double area = Math.sqrt(p*(p-a)*(p-b)*(p-c));
		String result = "三条边分别为"+a+" "+b+" "+c+"的三角形的"+"周长="
				+ String.format("%.2f",perimeter)+",面积="+String.format("%.2f",area);
		System.out.println(result);
	}

}
