package dbManipulation;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.jdbc.DatabaseMetaData;

public class testsqlinfo {
	
	public static void main(String args[]){
		
		String url = "jdbc:mysql://localhost:3306/samp_db";
		String driver = "com.mysql.jdbc.Driver";
		String user = "root";
		String password = "zhouzheng";
		String str;
		
		try{
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,user, password);
			java.sql.DatabaseMetaData dmd = con.getMetaData();
			
			str=dmd.getSystemFunctions();
			System.out.println("系统支持的数学函数： "+  str);
			
			boolean f = dmd.supportsCoreSQLGrammar();
			
			if (f){
				System.out.println("支持OBDC核心SQL语法");
			}
			else{
				System.out.println("不支持ODBC核心SQL语法");
			}
			if(dmd.supportsANSI92EntryLevelSQL()){
				System.out.println("支持ANSI92初级SQL语法");
			}
			else{
				System.out.println("不支持ANSI92初级SQL语法");
			}
			if(dmd.supportsANSI92FullSQL()){
				System.out.println("支持ANSI92全集SQL语法");
			}
			else{
				System.out.println("不支持ANSI92全集SQL语法");
			}
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
