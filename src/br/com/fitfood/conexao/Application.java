package br.com.fitfood.conexao;

import br.com.fitfood.conexao.database.Database;
import br.com.fitfood.conexao.views.CustomerView;

public class Application {
    public static void main(String args[]) {
        Database.connect();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerView().setVisible(true);
            }
        });
    }
}
