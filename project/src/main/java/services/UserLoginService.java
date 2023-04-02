package services;
import java.sql.SQLException;

import dbService.DBException;
import dbService.DBService;
import services.UserCreationService;
import dbService.dao.*;
import dbService.dataSets.UsersDataSet;
import dbService.handler.DBHandler;
public class UserLoginService{
	public static Boolean TryLogin(String username, String password){
		DBService d = DBHandler.getInstance();
		try {
			UsersDataSet u = d.getUser(username);
			return (u.getPassword().equals(password));
		}
		catch (DBException e) {
			return false;
		}
	}
}