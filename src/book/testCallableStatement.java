package book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import com.mysql.jdbc.CallableStatement;

public class testCallableStatement {

	public static void main(String args[]){
		
		
		String url = "jdbc:mysql://localhost:3306/samp_db";
		String driver = "com.mysql.jdbc.Driver";
		String user = "root";
		String password = "zhouzheng";
		
		try{
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,user, password);
			
			//create a callable statement object
			java.sql.CallableStatement cs = con.prepareCall("{call testquery()}");
			
			ResultSet rs = cs.executeQuery();
			//get the col name and column types
			ResultSetMetaData rsmd = rs.getMetaData();
			
			int cc = rsmd.getColumnCount();
			
			System.out.println("列名 列类型");
			
			for(int i=1; i<=cc; i++){
				System.out.println(rsmd.getCatalogName(i) +" "+rsmd.getColumnTypeName(i));
			}
			con.close();
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
