package 算根号;
import java.util.Scanner;
public class Findroot {
	public static void main(String arg[]) {
		double x1,x2,a;
		System.out.println("请输入a=？");
		Scanner scan = new Scanner(System.in);
		a = scan.nextDouble();
		scan.close();
		x1 = a/2;
		do
		{
			x2=x1;
			x1=(x2+a/x2)/2;
		}while(Math.abs(x1-x2)>=1e-5);
		System.out.printf("%.2f的平方根是%.5f\n",a,x1);
	}

}
