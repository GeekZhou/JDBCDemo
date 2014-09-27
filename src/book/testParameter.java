package book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class testParameter {

	public static void main(String args[]) {
		java.sql.ResultSet rs;
		String url = "jdbc:mysql://localhost:3306/samp_db";
		String driver = "com.mysql.jdbc.Driver";
		String user = "root";
		String password = "zhouzheng";
		String name, sex, age, tel;

		try {
			// 加载驱动程序
			Class.forName(driver);
			// 建立连接
			Connection con = DriverManager.getConnection(url, user, password);
			// create preparedStatement object
			String sqlStr = "SELECT * FROM students WHERE age>?";
			PreparedStatement ps = con.prepareStatement(sqlStr);
			// 设置输入参数，查询年龄大于15
			ps.setInt(1, 15);
			// execute search
			rs = ps.executeQuery();
			// out put the result
			System.out.println("输出结果是: ");
			while (rs.next()) {
				name = rs.getString("name");
				sex  = rs.getString("sex");
				age  = rs.getString("age");
				tel  = rs.getString("tel");
				System.out.println(name + " "+sex + " " + age + " "+ tel);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
