package services;
import java.sql.SQLException;

import dbService.DBService;
import services.UserCreationService;
import dbService.dao.*;
public class UserLoginService{
	public static Boolean TryLogin(String username, String password){
		User user = new User(username, password);
		UsersDAO d = new UsersDAO(DBService.getH2Connection());
		try {
			String pass = d.getUserPassword(username);
			return (pass.equals(password));
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}