package Catalog;

import java.util.Date;

public class Student extends Person {
    private Clasa clasa;

    public Student(String iLastName, String iFirstName, Data iBirthDate, Clasa iClasa) {
        super(iFirstName, iLastName, iBirthDate);
        this.clasa = iClasa;
        clasa.addStudent(this);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
