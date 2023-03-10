package org.example;

import org.example.Database.Database;
import org.example.Views.Home;

public class Main {
    public static void main(String[] args) {

        Database db = Database.getInstance();

        try {
            db.init();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Home.init();

        try {
            db.close();
            System.out.println("APLICAÇÃO ENCERRADA!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}