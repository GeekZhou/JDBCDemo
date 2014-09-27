import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


public class DBConfigure {
	
	private java.sql.Statement stmt = null;
	private ResultSet rs = null;
	private Connection conn = null;
	String sql;
	String strerl;
	/**
	 * 
	 */
	public DBConfigure(){
	}
	
	/**
	 * Connect to the database
	 */
	public void OpenConn(){
		try{
			//驱动的名称
			Class.forName("com.mysql.jdbc.Driver");
			String user = "root";
			String passwd = "zhouzheng";   
			String strDBname = "samp_db";  
			conn = (Connection) DriverManager.getConnection
					("jdbc:mysql://localhost/"+strDBname+"?user=" + user  + "&password=" + passwd + "");
			// 访问的数据库的帐号密码
			
		}
		catch (Exception e) {   
			System.out.println("OpenConnection:" + e.getMessage());  
			} 
	}
	public ResultSet executeQuery(String sql) {  
		stmt = null;  
		rs = null;  
		try {   
			stmt = conn.createStatement();  
			rs = stmt.executeQuery(sql);  } 
		catch (SQLException e) {
			System.err.println("executeQuery:" + e.getMessage()); 
			}   
		return rs;  
	}
	public void executeUpdate(String sql) {  
		stmt = null;  
		try {   
			stmt = conn.createStatement();  
			stmt.executeUpdate(sql);  } 
		catch (SQLException e) {   
			System.out.println("executeUpdate:" + e.getMessage());  
		}
		}

	public void closeStmt() {  
		try {   stmt.close();   } 
		catch (SQLException e) {  
			System.err.println("closeStmt:" + e.getMessage());  
			}  
		}
	
	public void closeConn() {  
		try {   conn.close();   } 
		catch (SQLException ex) {  
			System.err.println("aq.closeConn:" + ex.getMessage()); 
			}  
		} 
	
}
