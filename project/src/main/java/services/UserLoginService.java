package services;
import java.sql.SQLException;

import dbService.DBException;
import dbService.DBService;
import services.UserCreationService;
import dbService.dao.*;
import dbService.dataSets.UsersDataSet;
public class UserLoginService{
	public static Boolean TryLogin(String username, String password){
		DBService d = new DBService();
		UsersDAO u = new UsersDAO(d.getMysqlConnection());
		try {
			UsersDataSet c = u.getUserByLogin(username);
			return (c.getPassword().equals(password));
		}
		catch (SQLException e) {
			return false;
		}
	}
}