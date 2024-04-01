package e的x次方;

import java.util.Scanner;

public class Main {
	 public static double calculateEx(double x) {
	        double ex = 1;
	        double term = 1;
	        int n = 1;
	        while (Math.abs(term) >= 0.00001) {
	            term *= x / n;
	            ex += term;
	            n++;
	        }
	        return ex;
	    }

	public static void main(String arg[]){
		Scanner scanner = new Scanner(System.in);
	    double value =scanner.nextDouble();
	    double step_length=scanner.nextDouble();
	    scanner.close();
	    for(;value<=1;value+=step_length) {
	    	double exValue = calculateEx(value);
            System.out.printf("x=%.2f时,e(x)的值为:%.6f\n",value,exValue);
	    }

        scanner.close();
	}
}
