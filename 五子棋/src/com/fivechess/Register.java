package com.fivechess;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.util.Date;
import java.util.Random;
import javax.swing.*;

public class Register extends JFrame{
	final JLabel welcomeRegisterLabel = new JLabel("欢迎注册五子棋！");
	final JLabel userLabel = new JLabel("用户名：");
	final JTextField userjt = new JTextField(14);
	final JLabel passwordLabel = new JLabel("密码：");
	final JPasswordField passwordjp = new JPasswordField(14);
	final JLabel confirmPasswordLabel = new JLabel("确认密码：");
	final JPasswordField confirmPasswordjp = new JPasswordField(14);
	final JLabel back = new JLabel("返回");
	final JLabel tipUserAlreadyRegistered = new JLabel("该账号已经注册！");
	final JLabel tipUserNameEmpty = new JLabel("用户名为空！");
	final JLabel tipUserNameLessThan5Char = new JLabel("账号少于5个字符！");
	final JLabel tipPasswordEmpty = new JLabel("密码不能为空!");
	final JLabel tipPasswordLessThan6Char = new JLabel("密码少于6个字符！");
	final JLabel tipPasswordInconfirmity = new JLabel("两次密码不一致!");
	final JLabel tipConfirmPasswordqualified = new JLabel("重复密码正确！");
	final JLabel tipyanzhengmaerror = new JLabel("验证码输入不正确!");
	final Random r = new Random();
	static String userName = new String();
	static String password = new String();
	final FileOperation read = new FileOperation();
	String repeatPassword = new String();
	String yanzhengma = new String();
	String yzm = new String();
	int flagUserName = 0;
	int flagPassword = 0;
	int flagConfirmedPassword = 0;
	int flagyanzhengma = 0;
	char[] YZM = new char[62];{
		for(int i = 0; i < 26; i++) {
			YZM[i] = (char) ('A' + i);
		}
		for(int i = 26; i< 52; i++) {
			YZM[i] = (char) ('a' + i - 26);
		}
		for(char i = 52; i < 62; i++) {
			YZM[i] = (char) (i - 4);
		}
	}
	SpringLayout springLayout = new SpringLayout();
}
