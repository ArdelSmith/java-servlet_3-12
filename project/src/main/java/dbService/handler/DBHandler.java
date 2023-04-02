package dbService.handler;

import dbService.DBService;

public class DBHandler {
    private static DBService instance = null;

    private DBHandler() {
    }

    public static DBService getInstance() {
        if (instance == null) {
            instance = new DBService();
        }
        return instance;
    }
}