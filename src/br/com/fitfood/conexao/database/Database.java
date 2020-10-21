
package br.com.fitfood.conexao.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String DATABASE = "fitfood";
    private static final String HOST = String.format("jdbc:mysql://localhost:3306/%s?useTimezone=true&serverTimezone=UTC", DATABASE);
    private static final String USERNAME = "root";
    private static final String PASSWORD = null;
    
    private static Connection CONNECTION;
    
    public static Connection getConnection() {
        if (CONNECTION == null) {
            return connect();
        }
        
        return CONNECTION;
    }
    
    public static Connection connect() {
        try {
            CONNECTION = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
            
            Migrations.run(CONNECTION);
            
            return CONNECTION;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public static void disconnect(Connection con) {
        try {
            con.close();
        } catch (SQLException ex){
        }
    }
}

        
    
    

