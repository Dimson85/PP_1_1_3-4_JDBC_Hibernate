package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    public static Connection getMySQLConnection() throws SQLException,
            ClassNotFoundException {

        String url = "jdbc:mysql://localhost:3306/kata";
        String dbName = "kata";
        String userName = "bestuser";
        String password = "bestuser";

        return DriverManager.getConnection(url, userName, password);
    }
}
