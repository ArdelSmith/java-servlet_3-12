package dbService.dao;

import dbService.dataSets.UsersDataSet;
import dbService.executor.Executor;

import java.sql.Connection;
import java.sql.SQLException;

public class UsersDAO {

    private Executor executor;

    public UsersDAO(Connection connection) {
        this.executor = new Executor(connection);
    }

    public UsersDataSet get(long id) throws SQLException {
        return executor.execQuery("select * from users where id=" + id, result -> {
            result.next();
            return new UsersDataSet(result.getLong(1), result.getString(2), result.getString(3), result.getString(4));
        });
    }

    public long getUserId(String name) throws SQLException {
        return executor.execQuery("select * from users where user_name='" + name + "'", result -> {
            result.next();
            return result.getLong(1);
        });
    }
    public UsersDataSet getUserByLogin(String login) throws SQLException {
        return executor.execQuery("select * from users where user_name='" + login + "'", result -> {
            result.next();
            return new UsersDataSet(result.getLong(1), result.getString(2), result.getString(3), result.getString(4));
        });
    }
    public String getUserByEmail(String email) throws SQLException{
    	return executor.execQuery("select * from users where user_email='" + email + "'", result -> {
            result.next();
            return result.getString(2);
    	});
    }
    public String getUserEmail(String name) throws SQLException {
        return executor.execQuery("select * from users where user_name='" + name + "'", result -> {
            result.next();
            return result.getString(3);
        });
    }
    
    public String getUserPassword(String name) throws SQLException {
        return executor.execQuery("select * from users where user_name='" + name + "'", result -> {
            result.next();
            return result.getString(4);
        });
    }

    public void insertUser(String name, String email, String password) throws SQLException {
        executor.execUpdate("insert into users (user_name, user_email, user_pass) values ('" + name + ", " +
    email + ", " + password + "')");
    }

    public void createTable() throws SQLException {
        executor.execUpdate("create table if not exists users (id bigint auto_increment, user_name varchar(256)"
        		+ ", user_email varchar(256), user_pass varchar(256), primary key (id))");
    }

    public void dropTable() throws SQLException {
        executor.execUpdate("drop table users");
    }
}
