package br.com.fitfood.conexao.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Migrations {
    public static void run(Connection connection) {
        try {
            Statement statement = connection.createStatement();
            
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS customers(" +
                    "id int AUTO_INCREMENT PRIMARY KEY," +
                    "nome varchar(50)," +
                    "bairro varchar(50)," +
                    "cidade varchar(50)," +
                    "estado varchar(50)," +
                    "cep varchar(50)," +
                    "sexo varchar(15)," +
                    "cpf varchar(25)," +
                    "rg varchar(50)," +
                    "civil varchar(50)," +
                    "nasc varchar(50)," +
                    "cel varchar(50)," +
                    "email varchar(50))");
            
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS employees(" +
                    "id int AUTO_INCREMENT PRIMARY KEY," +
                    "nome varchar(50)," +
                    "bairro varchar(50)," +
                    "cidade varchar(50)," +
                    "estado varchar(50)," +
                    "cep varchar(50)," +
                    "sexo varchar(15)," +
                    "cpf varchar(25)," +
                    "rg varchar(50)," +
                    "civil varchar(50)," +
                    "nasc varchar(50)," +
                    "cel varchar(50)," +
                    "email varchar(50))");
        } catch (SQLException ex) {
            Logger.getLogger(Migrations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
