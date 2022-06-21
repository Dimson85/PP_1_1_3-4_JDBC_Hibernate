package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    private static final String url = "jdbc:mysql://localhost:3306/kata";
    private static final String userName = "bestuser";
    private static final String password = "bestuser";
    private static Connection connect = null;
    private static SessionFactory sessionFactory = null;


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

    public static SessionFactory getMySessionFactory() {

        Properties properties = new Properties();
        properties.setProperty("hibernate.connection.url", url);
        properties.setProperty("hibernate.connection.username", userName);
        properties.setProperty("hibernate.connection.password", password);

        if (sessionFactory == null) {
            return new Configuration()
                    .addProperties(properties)
                    .addAnnotatedClass(User.class)
                    .buildSessionFactory();
        }
        return sessionFactory;
    }

    public static void closeMySessionFactory() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}