package Catalog;
import Catalog.Database.Config.DatabaseConfiguration;
import Catalog.Database.Config.SetupData;
import Catalog.Database.Repository.ClassRepository;
import Catalog.Database.Repository.StudentRepository;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        SetupData setupData = new SetupData();
//        setupData.setup();
//        Date bDate = new Date ("2000/12/27");
//        Clasa clasa = new Clasa(11, "C");
//        Student stefan = new Student("Zamfiresc", "Stefn", bDate, clasa);
//        StudentRepository rep  = new StudentRepository();
//        rep.save(stefan);
//        List<Student> students = rep.findAll();
//        for(Student student : students)
//            System.out.println(student);
//        List <Student> students = rep.getAllStudentsFromAClass(clasa);
//        for (Student student : students) {
//            System.out.println(student);
//        }

        Sistem sis = new Sistem();
        try {
            sis.menu();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
