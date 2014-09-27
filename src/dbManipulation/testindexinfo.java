package dbManipulation;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class testindexinfo {

	public static void main(String args[]) {
		String url = "jdbc:mysql://localhost:3306/samp_db";
		String driver = "com.mysql.jdbc.Driver";
		String user = "root";
		String password = "zhouzheng";
		String tn, in, it, str;

		try {
			Class.forName(driver);
			// build connection
			Connection con = DriverManager.getConnection(url, user, password);
			
			// use metadata to get some relevant information
			DatabaseMetaData dmd = con.getMetaData();
			// get index information

			ResultSet rs = dmd.getIndexInfo(null, "dbo", "customer", true,
					true);
			//System.out.println(rs.getInt("TYPE"));
			
			if(!rs.equals(null))
				//System.out.println(rs.getString("TABLE_NAME"));
			// output the reuslt set
			while (rs.next()) {
				System.out.println("aaa");
				// get the table name
				tn = rs.getString("TABLE_NAME");
				// get the index
				in = rs.getString("INDEX_NAME");
				// get the type
				int i = rs.getInt("TYPE");
				System.out.println(i);
				it = "";
				switch (i) {
				case 0: {
					it = "无索引";
					break;
				}
				case 1: {
					it = "聚集索引";
					break;
				}
				case 2: {
					it = "哈希排序索引";
					break;
				}
				case 3: {
					it = "其他索引";
					break;
				}
				}

				str = "表名:  " + tn + "    索引名:   " + in + "  索引类型:  " + it;
				System.out.println(str);
			}
			con.close();
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
