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
		UsersDataSet u = null;
		try {
			u = d.getUserByLogin(username);
			return (u.getPassword().equals(password));
		}
		catch (DBException ignore) {
			
		}
		return false;
	}
}