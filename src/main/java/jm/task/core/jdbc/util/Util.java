package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String url = "jdbc:mysql://localhost:3306/kata";
    private static final String userName = "bestuser";
    private static final String password = "bestuser";
    private static Connection connect = null;


    public static Connection getMySQLConnection() {

        try {
            connect = DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connect;
    }

    public static void closeMySQLConnection() {
        if (connect != null) {
            try {
                connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
