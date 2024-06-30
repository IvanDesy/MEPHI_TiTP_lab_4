package data_base;

import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConfigurer {
    Connection connection = null;
    
    public Connection createConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        URL resourceUrl = this.getClass().getClassLoader().getResource("reactors.sqlite");
        String dbPath = URLDecoder.decode(resourceUrl.getPath(), StandardCharsets.UTF_8);
        String dbUrl = "jdbc:sqlite:" + dbPath;
        connection = DriverManager.getConnection(dbUrl);
        return connection;
    }
    
    
    public void closeConnection() throws SQLException {
        connection.close();
    }
    
}
