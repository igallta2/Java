package swing;

import javax.swing.JOptionPane;

public class TestSwing {
    public static void main(String args[]) {
        String input = JOptionPane.showInputDialog("请输入圆的半径：");
        if(input != null) {
            try {
                double radius = Double.parseDouble(input);
                double area = Math.PI * radius * radius;
                JOptionPane.showMessageDialog(null, "圆的面积=" + area);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "请输入有效的数字！", "错误", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "输入不能为空！", "错误", JOptionPane.ERROR_MESSAGE);
        }
    }
}
