package book;
/**
 * 
 * 查询列明与变量形式
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.ResultSetMetaData;

public class testPrepareStatement {
	
	public static void main(String args[]){
		String url = "jdbc:mysql://localhost:3306/samp_db";
		String driver = "com.mysql.jdbc.Driver";
		String user = "root";
		String password = "zhouzheng";
		
		try{
			//load the driver
			Class.forName(driver);
			// build the connection
			Connection con = DriverManager.getConnection(url,user, password);
			// create preparedStatement object
			String sqlStr= "SELECT * FROM students WHERE age>?";
			
			PreparedStatement ps = con.prepareStatement(sqlStr);
			ps.setInt(1, 40);
			
			ResultSet rs = ps.executeQuery();
			
			//get the column names and type
			java.sql.ResultSetMetaData rsmd = rs.getMetaData();
			int cc = rsmd.getColumnCount();
			System.out.println("ColumnName ColumnType");
			for(int i=1; i<=cc; i++){
				System.out.println(rsmd.getColumnName(i)+ " "+rsmd.getColumnTypeName(i));
			}
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

}
