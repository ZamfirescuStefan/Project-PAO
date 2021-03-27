package Catalog;

import java.security.KeyPair;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.function.BiFunction;

public class main {
    private static void change(Student a) {
        a = null;
    }
    public static void main(String[] args) {


        //Debug variables
        Clasa clasa11D = new Clasa(11, "D");

        Date debugBDay = new Date("27/12/2000");

        Student ZamfirescuStefan = new Student("Zamfirescu", "Stefan", debugBDay, clasa11D);
        Student ZamfirescuCristina = new Student("Zamfirescu", "Cristina", debugBDay, clasa11D);
        Student AndreiMinea = new Student("Minea", "Andrei", debugBDay, clasa11D);

        /*
        Professor Maris_Marian = new Professor("Marius", "Marian", debugBDay, 3500);
        Professor Andrei_Florin = new Professor("Andrei", "Florin", debugBDay, 3300);

        Manager manager = Manager.getInstance();
        manager.addClasa(clasa11D);
        manager.getClasa( 11, "D").addStudent(ZamfirescuStefan);
        manager.getClasa(11, "D").addStudent(ZamfirescuCristina);

        ArrayList<Subject> listofSubjects = new ArrayList<Subject>();
        Subject MMRomana = new Subject(Maris_Marian, AllSubjects.Romana);
        Subject AFMatematica = new Subject(Andrei_Florin, AllSubjects.Matematica);
        listofSubjects.add(MMRomana);
        listofSubjects.add(AFMatematica);
        clasa11D.setSubjects(listofSubjects);
        clasa11D.addGrade(ZamfirescuCristina, AllSubjects.Matematica, 10);
        clasa11D.addGrade(ZamfirescuStefan, AllSubjects.Matematica, 10);
        clasa11D.addGrade(ZamfirescuStefan, AllSubjects.Matematica, 9);

        manager.getClasa(11, "D").showGrades(ZamfirescuStefan);
*/
       /* Scanner scanner = new Scanner(System.in);
        MyScanner Myscanner = new MyScanner();

        String sir1 = Myscanner.nextString();

        int num = Myscanner.nextInt();
        String sir2 = Myscanner.nextString();

        System.out.println(sir1 + num + sir2);*/
        Sistem sis = new Sistem();
        sis.menu();

        // to modify
        // subject has a sinle name
        // an a list of professors and every one with subjects teach for that class

    }
}
