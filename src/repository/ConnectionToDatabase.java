package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionToDatabase {
    private static final String URL = System.getenv("POSTGRES_URL");
    private static final String PASSWORD = System.getenv("POSTGRES_PASSWORD");
    private static final String USERNAME = System.getenv("POSTGRES_USERNAME");

    private static Connection connection = null;
    private static Connection getConnection(){
        if(connection == null){
            try {
                connection = DriverManager.getConnection(
                        URL,
                        PASSWORD,
                        USERNAME
                );
            }catch (SQLException error){
                throw new RuntimeException("Connection failed");
            }
        }
        return connection;
    }
}