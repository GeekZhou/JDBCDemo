package dbManipulation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class testDatabase {
	
	public static void main(String args[]){
		String url = "jdbc:mysql://localhost:3306/samp_db";
		String driver = "com.mysql.jdbc.Driver";
		String user = "root";
		String password = "zhouzheng";
		String name, age, address, email, str;
		
		try{
			// load the driver
			Class.forName(driver);
			// build the connection
			Connection con = DriverManager.getConnection(url,user,password);
			// create statment object
			Statement st = con.createStatement();
			// create the table
			str="CREATE TABLE customer("
					+ "cName VARCHAR(10),"
					+ "cAge SMALLINT,"
					+ "cAddress VARCHAR(30))";
			st.executeUpdate(str);
			// add one column to the table
			str = "ALTER TABLE customer ADD COLUMN cEmail VARCHAR(30)";
			st.executeUpdate(str);
			// insert 3 entries
			str= "INSERT INTO customer(cName, cAge, cAddress, cEmail) "
					+ "values('Mike Joden', 45, 'New York Three Street', 'mjoden@135.net')";
			st.executeUpdate(str);
			
			str= "INSERT INTO customer(cName, cAge, cAddress, cEmail) "
					+ "values('H.J.Scolly', 27, 'Florlida NewBridge Down', 'HJScolly@florida.net')";
			st.executeUpdate(str);
			
			str= "INSERT INTO customer(cName, cAge, cAddress, cEmail)"
					+ "values('Cheng Jun', 28, 'ChengDuShiYangShiJie23#', 'junCheng@tyfo.mail.net')";
			st.executeUpdate(str);
			
			ResultSet rs = st.executeQuery("SELECT * FROM customer");
			// get the results and the the type
			while(rs.next()){
				name= rs.getString("cName");
				age = rs.getString("cAge");
				address = rs.getString("cAddress");
				email = rs.getString("cEmail");
				System.out.println(name +"\t"+age+"\t"+address+"\t"+email);
			}
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
