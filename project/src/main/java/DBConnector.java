
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.*;
import com.mysql.jdbc.Connection;

public class DBConnector {
	public static void SetConnection() throws SQLException{
		Driver d = new Driver();
		DriverManager.registerDriver(d);
		StringBuilder url = new StringBuilder();
		url.append("jdbc:mysql://")
		.append("localhost:")
		.append("3306/")
		.append("db_example?")
		.append("user-adelith")
		.append("password-root");
		Connection c = (Connection) DriverManager.getConnection(url.toString());
	}
	public static void CreateTable() {
		
	}
	
}