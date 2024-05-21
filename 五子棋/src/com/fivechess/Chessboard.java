package com.fivechess;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.*;
import java.util.Random;

public class Chessboard extends JFrame{

	/*
	 * 棋盘页面
	 */
    /**************************     变量定义区域             ****************************************/
	private static final long serialVersionUID = 1L;
	final JLabel userNameLabel = new JLabel("账号:");
	final JLabel userName = new JLabel();
	final JLabel pointsLabel = new JLabel("积分:");
	final JLabel classLabel = new JLabel("等级:");
	final JLabel headImage = new JLabel();
	final JLabel winproLabel = new JLabel("胜率:");
	final JButton newRound = new JButton("新局");
	final JButton back = new JButton("悔棋");
	final JButton returnback = new JButton("返回");
	final JButton exit = new JButton("退出");
	final Color colorLightYellow = Color.WHITE;
	final Color colorHeavry = Color.WHITE;
	final DrawPanel drawPanel = new DrawPanel();
	final JPanel board = new JPanel();
	final JLabel logotext = new JLabel("五子棋");
	final JLabel logoImage = new JLabel();
	final JLabel difficulityLabel = new JLabel("难度:");
	private JComboBox<String> difficulityClass = new JComboBox<>();
	final JLabel selectChessLabel = new JLabel("棋色选择:");
	final JRadioButton whiteChessjr = new JRadioButton();//白棋
	final JLabel whiteChessLabel = new JLabel();
	final JRadioButton blackChessjr = new JRadioButton();//黑棋
	final JLabel blackChessLabel = new JLabel();
	final ButtonGroup buttongroup = new ButtonGroup();
	final Random r = new Random();//用于产生随机数
	final FileOperation f = new FileOperation();//实例化文件操作对象
	Thread thread;//用线程调用电脑和电脑下棋
	SpringLayout springLayout = new SpringLayout();
	Image image = getToolkit().getImage(Chessboard.class.getResource("/image/background.jpg"));
	Image happy = getToolkit().getImage(Chessboard.class.getResource("/image/happy1.png"));
	Image win = getToolkit().getImage(Chessboard.class.getResource("/image/win.png"));
	Image lose = getToolkit().getImage(Chessboard.class.getResource("/image/lose.png"));
	Image white = getToolkit().getImage(Chessboard.class.getResource("/image/whiteChess.png"));
	Image black = getToolkit().getImage(Chessboard.class.getResource("/image/blackChess.png"));
	Image star = getToolkit().getImage(Chessboard.class.getResource("/image/star.png"));
	Image moon= getToolkit().getImage(Chessboard.class.getResource("/image/moon.png"));
	Image sun = getToolkit().getImage(Chessboard.class.getResource("/image/sun.png"));
	int flag = 0;//行列标记数组下标
	int winFLAG = 0;//棋子连接数量达到5个的标志
	int playerColor = -1;//标记玩家棋子颜色
	int computerColor = -1;//标记电脑棋子颜色
	int CHESSCOLOR = 1;//棋子颜色。在计算棋子是否连成一行时用到
	int player = 1;//玩家下棋标志
	int computer = 0;//电脑下棋标志
	int chessboardEmpty = 0;//棋盘为空标记
	int dogfall = 0;//平局标记，若平局标记在最后变为0，则表示没有执行检测循环，表示玩家和电脑平局
	int newchessX = 0;//新棋子坐标
	int newchessY = 0;
	int x, y;
	long pointsNum = 0;//从文件中获取积分
	double gamewinNum = 0.0;//从文件中获取获胜局数
	double gameNum = 0.0;//获取总对局数目
	int winNum = 0;//胜率
	int starNum = 0;//定义需要的数目
	int moonNum = 0;
	int sunNum = 0;
	int classNum  = 0;//获取等级
	int comeX = 0; //用于在判断棋盘是否有同一方棋子连成五个
	int comeY = 0;
	int toX = 0; 
	int toY = 0;
	int winX = 0;//标记赢的方向和坐标
	int winY = 0;
	int winWay = 0;
	int t = 0, s = 0;
	int count = 0;
	int depth = 0;//计算棋盘搜索的深度
	int judgeFlag = 0;//是否调用judge函数的标志
	int map[][] = new int[15][15]; {//0表示无子，1表示白子， 2表示黑子
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				map[i][j] = 0;
			}
		}
	}
	int mapflag[][]= new int[15][15];{//位置标记数组,0表示无子，1表示有子
		for(int i = 0; i < mapflag.length; i++) {
			for(int j = 0; j < mapflag[i].length; j++) {
				map[i][j] = 0;
			}
		}
	}
	int promptBoxFlag[][] = new int[15][15]; {//提示框标记，鼠标划过棋盘显示提示方框
		for(int i = 0; i < promptBoxFlag.length; i++) {
    		for(int j = 0; j < promptBoxFlag[i].length; j++) {
    			promptBoxFlag[i][j] = 0;
    		}
    	}
	};
    int imapflag[] = new int[225];{//列标记数组
    	for(int i = 0; i < imapflag.length; i++) {
    		imapflag[i] = 0;
    	}
    }
    int jmapflag[] = new int[225];{//行标记数组
        for(int j = 0; j < jmapflag.length; j++) {
    	    jmapflag[j] = 0;
        }
    }
    int position[] = new int[] {0, 0};//电脑下棋位置坐标
    
	public Chessboard() {
		super();
		GetClickPosition();//点击棋盘画棋子函数
//		simuPlayer();//模拟玩家
		Container c = getContentPane();
		c.setBackground(colorLightYellow);
		setVisible(true);
		setBounds(300, 40, 1000, 900);
		setTitle("五子棋");
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		c.setLayout(springLayout);
		c.add(drawPanel);
		
		/**************************     组件设置区域             ****************************************/
		ImageIcon logo = new ImageIcon(Chessboard.class.getResource("/image/logo5.jpg"));
		logo.setImage(logo.getImage().getScaledInstance(200, 95, Image.SCALE_DEFAULT));
		logoImage.setIcon(logo);
		logotext.setFont(new Font("微软雅黑", 1, 34));
		logotext.setForeground(new Color(250, 128, 114));
		ImageIcon image = new ImageIcon(Chessboard.class.getResource("/image/image.jpg"));
		headImage.setIcon(image);
		Font font = new Font("微软雅黑", 1, 24);
		userNameLabel.setFont(font);
		userName.setFont(new Font("宋体", 1, 22));
		userName.setText(Main.userjt.getText());
		pointsLabel.setFont(font);
		classLabel.setFont(font);
		winproLabel.setFont(font);
		newRound.setFont(font);
		newRound.setBackground(colorHeavry);
		back.setFont(font);
		back.setBackground(colorHeavry);
		returnback.setFont(font);
		returnback.setBackground(colorHeavry);
		exit.setFont(font);
		exit.setBackground(colorHeavry);
		difficulityLabel.setFont(font);
		difficulityClass.setFont(new Font("微软雅黑", 1, 22));
		difficulityClass.setBackground(colorLightYellow);
		difficulityClass.addItem("初级");
		difficulityClass.addItem("中级");
		difficulityClass.addItem("高级");
		selectChessLabel.setFont(font);
	    whiteChessjr.setFont(new Font("微软雅黑", 1, 22));
	    whiteChessjr.setBackground(colorLightYellow);
	    whiteChessjr.setSelected(true);
	    blackChessjr.setFont(new Font("微软雅黑", 1, 22));
	    blackChessjr.setBackground(colorLightYellow);
	    buttongroup.add(whiteChessjr);
	    buttongroup.add(blackChessjr);
	    
	    //从文件中获取用户信息
	    pointsNum = Integer.parseInt(f.backData("user.xls", userName.getText(), "points"));
	    classNum = Integer.parseInt(f.backData("user.xls", userName.getText(), "class"));
	    gamewinNum = Double.parseDouble(f.backData("user.xls", userName.getText(), "winNum"));
	    gameNum = Double.parseDouble(f.backData("user.xls", userName.getText(), "totalNum"));
	    
		ImageIcon whiteChess = new ImageIcon(Chessboard.class.getResource("/image/whiteChess.png"));
		whiteChess.setImage(whiteChess.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		whiteChessLabel.setIcon(whiteChess);
		ImageIcon blackChess = new ImageIcon(Chessboard.class.getResource("/image/blackChess.png"));
		blackChess.setImage(blackChess.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		blackChessLabel.setIcon(blackChess);

        /**************************     页面布局区域             ****************************************/
		//界面布局
		c.add(logoImage);//logoImage图片
		springLayout.putConstraint(springLayout.NORTH, logoImage, 40, springLayout.NORTH, c);
		springLayout.putConstraint(springLayout.WEST, logoImage, 10, springLayout.WEST, c);
		c.add(headImage);//头像
		springLayout.putConstraint(springLayout.NORTH, headImage, 200, springLayout.NORTH, c);
		springLayout.putConstraint(springLayout.WEST, headImage, 15, springLayout.WEST, c);
		
		c.add(userNameLabel);//账号
		springLayout.putConstraint(springLayout.NORTH, userNameLabel, 30, springLayout.SOUTH, headImage);
		springLayout.putConstraint(springLayout.WEST, userNameLabel, 15, springLayout.WEST, c);
		c.add(userName);
		springLayout.putConstraint(springLayout.NORTH, userName, 35, springLayout.SOUTH, headImage);
		springLayout.putConstraint(springLayout.WEST, userName, 6, springLayout.EAST, userNameLabel);
		
		c.add(pointsLabel);//积分
		springLayout.putConstraint(springLayout.NORTH, pointsLabel, 20, springLayout.SOUTH, userNameLabel);
		springLayout.putConstraint(springLayout.WEST, pointsLabel, 15, springLayout.WEST, c);
		
		c.add(classLabel);//等级
		springLayout.putConstraint(springLayout.NORTH, classLabel, 20, springLayout.SOUTH, pointsLabel);
		springLayout.putConstraint(springLayout.WEST, classLabel, 15, springLayout.WEST, c);
		
		c.add(winproLabel);//胜率
		springLayout.putConstraint(springLayout.NORTH, winproLabel, 20, springLayout.SOUTH, classLabel);
		springLayout.putConstraint(springLayout.WEST, winproLabel, 15, springLayout.WEST, c);
		
		c.add(difficulityLabel);//难度下拉框
		springLayout.putConstraint(springLayout.NORTH, difficulityLabel, 20, springLayout.SOUTH, winproLabel);
		springLayout.putConstraint(springLayout.WEST, difficulityLabel, 15, springLayout.WEST, c);
		c.add(difficulityClass);
		springLayout.putConstraint(springLayout.NORTH, difficulityClass, 640, springLayout.NORTH, c);
		springLayout.putConstraint(springLayout.WEST, difficulityClass, 6, springLayout.EAST, difficulityLabel);
		
		c.add(newRound);//新局
		springLayout.putConstraint(springLayout.NORTH, newRound, 780, springLayout.NORTH, c);
		springLayout.putConstraint(springLayout.WEST, newRound, 320, springLayout.WEST, c);
		c.add(back);//悔棋
		springLayout.putConstraint(springLayout.NORTH, back, 780, springLayout.NORTH, c);
		springLayout.putConstraint(springLayout.WEST, back, 80, springLayout.EAST, newRound);
		c.add(returnback);//返回
		springLayout.putConstraint(springLayout.NORTH, returnback, 780, springLayout.NORTH, c);
		springLayout.putConstraint(springLayout.WEST, returnback, 80, springLayout.EAST, back);
		c.add(exit);//退出
		springLayout.putConstraint(springLayout.NORTH, exit, 780, springLayout.NORTH, c);
		springLayout.putConstraint(springLayout.WEST, exit, 80, springLayout.EAST, returnback);
		
		c.add(selectChessLabel);//棋色选择
		springLayout.putConstraint(springLayout.NORTH, selectChessLabel, 108, springLayout.SOUTH, difficulityLabel);
		springLayout.putConstraint(springLayout.WEST, selectChessLabel, 15, springLayout.WEST, c);
		c.add(whiteChessjr);//白棋单选框
		springLayout.putConstraint(springLayout.NORTH, whiteChessjr, 111, springLayout.SOUTH, difficulityClass);
		springLayout.putConstraint(springLayout.WEST, whiteChessjr, 6, springLayout.EAST, selectChessLabel);
		c.add(whiteChessLabel);//白棋图片
		springLayout.putConstraint(springLayout.NORTH, whiteChessLabel, 96, springLayout.SOUTH, difficulityClass);
		springLayout.putConstraint(springLayout.WEST, whiteChessLabel, 6, springLayout.EAST, whiteChessjr);
		c.add(blackChessjr);//黑棋单选框
		springLayout.putConstraint(SpringLayout.NORTH, blackChessjr, 111, springLayout.SOUTH, difficulityClass);
		springLayout.putConstraint(springLayout.WEST, blackChessjr, 6, springLayout.EAST, whiteChessLabel);
		c.add(blackChessLabel);//黑棋图片
		springLayout.putConstraint(springLayout.NORTH, blackChessLabel, 96, springLayout.SOUTH, difficulityClass);
		springLayout.putConstraint(springLayout.WEST, blackChessLabel, 6, springLayout.EAST, blackChessjr);
		
		/**************************     鼠标监听器区域             ****************************************/
		//为棋色选择添加事件监听器
		whiteChessLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(chessboardEmpty == 0) {//只有棋盘为空的时候才能选择棋子颜色
				    whiteChessjr.setSelected(true);
				}
			}
		});
		blackChessLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(chessboardEmpty == 0) {//只有棋盘为空的时候才能选择棋子颜色
				    blackChessjr.setSelected(true);
				}
			}
		});
		//为新局按钮添加事件监听器
		newRound.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i < map.length; i++) {//将map数组置0
					for(int j = 0; j < map[i].length; j++) {
						map[i][j] = 0;
						mapflag[i][j] = 0;
					}
				}
				for(int j = 0; j < 225; j++) {//将悔棋标记数组置为0
					imapflag[j] = 0;
					jmapflag[j] = 0;
				}
				flag = 0;//行列标记数组下表置0
				winFLAG = 0;//输赢标记置0
				playerColor = -1;//玩家棋色标记置-1
				computerColor = -1;//电脑棋色标记为-1
				chessboardEmpty = 0;//棋盘标记为空
				player = 1;//玩家先下棋
				computer = 0;//电脑后下
				newchessX = 0;//新棋子标记置0
				newchessY = 0;
				depth = 0;
				repaint();
			}
		});
		//为悔棋添加事件监听器
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				if(flag - 1 >= 0) {//棋盘上面有棋子的时候, 点击一次棋盘上面少两颗棋子，一颗是自己的，另一颗是电脑的
					for(int i = flag - 1; i > flag - 3; i--) {
						map[imapflag[i]][jmapflag[i]] = 0;
						mapflag[imapflag[i]][jmapflag[i]] = 0;
						imapflag[i] = 0;//将坐标存放在悔棋标记数组中
						jmapflag[i] = 0;
					}
					flag = flag - 2;//表示每次悔棋棋盘上双方均少一颗子
					winFLAG = 0;
					if(flag - 1 >= 0) {
						newchessX = imapflag[flag - 1];
						newchessY = jmapflag[flag - 1];
					}
					if(flag == 0) {//表示棋盘为空
						chessboardEmpty = 0;//棋盘为空
						playerColor = -1;//玩家和电脑棋子颜色置0
						computerColor = -1;
						depth = 0;
					}
					repaint();
				}else {
					;
				}
					
			}
		});
		//返回按钮添加事件监听器
		returnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Main();
			}
		});
		//退出按钮事件监听器
		exit.addActionListener(new ActionListener() {//点击退出按钮退出程序
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		//判断玩家和电脑的棋子颜色
		
	}
	
	/**************************     棋盘事件监听区域             ****************************************/
	public void GetClickPosition() {
		//鼠标点击事件
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//判断玩家和电脑颜色
				if(whiteChessjr.isSelected()) {//玩家选择白棋子
					playerColor = 1;
					computerColor = 2;
				}else {
					playerColor = 2;
					computerColor = 1;
				}
				x = e.getX();
				y = e.getY();
				if(x >= 247 && x <= 951 && y >=77 && y <= 781) {//如果鼠标点击的点在棋盘内或者边上一点
					double m = (x - 270.0)/47.0;//判断点击位置最靠近的哪个交叉点
					double n = (y - 100.0)/47.0;
					int p = (x - 270)/47;
					int q = (y - 100)/47;
					int i, j;
					if(m - p >= 0.5 || m - p <= -0.5) {
						i = p + 1;
					}else {
						i = p;
					}
					if(n - q >= 0.5 || n - q <= -0.5) {
						j = q + 1;
					}else {
						j = q;
					}
					if(i >=0 && i <= 15 && j >= 0 && j <= 15) {//识别到的区域为棋盘之内
						if(mapflag[i][j] == 0 && winFLAG == 0 && player == 1) {//表示这个地方没有棋子,并且还没有赢
							map[i][j] = playerColor;
							imapflag[flag] = i;//将坐标存放在悔棋标记数组中
							jmapflag[flag] = j;
							flag ++;
							chessboardEmpty = 1;//棋盘标记为有棋子
							player = 0;//玩家下棋标志置0
							computer = 1;//电脑下棋标志
							newchessX = i;//新棋子标记记录新棋子坐标
							newchessY = j;
							judgeFlag = 1;
							repaint();
						}
					}
					int a = Math.max(Math.abs(i - 7), Math.abs(j - 7));//计算该点到中心的最大的距离
					depth = Math.max(depth, a);//不断更新depth的值
				}
			}
		}); 
	    //鼠标进入棋盘区域内,用于显示提示方框，表示点击之后可以在哪个区域内下棋
		addMouseMotionListener(new MouseMotionListener() {
			public void mouseMoved(MouseEvent e) {
				// TODO 自动生成的方法存根
				x = e.getX();
				y = e.getY();
				if(x >= 247 && x <= 951 && y >=77 && y <= 781) {//如果鼠标点击的点在棋盘内或者边上一点
					double m = (x - 270.0)/47.0;//判断点击位置最靠近的哪个交叉点
					double n = (y - 100.0)/47.0;
					int p = (x - 270)/47;
					int q = (y - 100)/47;
					int i, j;
					if(m - p >= 0.5 || m - p <= -0.5) {
						i = p + 1;
					}else {
						i = p;
					}
					if(n - q >= 0.5 || n - q <= -0.5) {
						j = q + 1;
					}else {
						j = q;
					}
					if(i >=0 && i <= 15 && j >= 0 && j <= 15) {//识别到的区域为棋盘之内
						if(mapflag[i][j] == 0 && winFLAG == 0 && player == 1) {//表示这个地方没有棋子,并且还没有赢
							promptBoxFlag[i][j] = 1;
							repaint();
						}
					}
				}		
			}
			public void mouseDragged(MouseEvent e) {}
		});
	}
	
	/**************************     电脑下棋函数            ****************************************/
	private void tuntoComputer() {//电脑下棋
		// TODO 自动生成的方法存根
		if(depth >= 7) {
			depth = 6;
		}
		position = Algorithm.evalute(map, depth, computerColor);//调用估值函数
		map[position[0]][position[1]] = computerColor;
		imapflag[flag] = position[0];//将坐标存放在悔棋标记数组中
		jmapflag[flag] = position[1];
		newchessX = position[0];//新棋子标记记录坐标
		newchessY = position[1];
		int a = Math.max(Math.abs(position[0] - 7), Math.abs(position[1] - 7));//计算该点到中心的最大的距离
		depth = Math.max(depth, a);//不断更新depth的值
		flag ++;
		chessboardEmpty = 1;//棋盘标记为有棋子
		player = 1;//玩家下棋标志置0
		computer = 0;//电脑下棋标志为1
		judgeFlag = 1;
		repaint();
	}
	
	/**************************     绘图类             ****************************************/
	class DrawPanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
        //绘图函数
		public void paint(Graphics g) {
			setBounds(0, 0, 968, 760);
			super.paintComponents(g);
			Graphics2D g2 = (Graphics2D)g;
			g2.drawImage(image, 230, 33, 719, 720, this);//棋盘背景图片
			g2.setStroke(new BasicStroke(3.0f));//设置线条大小
			g2.setColor(Color.red);
			g2.fillOval(395, 197, 15, 15);//第一个 红点
			g2.fillOval(771, 197, 15, 15);//第二个红点
			g2.fillOval(580, 382, 20, 20);//第三个红点//中间红点
			g2.fillOval(395, 573, 15, 15);//第四个红点
			g2.fillOval(771, 573, 15, 15);//第五个红点
			Color color = new Color(210, 105, 30);
			g2.setColor(color);
			/**************************************绘制棋盘***************************************/
			for(int i = 0; i < 15; i++) {//横线
				g2.drawLine(261, i * 47 + 63, 919, i * 47 + 63);
			}
			for(int j = 0; j < 15; j++) {//竖线
				g2.drawLine(j * 47 + 261, 64, j * 47 + 261, 721);
			}
			//绘制棋子
			for(int i = 0; i < map.length; i++) {
				for(int j = 0; j < map[i].length; j++) {
					//白棋
					if(map[i][j] == 1) {
						g2.drawImage(white, i * 47 + 241, j * 47 + 43, 40, 40, this);
						mapflag[i][j] = 1;//标记位置表示这个地方已经有棋子
					}
					//黑棋
					if(map[i][j] == 2) {
						g2.drawImage(black, i * 47 + 241, j * 47 + 43, 40, 40, this);
						mapflag[i][j] = 1;
					}	
				}
			}
			//判断棋子是否连成五个
			if(judgeFlag == 1) {
				judge();
				judgeFlag = 0;
			}
			//绘制新棋子红点标记
			if(chessboardEmpty != 0) {
				g2.setColor(Color.red);
			    g2.fillOval(newchessX * 47 + 254, newchessY * 47 + 55, 15, 15);
			}
			/***************************************绘制鼠标移动方框***********************************/
			for(int i = 0; i < 15; i++) {
				for(int j = 0; j < 15; j++) {
					if(promptBoxFlag[i][j] == 1) {
						g2.setColor(Color.RED);
						g2.setStroke(new BasicStroke(2.5f));//设置线条大小
						g2.drawLine(238 + i * 47, 40 + j * 47, 248 + i * 47, 40 + j * 47);//上左横线
						g2.drawLine(275 + i * 47, 40 + j * 47, 285 + i * 47, 40 + j * 47);//上右横线
						g2.drawLine(238 + i * 47, 40 + j * 47, 238 + i * 47, 50 + j * 47);//左上竖线
						g2.drawLine(285 + i * 47, 40 + j * 47, 285 + i * 47, 50 + j * 47);//右上竖线
						g2.drawLine(238 + i * 47, 77 + j * 47, 238 + i * 47, 87 + j * 47);//左下竖线
						g2.drawLine(285 + i * 47, 77 + j * 47, 285 + i * 47, 87 + j * 47);//右下竖线
						g2.drawLine(238 + i * 47, 87 + j * 47, 248 + i * 47, 87 + j * 47);//下左横线
						g2.drawLine(275 + i * 47, 87 + j * 47, 285 + i * 47, 87 + j * 47);//下右横线
						promptBoxFlag[i][j] = 0;
					}
				}
			}
			for(int i = 0; i < 5; i++) {//右上角星星
				g2.drawImage(happy, 711 + i * 47, 20, 40, 40, null);
			}
			//解决第一次不能显示输赢标志的问题
			g2.drawImage(win, 0, 0, 1, 1, null);
			g2.drawImage(lose, 0, 0, 1, 1, null);
			
			if(winFLAG == 0 && player == 0) {//表示还未分出胜负并且玩家下了，调用电脑下棋
				tuntoComputer();
			}
			/*********************************设置下拉框和单选按钮在棋盘不为空的是否不能进行选择*********************/
			//设置棋子颜色单选框可用状态
			if(chessboardEmpty == 1) {//棋盘不为空
				difficulityClass.setEnabled(false);//设置下拉框不可用
				if(whiteChessjr.isSelected()) {//白棋子单选框被选中
					blackChessjr.setEnabled(false);
					whiteChessjr.setEnabled(true);
				}else {//黑棋子单选框被选中
					blackChessjr.setEnabled(true);
					whiteChessjr.setEnabled(false);
				}
			}else {//棋盘为空
				blackChessjr.setEnabled(true);//释放两个单选框
				whiteChessjr.setEnabled(true);
				difficulityClass.setEnabled(true);//释放下拉框
			}
			
			/**************************************重绘积分，等级，胜率**********************/
			classNum = (int)((int)(pointsNum /100 * 0.4 + gamewinNum * 0.4 + gameNum * 0.2) * 0.8);
			sunNum = (int) (classNum / 100);
			moonNum = (int)(classNum - sunNum * 100) / 50;
			starNum = (int)(classNum - sunNum * 100 - moonNum * 50) / 10;
			for(t = 0; t < sunNum; t++) {//绘画太阳
				g2.drawImage(sun, 75 + t * 30, 538, 30, 30, null);
			}
			for(t = sunNum ; t < moonNum + sunNum; t++) {//绘画月亮
				g2.drawImage(moon, 75 + t * 30, 540, 25, 25, null);
			}
			if(moonNum > 0 || sunNum > 0) {//绘画星星
				for(t = moonNum + sunNum ; t < starNum + moonNum + sunNum; t ++) {
				    g2.drawImage(star, 75 + t * 30, 540, 25, 25, null);
			    }
			}else {
				for(t = moonNum ; t < starNum + 1; t ++) {
				    g2.drawImage(star, 75 + t * 30, 538, 30, 30, null);
			    }
			}
			/*****************************************胜负之后操作************************************************/
			if(winFLAG != 0) {//判断有一方赢了之后
				
				/************************************打印获胜或者失败标志并且计算分数***********************************/
				if(winFLAG == playerColor) {//表示玩家获胜
					g2.drawImage(win, 260, 18, 153, 42, null);
					if(difficulityClass.getSelectedItem().equals("初级")) {//用户选择初级难度按钮
						pointsNum = pointsNum + 100;
					}else if(difficulityClass.getSelectedItem().equals("中级")){//用户选择中级难度
						pointsNum = pointsNum + 200;
					}else {//用户选择高级难度
						pointsNum = pointsNum + 300;
					}
					gamewinNum = gamewinNum + 1.0;
					gameNum = gameNum + 1.0;
				}else {
					g2.drawImage(lose, 260, 18, 153, 42, null);
					gameNum = gameNum + 1.0;
				}
				/**************************************将相关信息写入文件中*********************/
			    f.writeData("user.xls", userName.getText(), "points", String.valueOf(pointsNum));
			    f.writeData("user.xls", userName.getText(), "class", String.valueOf(classNum));
			    f.writeData("user.xls", userName.getText(), "winNum", Integer.toString((int)gamewinNum));
			    f.writeData("user.xls", userName.getText(), "totalNum", Integer.toString((int)gameNum));
				
				/***************************************绘制笑脸标记**********************************/
				int m = 0, n = 0;
				if(winWay == 1) {//表示横向胜利
					for(m = winX; m < winX + 5; m ++) {//绘制笑脸标记
				        g2.drawImage(happy, m * 47 + 241, winY * 47 + 42, 40, 40, this);
			        }
				}else if(winWay == 2) {//表示纵向胜利
					for(m = winY; m < winY + 5; m ++) {//绘制笑脸标记
				        g2.drawImage(happy, winX * 47 + 241, m * 47 + 42, 40, 40, this);
			        }
				}else if(winWay == 3) {//表示左上到右下胜利
					for(m = winX, n = winY; m < winX + 5; m ++, n++) {//绘制笑脸标记
				        g2.drawImage(happy, m * 47 + 241, n * 47 + 42, 40, 40, this);
			        }
				}else {//表示右上到左下胜利
					for(m = winX, n = winY; n < winY + 5; m -- , n ++) {//绘制笑脸标记
				        g2.drawImage(happy, m * 47 + 241, n * 47 + 42, 40, 40, this);
			        }
				}
			}
			
			/***********************************绘制积分和胜率********************************/
			g2.setFont(new Font("微软雅黑", 1, 22 ));
			g2.setColor(Color.black);
			g2.drawString(String.valueOf((int)pointsNum), 75, 509);//分数
			winNum = (int) Math.rint(gamewinNum / gameNum * 100);//计算胜率
			if(gameNum == 0) {//对局数为0
				g2.drawString("0%", 75, 617);
			}else {
				g2.drawString(String.valueOf(winNum) + "%", 75, 616);
			}
		}
	}
	
	/********************************判断棋子是否连成五个**********************************/
	public void judge() {
		for(t = newchessX,s = newchessY,count = 0; t >=0 && s >= 0 && count <= 4; t--,s--,count++) {
			comeX = t;
			comeY = s;
		}
		for(t = newchessX, s = newchessY, count = 0; t <=14 && s >= 0 && count <= 4; t++, s--, count++) {
			toX = t;
			toY = s;
		}
		if(winFLAG == 0) {
			for(int ch = 1; ch <=2; ch++) {
				CHESSCOLOR = ch;
				//判断横向棋子
				for(s = (newchessX - 4) >=0 ? (newchessX - 4) : 0 ; s <= newchessX; s++) {//表示玩家获胜
				    t = newchessY;
					if(map[s][t] == CHESSCOLOR && s < 11) {//行棋子数量计算
						if(map[s + 1][t] == CHESSCOLOR) {
							if(map[s + 2][t] == CHESSCOLOR) {
								if(map[s + 3][t] == CHESSCOLOR) {
									if(map[s + 4][t] == CHESSCOLOR) {
										winX = s;
										winY = t;
										winWay = 1;
										if(CHESSCOLOR == 1) {//白棋
											winFLAG = 1;
										}else {//黑棋
											winFLAG = 2;
										}
										break;
									}
								}
							}
						}
					}
				}
				if(winFLAG != 0) {//如果某一方赢了就直接退出
					break;
				}
			//判断列项棋子
				for(t = (newchessY - 4) >=0 ? (newchessY - 4) : 0 ; t <= newchessY; t ++) {
					s = newchessX;
					if(map[s][t] == CHESSCOLOR && t < 11) {//列棋子数量计算
						if(map[s][t + 1] == CHESSCOLOR) {
							if(map[s][t + 2] == CHESSCOLOR) {
								if(map[s][t + 3] == CHESSCOLOR) {
									if(map[s][t + 4] == CHESSCOLOR) {
										winX = s;
										winY = t;
										winWay = 2;
										if(CHESSCOLOR == 1) {//白棋
											winFLAG = 1;
										}else {//黑棋
											winFLAG = 2;
										}
										break;
									}
								}
							}
						}
					}
				}
				if(winFLAG != 0) {//如果某一方赢了就直接退出
					break;
				}
			//判断左上到右下棋子
				for(s = comeX, t = comeY; s <= newchessX && t <= newchessY; s ++, t++) {
					if(map[s][t] == CHESSCOLOR && s < 11 && t < 11) {//斜下棋子数量计算
						if(map[s + 1][t + 1] == CHESSCOLOR) {
							if(map[s + 2][t + 2] == CHESSCOLOR) {
								if(map[s + 3][t + 3] == CHESSCOLOR) {
									if(map[s + 4][t + 4] == CHESSCOLOR) {
										winX = s;
										winY = t;
										winWay = 3;
										if(CHESSCOLOR == 1) {//白棋
											winFLAG = 1;
										}else {//黑棋
											winFLAG = 2;
										}
										break;
									}
								}
							}
						}
					}
				}
				if(winFLAG != 0) {//如果某一方赢了就直接退出
					break;
				}
			//判断右上到左下棋子
				for(s = toX, t = toY; s >= newchessX && t <= newchessY; s --, t++) {
					if(map[s][t] == CHESSCOLOR && s >= 4 && t < 11) {//斜上棋子数量计算
						if(map[s - 1][t + 1] == CHESSCOLOR) {
							if(map[s - 2][t + 2] == CHESSCOLOR) {
								if(map[s - 3][t + 3] == CHESSCOLOR) {
									if(map[s - 4][t + 4] == CHESSCOLOR) {
										winX = s;
										winY = t;
										winWay = 4;
										if(CHESSCOLOR == 1) {//白棋
											winFLAG = 1;
										}else {//黑棋
											winFLAG = 2;
										}
										break;
									}
								}
							}
						}
					}
				}
				if(winFLAG != 0) {
					break;
				}
			}
		}
	}
}

