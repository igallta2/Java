package com.fivechess;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Main extends JFrame{
	/*
	 * 用户登录
	 */
	private static final long servialVersionUID = 1L;
	
	final JLabel logoLabel = new JLabel("五子棋");
	final JLabel logo = new JLabel();
	final JButton loginButton = new JButton("                  登   陆                  ");
	final JLabel registerLabel = new JLabel("立即注册");
	final JLabel userLabel = new JLabel("账号：");
	final JLabel passwordLabel = new JLabel("密码：");
	final static JTextField userjt = new JTextField(11);
	final JPasswordField passwordjt = new JPasswordField(11);
	final JCheckBox rememberPasswordjcb = new JCheckBox();
	final JLabel rememberPasswordjl = new JLabel("记住密码");
	final JCheckBox automaticLoginjcb = new JCheckBox();
	final JLabel automaticLoginjl = new JLabel("自动登录");
	final JLabel promptPasswordFalse = new JLabel("密码错误!");
	final JLabel promptRegister = new JLabel("该账号还未注册！");
	final JLabel promptUserNameEmpty = new JLabel("请输入账号！");
	final JLabel prompPasswordEmpty = new JLabel("请输入密码！");
	final Color color = Color.BLACK;
	final FileOperation read = new FileOperation();//创建文件对象
	final FileOperation f = new FileOperation();
	public Main() {
		setTitle("五子棋");
		setBounds(200, 200, 500, 500);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
		
		//基本布局设置
		SpringLayout springLayout = new SpringLayout();
		Container c = getContentPane();//创建容器
		c.setBackground(Color.WHITE);
		c.setLayout(springLayout);
		
		userjt.setFont(new Font("微软雅黑", 0, 18 ));
		userjt.setText(Register.userName);
		passwordjt.setFont(new Font("微软雅黑", 0, 18));
		passwordjt.setText(Register.password);
		logoLabel.setFont(new Font("微软雅黑", 1, 48));
		logoLabel.setForeground(Color.white);
		ImageIcon logoimage = new ImageIcon(Main.class.getResource("/image/logo5.jpg"));
		logoimage.setImage(logoimage.getImage().getScaledInstance(260, 130, Image.SCALE_DEFAULT));
		logo.setIcon(logoimage);
		userLabel.setFont(new Font("微软雅黑", 1, 20));
		passwordLabel.setFont(new Font("微软雅黑", 1, 20));
		rememberPasswordjl.setFont(new Font("微软雅黑", 0, 14));
		rememberPasswordjl.setForeground(Color.gray);
		automaticLoginjl.setFont(new Font("微软雅黑", 0, 14));
		automaticLoginjl.setForeground(Color.gray);
		loginButton.setFont(new Font("微软雅黑", 1, 16));
		promptPasswordFalse.setFont(new Font("微软雅黑", 0, 13));
		promptPasswordFalse.setForeground(Color.black);
		promptUserNameEmpty.setFont(new Font("微软雅黑", 0, 13));
		promptUserNameEmpty.setForeground(Color.black);
		prompPasswordEmpty.setFont(new Font("微软雅黑", 0, 13));
		prompPasswordEmpty.setForeground(Color.black);
		promptRegister.setFont(new Font("微软雅黑", 0, 13));
	    promptRegister.setForeground(Color.black);
	    rememberPasswordjcb.setBackground(Color.WHITE);
	    automaticLoginjcb.setBackground(Color.WHITE);

	    c.add(logo);//首页图标
	    springLayout.putConstraint(springLayout.NORTH, logo, 40, springLayout.NORTH, c);
	    springLayout.putConstraint(springLayout.WEST, logo, 115, springLayout.WEST, c);
		c.add(logoLabel);//标题“五子棋”
		springLayout.putConstraint(springLayout.NORTH, logoLabel, 100, springLayout.NORTH, c);
		springLayout.putConstraint(springLayout.WEST, logoLabel, 120, springLayout.WEST, c);
		logoLabel.setVisible(false);
		
		c.add(userLabel);//用户名
		springLayout.putConstraint(springLayout.NORTH, userLabel, 35, springLayout.SOUTH, logoLabel);
		springLayout.putConstraint(springLayout.WEST, userLabel, 110, springLayout.WEST, c);
		c.add(userjt);
		springLayout.putConstraint(springLayout.NORTH, userjt, 35, springLayout.SOUTH, logoLabel);
		springLayout.putConstraint(springLayout.WEST, userjt, 10, springLayout.EAST, userLabel);
		
		c.add(passwordLabel);//密码
		springLayout.putConstraint(springLayout.NORTH, passwordLabel, 10, springLayout.SOUTH, userLabel);
		springLayout.putConstraint(springLayout.WEST, passwordLabel, 110, springLayout.WEST, c);
		c.add(passwordjt);
		springLayout.putConstraint(springLayout.NORTH, passwordjt, 10, springLayout.SOUTH, userjt);
		springLayout.putConstraint(springLayout.WEST, passwordjt, 10, springLayout.EAST, passwordLabel);
		
		c.add(rememberPasswordjcb);//复选框
		springLayout.putConstraint(springLayout.NORTH, rememberPasswordjcb, 10, springLayout.SOUTH, passwordLabel);
		springLayout.putConstraint(springLayout.WEST, rememberPasswordjcb, 175, springLayout.WEST, c);
		c.add(rememberPasswordjl);
		springLayout.putConstraint(springLayout.NORTH, rememberPasswordjl, 10, springLayout.SOUTH, passwordjt);
		springLayout.putConstraint(springLayout.WEST, rememberPasswordjl, 5, springLayout.EAST, rememberPasswordjcb);
		c.add(automaticLoginjcb);
		springLayout.putConstraint(springLayout.NORTH, automaticLoginjcb, 10, springLayout.SOUTH, passwordjt);
		springLayout.putConstraint(springLayout.WEST, automaticLoginjcb, 30, springLayout.EAST, rememberPasswordjl);
		c.add(automaticLoginjl);
		springLayout.putConstraint(springLayout.NORTH, automaticLoginjl, 10, springLayout.SOUTH, passwordjt);
		springLayout.putConstraint(springLayout.WEST, automaticLoginjl, 5, springLayout.EAST, automaticLoginjcb);
		
		c.add(loginButton);//登陆按钮
		springLayout.putConstraint(springLayout.NORTH, loginButton, 20, springLayout.SOUTH, rememberPasswordjl);
		springLayout.putConstraint(springLayout.WEST, loginButton, 110, springLayout.WEST, c);
		
		c.add(promptRegister);//账号未注册提示
		promptRegister.setVisible(false);
	    springLayout.putConstraint(springLayout.NORTH, promptRegister, 41, springLayout.SOUTH, logoLabel);
		springLayout.putConstraint(springLayout.WEST, promptRegister, 5, springLayout.EAST, userjt);
		c.add(promptUserNameEmpty);//请输入账号
		promptUserNameEmpty.setVisible(false);
	    springLayout.putConstraint(springLayout.NORTH, promptUserNameEmpty, 41, springLayout.SOUTH, logoLabel);
		springLayout.putConstraint(springLayout.WEST, promptUserNameEmpty, 5, springLayout.EAST, userjt);
		
		c.add(promptPasswordFalse);//密码错误提示
		promptPasswordFalse.setVisible(false);
		springLayout.putConstraint(springLayout.NORTH, promptPasswordFalse, 20, springLayout.SOUTH, promptRegister);
		springLayout.putConstraint(springLayout.WEST, promptPasswordFalse, 5, springLayout.EAST, passwordjt);
		c.add(prompPasswordEmpty);//密码为空提示
		prompPasswordEmpty.setVisible(false);
		springLayout.putConstraint(springLayout.NORTH, prompPasswordEmpty, 20, springLayout.SOUTH, promptRegister);
		springLayout.putConstraint(springLayout.WEST, prompPasswordEmpty, 5, springLayout.EAST, passwordjt);
		
		//设置文本框鼠标点击事件
		userjt.addMouseListener(new MouseAdapter() {//文本框
			public void mouseClicked(MouseEvent e) {
				userjt.setText("");
			}
		});
		passwordjt.addMouseListener(new MouseAdapter() {//密码框
			public void mouseClicked(MouseEvent e) {
				passwordjt.setText("");
			}
		});
		
		//设置登陆按钮单击事件
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = userjt.getText().trim();//获取用户输入的账号和密码
				String Password = new String(passwordjt.getPassword()).trim();
				//判断账号和密码
			    if(userName.length() != 0) {//用户名不为空
			    	promptUserNameEmpty.setVisible(false);//关闭账号为空显示
			    	if(Password.length() != 0) {//密码不为空
			    		if(f.readData("user.xls", userName) && Password.equals(f.backData("user.xls", userName, "password"))) {//用户输入的账号和密码正确
							promptRegister.setVisible(false);//隐藏提示信息
							promptPasswordFalse.setVisible(false);
							prompPasswordEmpty.setVisible(false);
							loginButton.setText("                登 陆 中...               ");
							new Chessboard();//跳转到五子棋棋盘页面
							dispose();//销毁当前页面
						}
			    		else if( f.readData("user.xls", userName) && !Password.equals(f.backData("user.xls", userName, "password"))) {//用户输入密码错误
							promptPasswordFalse.setVisible(true);//显示密码错误提示
							promptRegister.setVisible(false);
							prompPasswordEmpty.setVisible(false);
							passwordjt.setText("");//密码框清空
							passwordjt.requestFocus();//光标定位到密码框
						}else {//账号还未注册
							promptRegister.setVisible(true);
					    	promptPasswordFalse.setVisible(false);
							prompPasswordEmpty.setVisible(false);
						}
			        }
			        else {//密码为空
			        	if(userName.equals("admin")) {//用户名已经注册， 提示输入密码
			        		prompPasswordEmpty.setVisible(true);
				        	promptUserNameEmpty.setVisible(false);
				        	promptRegister.setVisible(false);
					    	promptPasswordFalse.setVisible(false);
			        	}else {//用户名未注册
			        		prompPasswordEmpty.setVisible(false);
				        	promptUserNameEmpty.setVisible(false);
				        	promptRegister.setVisible(true);
					    	promptPasswordFalse.setVisible(false);
			        	}
			        	
			        }
			    }else {//用户名为空
			    	promptUserNameEmpty.setVisible(true);//提示输入账号
			    	promptRegister.setVisible(false);
			    	promptPasswordFalse.setVisible(false);
			    	prompPasswordEmpty.setVisible(false);
			    	passwordjt.setText("");//将密码框置为空
			    	if(Password.length() == 0) {//密码为空
			    		prompPasswordEmpty.setVisible(true);
			    		promptRegister.setVisible(false);
				    	promptPasswordFalse.setVisible(false);
			    	}
			    }
			}
		});
		
		//注册标签监听器
		registerLabel.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
                dispose();
				new Register();
			}
			public void mouseEntered(MouseEvent e) {
				registerLabel.setForeground(Color.red);;
			}
			public void mouseExited(MouseEvent e) {
			    registerLabel.setForeground(Color.black);
			}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		});
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
        new Main();
	}

}
