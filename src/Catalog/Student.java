package Catalog;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Student extends Person {
    private Clasa clasa;

    public Student(String iLastName, String iFirstName, Date iBirthDate, Clasa iClasa) {
        super(iFirstName, iLastName, iBirthDate);
        this.clasa = iClasa;
        clasa.addStudent(this);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
