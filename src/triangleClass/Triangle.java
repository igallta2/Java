package triangleClass;

import java.util.Scanner;

public class Triangle {
	private double side1;
	private double side2;
	private double side3;
	public Triangle(double side1,double side2,double side3) {
		this.side1=side1;
		this.side2=side2;
		this.side3=side3;
	}

	public double calculateArea() {
		double s=(side1+side2+side3)/2;
		return Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
	}

	public double calculatePerimeter() {
		return side1+side2+side3;
	}

    public static void main(String[] args) {
    	Scanner scanner=new Scanner(System.in);
    	double side1=scanner.nextDouble();
    	double side2=scanner.nextDouble();
    	double side3=scanner.nextDouble();
    	Triangle triangle=new Triangle(side1,side2,side3);
    	double area = triangle.calculateArea();
        double perimeter = triangle.calculatePerimeter();

        System.out.printf("area:%.2f\n",area);
        System.out.printf("circle:%.2f",perimeter);
        scanner.close();
    	}

}
