package switch_;
import javax.swing.JOptionPane;
public class Switch {
	public static void main(String arg[]) {
		int s;
		s = Integer.parseInt(JOptionPane.showInputDialog("输入分数："));
		int x=s/10;
		switch(x) {
		case 0:case 1:case 2:case 3:case 4:
		case 5:
			System.out.println("不及格");
			break;
		case 6:
			System.out.println("及格");
			break;
		case 7:
			System.out.println("中");
			break;
		case 8:
			System.out.println("良");
			break;
		case 9:
		case 10:
			System.out.println("优");
			break;
		}
	}

}
