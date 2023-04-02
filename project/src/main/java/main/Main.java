package main;


import java.sql.SQLException;

import dbService.DBException;
import dbService.DBService;
import dbService.dataSets.UsersDataSet;
import dbService.dao.*;


public class Main {
    public static void main(String[] args) {
        DBService dbService = new DBService();
        dbService.printConnectInfo();
        try {
            UsersDAO u = new UsersDAO(dbService.getH2Connection());
            u.createTable();
            u.insertUser("root", "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}