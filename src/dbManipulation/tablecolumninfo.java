package dbManipulation;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class tablecolumninfo {
	
	public static void main(String args[]){
		String url = "jdbc:mysql://localhost:3306/samp_db";
		String driver = "com.mysql.jdbc.Driver";
		String user = "root";
		String password = "zhouzheng";
		String tn, cn, ct, str;
		
		try{
			Class.forName(driver);
			// build the connection
			Connection con = DriverManager.getConnection(url,user, password);
			// use DataBaseMetaData to get relevant information
			DatabaseMetaData dmd = con.getMetaData();
			// get the result set, % matches string of any length
			ResultSet rs = dmd.getColumns("", "", "students", "%");
			// output the table information
			
			while(rs.next()){
				// get table name
				tn = rs.getString("TABLE_NAME");
				// get the column names
				cn = rs.getString("COLUMN_NAME");
				// get the column types
				ct = rs.getString("TYPE_NAME");
				str = "表名:  "+ tn + "  列名:   " + cn + "    列类型名:  " + ct;
				System.out.println(str);
			}
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		
	}

}
