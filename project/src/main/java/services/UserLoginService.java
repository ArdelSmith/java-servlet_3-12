package services;
import services.UserCreationService;
public class UserLoginService{
	public static Boolean TryLogin(String username, String password){
		User user = new User(username, password);
		if (Data.emails.containsValue(user.username)) {
			String pass = Data.passwords.get(user.username);
			if (pass.equals(user.password)) return true;
			else return false;
		}
		else return false;
	}
}