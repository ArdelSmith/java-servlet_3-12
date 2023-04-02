package services;

import java.sql.SQLException;
import java.util.ArrayList;

import dbService.DBException;
import dbService.DBService;
import dbService.dao.*;
import dbService.dataSets.UsersDataSet;

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
		DBService dbService = new DBService();
        try {
            dbService.addUser(username, email, password);
            return true;
        } catch (DBException e) {
            e.printStackTrace();
        }
		return false;
	}
}