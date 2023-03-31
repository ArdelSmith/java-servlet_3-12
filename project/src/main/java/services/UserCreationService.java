package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Data{
	public static Map<String, String> passwords = new HashMap<String, String>();
	public static Map<String, String> emails = new HashMap<String, String>();
	public static void AddUser(User user) {
		passwords.put(user.username, user.password);
		emails.put(user.email, user.username);
	}
}
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
		for (int i = 0; i < Data.passwords.size(); i++) {
			if (Data.emails.containsKey(username) || Data.emails.containsKey(email)) {
				return false;
			}
		}
		Data.AddUser(new User(username, password, email));
		return true;
	}
}