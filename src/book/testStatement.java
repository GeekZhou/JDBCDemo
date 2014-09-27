package book;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.*;
public class testStatement {
	
	
	public static void main(String args[]){
		String url = "jdbc:mysql://localhost:3306/samp_db";
		String driver = "com.mysql.jdbc.Driver";
		String user = "root";
		String password = "zhouzheng";
		try{
			//加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");
			//建立连接
			java.sql.Connection con = DriverManager.getConnection(url, user, password);
			//创建statement 对象
			java.sql.Statement st = con.createStatement();
			//设置选项
			st.setMaxRows(100);
			//执行查询
			ResultSet rs = st.executeQuery("SELECT * FROM students");
			//获取选项设置的情况
			System.out.println("Row length limit: " + st.getMaxFieldSize());
			System.out.println("ResultSet MaxRows: "+ st.getMaxRows());
			System.out.println("Query Time out:" + st.getMaxRows());
			
			//close the object
			st.close();	
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
		
	}

}
