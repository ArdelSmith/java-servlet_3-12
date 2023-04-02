package dbService.dataSets;

@SuppressWarnings("UnusedDeclaration")
public class UsersDataSet {
    private long id;
    private String name;
    private String email;
    private String password;

    public UsersDataSet(long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }
    
    public String getEmail() {
    	return email;
    }
    
    public String getPassword() {
    	return password;
    }
    
    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "UsersDataSet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
