package com.fivechess;

import java.io.File;
import java.io.IOException;
import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class FileOperation {
    //创建excel文件
	public void creatExcel(String path) {
		String data[] = { "Num","userName", "password", "points", "class",
				"winNum", "totalNum", "RememberPassword", "AutoLogin", "date"};
		try {  
            File file = new File(path);
            WritableWorkbook book = Workbook.createWorkbook(file); 
            WritableSheet sheet = book.createSheet("用户信息", 0); 
            for(int i = 0; i < data.length; i++) {//将信息写入xls文件中
            	Label label = new Label(i, 0, data[i]);
            	sheet.addCell(label);
            }
            book.write();  
            book.close();  
  
        } catch (Exception e) {  
            System.out.println(e);  
        }  
    }  
	
	//用于判断账号是否存在
	public boolean readData(String path, String userName) {
		File file = new File(path);
		if(!file.exists()) {//如果文件不存在
			creatExcel("user.xls");//创建文件
		}
		Workbook workbook = null;
		Sheet sheet = null;
		Cell cell = null;
		boolean flag = false;
		try {
			workbook = Workbook.getWorkbook(file);
			sheet = workbook.getSheet(0);
			for(int i = 0; i < sheet.getRows(); i ++) {
				cell = sheet.getCell(1, i);
				String content = cell.getContents();//获取内容
				if(content.equals(userName)) {
					flag = true;
					break;
				}
			}
			workbook.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	//将用户将信息写入文件中
	public void writeData(String path, String userName, String keyword, String data) {
		File file = new File(path);//创建文件对象
		if(!file.exists()) {//如果文件不存在
			creatExcel("user.xls");//创建文件
		}
	    Workbook workbook = null;  
        WritableWorkbook wtbook = null;  
        WritableSheet wtsheet = null;  
        WritableCell wtcell = null; 
        int flagx = 0; 
        int flagy = 0;
        try {
            workbook = Workbook.getWorkbook(file);  
            wtbook = Workbook.createWorkbook(file, workbook);  
            wtsheet = wtbook.getSheet(0);//获取第一张表格  
            for(int i = 0; i < wtsheet.getColumns(); i++) {//查找列
            	wtcell = wtsheet.getWritableCell(i, 0);
            	if(wtcell.getType() == CellType.LABEL) {
            		String cell = ((Label)wtcell).getContents();
		            if(cell.equals(keyword)) {//定位到关键词的那一行
		            	flagx = i;
		            	break;
		            }
            	}     
            }
            if(keyword.equals("userName")) {//如果写入用户名
            	flagy = wtsheet.getRows();
            }else {//写入其他
            	for(int i = 0; i < wtsheet.getRows(); i++) {//查找行
            		wtcell = wtsheet.getWritableCell(1, i);
	        		String cell = ((Label)wtcell).getContents();
	        		if(cell.equals(userName)) {
	        			flagy = i;
	        			break;
	        		}
	            }
            }
	        Label label = new Label(flagx, flagy, data);
	        wtsheet.addCell(label);
	        wtsheet.addCell(new Label(0, flagy, String.valueOf((wtsheet.getRows() - 1))));
	        
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                wtbook.write();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
            try {  
                wtbook.close();  
            } catch (WriteException | IOException e) {  
                e.printStackTrace();  
            }  
            workbook.close();  
        }  
	}
	
	//返回对应用户的对应信息
	public String backData(String path, String userName, String keyword) {
		File file = new File(path);
		if(!file.exists()) {//如果文件不存在
			creatExcel("user.xls");//创建文件
		}
		Workbook workbook = null;
		Sheet sheet = null;
		Cell cell = null;
		int flagx = 0; 
		int flagy = 0;
		try {
			workbook = Workbook.getWorkbook(file);
			sheet = workbook.getSheet(0);
			for(int i = 0; i < sheet.getColumns(); i++) {//找到用户名所在行
				cell = sheet.getCell(i, 0);
				String s = cell.getContents();
				
				if(s.equals(keyword)) {
					flagx = i;
					break;
				}
			}
			for(int i = 0; i < sheet.getRows(); i++) {
				cell = sheet.getCell(1, i);
				String s = cell.getContents();
				if(s.equals(userName)) {
					flagy = i;
					break;
				}
			}
			workbook.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			cell = Workbook.getWorkbook(file).getSheet(0).getCell(flagx, flagy);
		}catch(Exception e) {
			e.printStackTrace();
		}
		String s = cell.getContents();
		return s;
	}
}
