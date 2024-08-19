package com.mycompany.laba3.database;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DatabaseConfigurer {
    Connection connection = null;
    
    public Connection createConnection() throws SQLException, ClassNotFoundException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("reactors.sqlite");
        
        
        File tempFile;
        try {
            tempFile = File.createTempFile("reactors", ".sqlite");
            Files.copy(inputStream, tempFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            String dbUrl = "jdbc:sqlite:" + tempFile.getAbsolutePath();
            connection = DriverManager.getConnection(dbUrl);
            return connection;
        } catch (IOException ex) {
            Logger.getLogger(DatabaseConfigurer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    
    public Connection getConnection(){
        return connection;
    }
    
    public void closeConnection() throws SQLException {
        connection.close();
    }
    
}
