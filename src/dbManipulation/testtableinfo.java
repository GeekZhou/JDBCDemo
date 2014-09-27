package dbManipulation;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class testtableinfo {
	public static void main(String args[]){
		
		String url = "jdbc:mysql://localhost:3306/samp_db";
		String driver = "com.mysql.jdbc.Driver";
		String user = "root";
		String password = "zhouzheng";
		
		String tn, tt, str;
		String[] types = {"TABLE"};
		
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,user,password);
			// use metadata object to get the relevant information
			DatabaseMetaData dmd = con.getMetaData();
			// get the table information
			ResultSet rs = dmd.getTables("", "dbo", null, types);
			// output the information
			while(rs.next()){
				// get the table name
				tn = rs.getString("TABLE_NAME");
				// get the table type
				tt = rs.getString("TABLE_TYPE");
				str = "表名:  "+tn +"\t" +"表类型:  "+tt;
				System.out.println(str);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
