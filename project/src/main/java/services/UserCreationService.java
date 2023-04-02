package services;

import java.sql.SQLException;
import java.util.ArrayList;

import dbService.DBService;
import dbService.dao.*;
import java.util.HashMap;
import java.util.Map;

class User {
	public String username;
	public String password;
	public String email;
	public User(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
	}
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
}
public class UserCreationService{
	public static Boolean CreateUser(String username, String password, String email) {
		if (username == null || password == null || email == null)
		{
			return false;
		}
		UsersDAO d = new UsersDAO(DBService.getH2Connection());
		try {
			d.getUserId(username);
			d.getUserByEmail(email);
			return false;
		}
		catch (SQLException e) {
			try {
				d.insertUser(username, email, password);
				return true;
			}
			catch (SQLException ignore) {
			}
		}
		return false;
	}
}