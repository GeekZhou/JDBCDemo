import java.sql.*;

public class Test {
	public static void main(String args[]) {
		try {
			DBConfigure db = new DBConfigure();
			ResultSet rs = null;
			db.OpenConn();
			String sql = "select * from students";
			rs = db.executeQuery(sql);
			//输出utf-8
			while (rs.next()) {
				System.out.println(rs.getString(1));
				String accountName = rs.getString(2);
				String accountPassword = rs.getString(4);
				System.out.println("\t" + accountName + "\t"
				+ accountPassword);
			}
			db.closeStmt();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}