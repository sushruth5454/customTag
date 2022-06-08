package form;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
    private static Connection con;

    public static Connection getConnection() {
        if (con == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/sushdb";
                String username = "root";
                String password = "Tada@5454";
                con = DriverManager.getConnection(url, username, password);
                System.out.println("COnnection created...");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("connection returned");
        return con;
    }

}
