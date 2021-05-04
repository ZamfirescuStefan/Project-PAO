package Catalog;

public class main {
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
