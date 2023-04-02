package dbService.handler;

import dbService.DBService;

public class DBHandler {
    private static DBService instance = null;

    private DBHandler() {
        // private constructor
    }

    public static DBService getInstance() {
        if (instance == null) {
            instance = new DBService();
        }
        return instance;
    }

    // other methods and properties
}