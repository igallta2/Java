package com.fivechess;

import java.util.Random;

public class Algorithm {

	//返回棋盘上某个空点的分数
	public static int countScore(int map[][], int X, int Y, int computerColor) {
		int sum = 0;
		int count = 0;
		int value[] = new int[] {0, 0, 0, 0};
		int upcount[] = new int[] {0, 0, 0, 0};
		int downcount[] = new int[] {0, 0, 0, 0};
		int upflag[] = new int[] {0, 0, 0, 0};
		int downflag[] = new int[] {0, 0, 0, 0};
		for(int color = 1; color <= 2; color++) {//计算双方的分数
			
			map[X][Y] = color;//先将该点放白子
			/*******************************************计算横向棋子***********************/
			for(int i = X - 1; i >=0; i--) {//计算左边棋子数量
				if(map[i][Y] == color) {
					upcount[0]++;
				}else if(map[i][Y] != 0 && map[i][Y] != color) {//表示有对方棋子
					upflag[0] = -1;
					break;
				}else {//表示为空
					upflag[0] = 1;
					if(i - 1 >= 0 && map[i][Y] == 0) {
						upflag[0] = 2;//表示两个空格
					}else {
						break;
					}
					if(i - 2 >= 0 && map[i][Y] == 0) {
						upflag[0] = 3;//表示有三个空格
					}else {
						break;
					}
					break;
				}
			}
			for(int j = X + 1; j <= 14; j++) {//计算右边棋子数量
				if(map[j][Y] == color) {
					downcount[0]++;
				}else if(map[j][Y] != 0 && map[j][Y] != color) {
					downflag[0] = -1;
					break;
				}else {//表示为空
					downflag[0] = 1;
					if(j + 1 <= 14 && map[j][Y] == 0) {
						downflag[0] = 2;
					}else {
						break;
					}
					if(j + 2 <= 14 && map[j][Y] == 0) {
						downflag[0] = 3;
					}else {
						break;
					}
					break;
				}
			}

			/******************************************************计算列项棋子***************************************/
			for(int i = Y - 1; i >= 0; i--) {//计算方向向上
				if(map[X][i] == color) {
					upcount[1]++;
				}else if(map[X][i] != 0 && map[X][i] != color) {//表示该点是对方棋子
					upflag[1] = -1;
					break;
				}else {//表示为空
					upflag[1] = 1;
					if(i - 1 >= 0 && map[X][i] == 0) {
						upflag[1] = 2;
					}else {
						break;
					}
					if(i - 2 >= 0 && map[X][i] == 0) {
					    upflag[1] = 3;
					}else {
						break;
					}
					break;
				}
			}
			for(int j = Y + 1; j <= 14; j++) {//计算方向向下
				if(map[X][j] == color) {
					downcount[1]++;
				}else if(map[X][j] != 0 && map[X][j] != color) {//表示该点是对方棋子
					downflag[1] = -1;
					break;
				}else {//表示为空
					downflag[1] = 1;
					if(j + 1 >= 0 && map[X][j] == 0) {
						downflag[1] = 2;
					}else {
						break;
					}
					if(j + 2 >= 0 && map[X][j] == 0) {
					    downflag[1] = 3;
					}else {
						break;
					}
					break;
				}
			}
			
			/****************************************************计算斜向下棋子*********************************************/
			int i = 0;
			int j = 0;
			for(i = X - 1, j = Y - 1; i >= 0 && j >= 0; i--, j--) {//计算斜向上
				if(map[i][j] == color) {
					upcount[2]++;
				}else if(map[i][j] != 0 && map[i][j] != color) {
					upflag[2] = -1;
					break;
				}else {//为空
					upflag[2] = 1;
					if(i - 1 >= 0 && j - 1 >= 0 && map[i][j] == 0) {
						upflag[2] = 2;
					}else {
						break;
					}
					if(i - 2 >= 0 && j - 2 >= 0 && map[i][j] == 0) {
						upflag[2] = 3;
					}else {
						break;
					}
					break;
				}
			}
			for(i = X + 1, j = Y + 1; i <= 14 && j <= 14; i++, j++) {//计算斜向下
				if(map[i][j] == color) {
					downcount[2]++;
				}else if(map[i][j] != 0 && map[i][j] != color) {
					downflag[2] = -1;
					break;
				}else {//为空
					downflag[2] = 1;
					if(i + 1 <= 14 && j + 1 <= 14 && map[i][j] == 0) {
						downflag[2] = 2;
					}else {
						break;
					}
					if(i + 2 <= 14 && j + 2 <= 14 && map[i][j] == 0) {
						downflag[2] = 3;
					}else {
						break;
					}
					break;
				}
			}
			
			/****************************************************计算斜向上棋子*************************************************/
			for(i = X + 1, j = Y - 1; i <= 14 && j >= 0; i++, j--) {
				if(map[i][j] == color) {
					upcount[3]++;
				}else if(map[i][j] != 0 && map[i][j] != color) {
					upflag[3] = -1;
					break;
				}else {
					upflag[3] = 1;
					if(i + 1 <= 14 && j - 1 >= 0 && map[i][j] == 0) {
						upflag[3] = 2;
					}else {
						break;
					}
					if(i + 2 <= 14 && j - 2 >= 0 && map[i][j] == 0) {
						upflag[3] = 3;
					}else {
						break;
					}
					break;
				}
			}
			for(i = X - 1, j = Y + 1; i >= 0 && j <= 14; i--, j++) {//计算斜向下
				if(map[i][j] == color) {
					downcount[3]++;
				}else if(map[i][j] != 0 && map[i][j] != color) {
					downflag[3] = -1;
					break;
				}else {//为空
					downflag[3] = 1;
					if(i - 1 >= 0 && j + 1 <= 14 && map[i][j] == 0) {
						downflag[3] = 2;
					}else {
						break;
					}
					if(i - 2 >= 0 && j + 2 <= 14 && map[i][j] == 0) {
						downflag[3] = 3;
					}else {
						break;
					}
					break;
				}
			}
			//数据处理
			if(map[X][Y] == computerColor) {//如果是电脑方的话分数要高一点
				for(i =0; i < 4; i++) {
					count = upcount[i] + downcount[i] + 1;
					if(count == 5) {//成五
						value[i] = 40000;
					}else if(count == 4) {
						if(upflag[i] >= 1 && downflag[i] >= 1) {//活四
							value[i] = 19000;
						}
						if((upflag[i] >= 1 && downflag[i] == -1) || (upflag[i] == -1 && downflag[i] >= 1)) {//眠四
							value[i] = 3000;
						}
						if(upflag[i] == -1 && downflag[i] == -1) {//死四
							value[i] = -50;
						}
						
					}else if(count == 3) {
						if((upflag[i] >= 2 && downflag[i] >= 1) || (upflag[i] >= 1 && downflag[i] >= 2)) {//活三
							value[i] = 4000;
						}
						if((upflag[i] >= 2 && downflag[i] == -1) || (upflag[i] == -1 && downflag[i] >= 2) ||
								(upflag[i] == 1 && downflag[i] == 1)){//眠三
							value[i] = 800;
						}
						if(upflag[i] == -1 && downflag[i] == -1) {//死三
							value[i] = -50;
						}
					}else if(count == 2) {
						if((upflag[i] >= 1 && downflag[i] >= 3) || (upflag[i] >=2 && downflag[i] >= 2) || 
								(upflag[i] >= 3 && downflag[i] >= 1)) {//活二
							value[i] = 1050;
						}
						if((upflag[i] == -1 && downflag[i] >= 3) || (upflag[i] >= 3 && downflag[i] == -1) ||
								(upflag[i] == 2 && downflag[i] == 1) || (upflag[i] == 1 && downflag[i] == 2)) {//眠二
							value[i] = 350;
						}
						if(upflag[i] == -1 && downflag[i] == -1) {//死二
							value[i] = -50;
						}
					}else {
						if((upflag[i] >= 2 && downflag[i] >= 3) || (upflag[i] >= 3 && downflag[i] >= 2)) {//活1
							value[i] = 80;
						}
						if((upflag[i] == 2 && downflag[i] == 2) || (upflag[i] == 1 && downflag[i] == 3) ||
								(upflag[i] == 3 && downflag[i] == 1)) {//眠1
							value[i] = 20;
						}
						if((upflag[i] <= 1 && downflag[i] <= 2) || (upflag[i] <= 2 && downflag[i] <= 1)) {
							value[i] = -50;
						}
					}
				}
			}else {
				for(i =0; i < 4; i++) {
					count = upcount[i] + downcount[i] + 1;
					if(count == 5) {//成五
						value[i] = 30000;
					}else if(count == 4) {
						if(upflag[i] >= 1 && downflag[i] >= 1) {//活四
							value[i] = 15000;
						}
						if((upflag[i] >= 1 && downflag[i] == -1) || (upflag[i] == -1 && downflag[i] >= 1)) {//眠四
							value[i] = 2500;
						}
						if(upflag[i] == -1 && downflag[i] == -1) {//死四
							value[i] = -50;
						}
						
					}else if(count == 3) {
						if((upflag[i] >= 2 && downflag[i] >= 1) || (upflag[i] >= 1 && downflag[i] >= 2)) {//活三
							value[i] = 3000;
						}
						if((upflag[i] >= 2 && downflag[i] == -1) || (upflag[i] == -1 && downflag[i] >= 2) ||
								(upflag[i] == 1 && downflag[i] == 1)){//眠三
							value[i] = 500;
						}
						if(upflag[i] == -1 && downflag[i] == -1) {//死三
							value[i] = -50;
						}
					}else if(count == 2) {
						if((upflag[i] >= 1 && downflag[i] >= 3) || (upflag[i] >=2 && downflag[i] >= 2) || 
								(upflag[i] >= 3 && downflag[i] >= 1)) {//活二
							value[i] = 650;
						}
						if((upflag[i] == -1 && downflag[i] >= 3) || (upflag[i] >= 3 && downflag[i] == -1) ||
								(upflag[i] == 2 && downflag[i] == 1) || (upflag[i] == 1 && downflag[i] == 2)) {//眠二
							value[i] = 150;
						}
						if((upflag[i] == -1 && downflag[i] == -1) || (upflag[i] == 1 && downflag[i] == 1) ||
								(upflag[i] == -1 && downflag[i] == 2) || (upflag[i] == 2 && downflag[i] == -1)) {//死二
							value[i] = -50;
						}
					}else {
						if((upflag[i] >= 2 && downflag[i] >= 3) || (upflag[i] >= 3 && downflag[i] >= 2)) {//活1
							value[i] = 50;
						}
						if((upflag[i] == 2 && downflag[i] == 2) || (upflag[i] == 1 && downflag[i] == 3) ||
								(upflag[i] == 3 && downflag[i] == 1)) {//眠1
							value[i] = 10;
						}
						if((upflag[i] <= 1 && downflag[i] <= 2) || (upflag[i] <= 2 && downflag[i] <= 1)||
								(upflag[i] <= 3 && downflag[i] == -1)|| (upflag[i] == -1 && downflag[i] <= 3)) {
							value[i] = -50;
						}
					}
				}
			}
			for(i = 0; i < 4; i++) {
				sum += value[i];
				value[i] = 0;
				upcount[i] = 0;
				downcount[i] = 0;
				upflag[i] = 0;
				downflag[i] = 0;
			}	
		}
		map[X][Y] = 0;
		return sum;
	}
	
