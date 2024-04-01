package complexnumberAdding;

import java.util.Scanner;

public class Complex {
    private double x, y;

    public Complex(double real, double imaginary) {
        x = real;
        y = imaginary;
    }

    @Override
	public String toString() {
        return "(" + x + "," + y + "i" + ")";
    }

    public Complex multiply(Complex a) {
        return new Complex(x * a.x - y * a.y, x * a.y + a.x * y);
    }

    public Complex multiply(double a, double b) {
        return new Complex(x * a - y * b, x * b + y * a);
    }

    public static Complex multiply(Complex a, Complex b) {
        return new Complex(a.x * b.x - a.y * b.y, a.x * b.y + a.y * b.x);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter real part of complex number a:");
        double realPartA = scan.nextDouble();

        System.out.println("Enter imaginary part of complex number a:");
        double imaginaryPartA = scan.nextDouble();

        System.out.println("Enter real part of complex number b:");
        double realPartB = scan.nextDouble();

        System.out.println("Enter imaginary part of complex number b:");
        double imaginaryPartB = scan.nextDouble();

        Complex a = new Complex(realPartA, imaginaryPartA);
        Complex b = new Complex(realPartB, imaginaryPartB);

        Complex result = Complex.multiply(a, b);

        System.out.println("Result of multiplication: " + result.toString());

        scan.close();
    }
}
