package point;

import java.util.Scanner;
public class Point {
	private int x;
	private int y;

	public Point(int x,int y) {
		this.x=x;
		this.y=y;
	}

	public double distance(Point p) {
		return Math.sqrt((x-p.x)*(x-p.x)+(y-p.y)*(y-p.y));
	}

	public double distance(int x1,int y1) {
		return Math.sqrt((x-x1)*(x-x1)+(y-y1)*(y-y1));
	}

	public double distance(Point x,Point y) {
		return Math.sqrt((x.x-y.x)*(x.x-y.x)+(x.y-y.y)*(x.y-y.y));
	}

	public static void main(String arg[]) {
		Scanner scanner=new Scanner(System.in);
		int x1=scanner.nextInt();
		int y1=scanner.nextInt();
		int x2=scanner.nextInt();
		int y2=scanner.nextInt();
		Point a=new Point(x1,y1);
		Point b=new Point(x2,y2);
		double result1=a.distance(a, b);
		double result2=a.distance(b);
		double result3=a.distance(x2,y2);

		System.out.printf("%.2f\n",result1);
		System.out.printf("%.2f\n",result2);
		System.out.printf("%.2f\n",result3);
		scanner.close();
	}

}
