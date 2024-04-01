package linkList;
import javax.swing.JOptionPane;
public class LinkList {
	public static void main(String arg[]) {
		int score = 0;
		for(int i =0;i<10;i++) {
			int a=10+(int)(90*Math.random());
			int b=10+(int)(90*Math.random());
			String s =JOptionPane.showInputDialog(a + '+' + b + "=?");
			int ans =Integer.parseInt(s);
			if(a+b==ans) {
				score=score+10;
			}
			JOptionPane.showMessageDialog(null,"your score="+score);
		}
	}

}
