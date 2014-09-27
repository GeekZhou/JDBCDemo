package book;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class connectChoice {
	
	public static void main(String args[]){
		
		
		String url = "jdbc:mysql://localhost:3306/samp_db";
		
		try{
			//加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");
			//build the connection
			java.sql.Connection con = DriverManager.getConnection(url, "root", "zhouzheng");
			//将连接设置为只读
			con.setReadOnly(true);
			System.out.println("Database is read only?: " + con.isReadOnly());
			System.out.println("Database is AutoCommit?:" + con.getAutoCommit());
			con.close();
		}catch(Exception e){
			
			System.out.println(e.getMessage());
			
		}
		
		
	}

}
