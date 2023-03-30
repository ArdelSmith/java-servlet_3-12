package services;

import java.util.ArrayList;

class Data{
	public ArrayList<User> users = new ArrayList<>();
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
}
public  class UserCreationService{
	public static Data d = new Data();
	public static void CreateUser(String username, String password, String email) {
		for (int i = 0; i < d.users.size(); i++) {
			if (d.users.get(i).username == username || d.users.get(i).email == email) {
				return;
			}
		}
		d.users.add(new User(username, password, email));
	}
}