	//估值算法,返回一个数组，用于记录坐标
	public static int[] evalute(int map[][], int depth, int computerColor) {
		int maxscore = 0;
		Random r = new Random();
		int pos[][] = new int[10][2];{
			for(int i = 0; i < pos.length; i++) {
				for(int j = 0; j < pos[i].length; j++) {
					pos[i][j] = 0;
				}
			}
		}
		int FLAG = 0;
		int score[][] = new int[15][15];{//初始化计分数组
			for(int i = 0; i < 15; i++) {
				for(int j = 0; j < 15; j++) {
					score[i][j] = 0;
				}
			}
		}
		int position[] = new int[]{0, 0};//初始化位置坐标数组
		for(int i = 6 - depth; i <= 8 + depth && i <= 14; i++) {//搜索横坐标
			for(int j = 6 - depth; j <= 8 + depth && j <= 14; j++) {//搜索纵坐标
				if(map[i][j] == 0) {//表示该点在棋盘上面为空
					score[i][j] = countScore(map, i, j, computerColor);
					if(maxscore < score[i][j]) {
						maxscore = score[i][j];//记录当前棋盘分数的最大值
					}
				}
			}
		}
		for(int i = 6 - depth; i <= 8 + depth && i <= 14; i++) {
			for(int j = 6 - depth; j <= 8 + depth && j <= 14; j++) {
				if(score[i][j] == maxscore) {
					pos[FLAG][0] = i;
					pos[FLAG++][1] = j;
				}
			}
		}
		int m = r.nextInt(FLAG);
		position[0] = pos[m][0];
		position[1] = pos[m][1];
		return position;
	}
	
	//极大极小值算法
	public int minimax(int map[][], int chessColor) {
		return chessColor;
		
	}
	
	//alpha beta剪枝
	public void alphaBetaCutting(int map[][], int chessColor){
		
	}
}
