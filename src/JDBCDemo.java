import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCDemo {
	public static Properties getProperties() {
		Properties props = new Properties();
		InputStream is = null;
		try {
			is = JDBCDemo.class.getResourceAsStream("./jdbc_mysql.properties"); // 按照参数路劲获得属性文件构造文件输入流
			props.load(is); // 从输入流中读取属性表
		} catch (Exception e1) {
			e1.printStackTrace();
			return null;
		}
		finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		}
		return props;
	}

	public static void main(String[] args) {
		Statement stmt = null;
		ResultSet rs = null;
		Connection con = null;
		String sql = "SELECT * FROM  students"; // SQL 查询语句
		String accountId;
		String accountName;
		String accountPassword;
		Properties props = getProperties();
		if (props != null) {
			String driver = props.getProperty("driver");
			System.out.println(driver);
			String url = props.getProperty("url");
			System.out.println(url);
			String username = props.getProperty("user");
			System.out.println(username);
			String password = props.getProperty("password");
			System.out.println(password);
			System.out.println("这是最后的斗争");
			try {
				Class.forName(driver); // 注册数据库驱动程序
				con = DriverManager.getConnection(url, username, password); // 建立到数据库库
																			// url
																			// 连接
				stmt = con.createStatement(); // 创建一个 Statement 对象来将 SQL
												// 语句发送到数据库
				rs = stmt.executeQuery(sql); // 执行数据库查询并将查询结果集数据表 rs
				//System.out.println("ID/t 姓名 /t 密码 /t");
				while (rs.next()) {
					accountId = rs.getString(1);
					accountName = rs.getString(2);
					accountPassword = rs.getString(3);
					System.out.println(accountId + "\t" + accountName + "\t"
					+ accountPassword);
				}
			} catch (Exception e3) {
				e3.printStackTrace();
			}
			finally { // 释放连接
				try {
					if (rs != null)
						rs.close();
					if (stmt != null)
						stmt.close();
					if (con != null)
						con.close();
				} catch (Exception e4) {
					e4.printStackTrace();
				}
			}
		}
	}
}