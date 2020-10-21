package br.com.fitfood.senai;

import br.com.fitfood.senai.database.Database;
import br.com.fitfood.senai.views.CustomerView;

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
