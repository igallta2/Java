package complexNumberMultiply;

import java.util.Scanner;

public class Complex {
	private double x,y;

	public Complex(double real,double imaginary) {
		x=real;
		y=imaginary;
	}

	@Override
	public String toString() {
		return "(" + String.format("%.2f", x) + "," + String.format("%.2f", y) + ")";
	}

	public Complex multiply(Complex a) {
		return new Complex(a.x*x-a.y*y,x*a.y+y*a.x);
	}

	public Complex multiply(double a,double b) {
		return new Complex(a*x-b*y,x*b+y*a);
	}
	public static Complex multiply(Complex a,Complex b) {
		return new Complex(a.x*b.x-a.y*b.y,a.x*b.y+a.y*b.x);
	}

	public static void main(String arg[]) {
        Scanner scanner = new Scanner(System.in);

        double realPartA = scanner.nextDouble();
        double imaginaryPartA = scanner.nextDouble();
        double realPartB = scanner.nextDouble();
        double imaginaryPartB = scanner.nextDouble();

        Complex a = new Complex(realPartA, imaginaryPartA);
        Complex b = new Complex(realPartB, imaginaryPartB);

        Complex result1 = Complex.multiply(a, b);
        Complex result2 = a.multiply(b);
        Complex result3 = a.multiply(realPartB, imaginaryPartB);


        double mol_1=(realPartA*realPartA+imaginaryPartA*imaginaryPartA);
        double mol_2=(realPartB*realPartB+imaginaryPartB*imaginaryPartB);

        System.out.println(result1.toString());
        System.out.println(result2.toString());
        System.out.println(result3.toString());
        System.out.printf("%.2f\n",mol_1);
        System.out.printf("%.2f",mol_2);
        scanner.close();
	}

}
