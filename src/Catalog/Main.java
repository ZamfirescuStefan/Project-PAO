package Catalog;

import java.text.ParseException;

public class Main {
    public static void main(String[] args) {

        Sistem sis = new Sistem();
        try {
            sis.menu();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
