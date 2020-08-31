package project1.reesebenson.DB.ConnectionUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
    private static String url;
    private static String username;
    private static String password;

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return DriverManager.getConnection(url, username, password);
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        ConnectionUtils.password = password;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String Username) {
        ConnectionUtils.username = Username;
    }

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        ConnectionUtils.url = url;
    }
}