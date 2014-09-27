package book;

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;



public class testDBdriver {

	
	public static void main(String argv[]){
		try{
			//加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");
			Enumeration e = DriverManager.getDrivers();
			//列举已加载的驱动程序
			for(;e.hasMoreElements();){
				System.out.println(e.nextElement());
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
