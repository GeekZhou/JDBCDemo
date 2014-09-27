package book;

import java.sql.DriverManager;

import com.mysql.jdbc.*;
import com.mysql.jdbc.DatabaseMetaData;

/**
 * 
 * 数据库连接
 * @author zhengzhou
 *
 */
public class testDBconnect {
	
	
	public static void main(String argv[]){
		
		String url="", user="root", pwd="zhouzheng";
		//System.out.println(argv[0]);
		/**if(argv.length == 0){
			System.out.println("Forget DataSource");
			System.out.println("use database");
			System.exit(0);
		}
		
		System.out.println(argv[2]);
		url= "jdbc:mysql://localhost/samp_db" +argv[0];
		
		if(argv.length >1){
			user = argv[1];
		}
		else{
			user = "";
		}
		if(argv.length>2){
			pwd = argv[2];
		}
		else{
			pwd = "";
		}*/
		try {
			//加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");
			//build the connection
			java.sql.Connection con =  DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/samp_db","root", "zhouzheng");
			//use DatabaseMetaData to get the data
			java.sql.DatabaseMetaData dd = con.getMetaData();
			//get the URL
			System.out.println("Data Source URL:"+ dd.getURL());
			//get the driver name
			System.out.println("Driver Name:"+dd.getDriverName());
			// the version of the driver
			System.out.println("Driver Version:" + dd.getDriverVersion());
			// get the DBMS name of connection
			System.out.println("Database ProductName: "+dd.getDatabaseProductName());
			// get the DBMS version
			System.out.println("Datahase ProductVersion:" + dd.getDatabaseProductVersion());
			con.close();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
	}
}
