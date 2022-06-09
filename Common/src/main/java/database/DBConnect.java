package database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class DBConnect {
    private String url;
    private String user;
    private String password;

    public Connection connect() {
        try {

            Properties properties = new Properties();
            FileReader fileReader = new FileReader("db.properties");
            properties.load(fileReader);
            url = properties.getProperty("db.localurl");
            user = properties.getProperty("db.username");
            password = properties.getProperty("db.password");

            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            return con;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
