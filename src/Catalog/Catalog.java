package Catalog;

import java.util.*;

public class Catalog {
    private Map<Student, Map<Subject, ArrayList <Nota>> > grades;

    public Catalog() {
        grades = new HashMap<>();
    }

    public void showGrades (Student iStudent) {

        ArrayList<Nota> listOfGrades;
        for (Map.Entry mapElement : grades.get(iStudent).entrySet()) {
            Subject key = (Subject) mapElement.getKey();
            System.out.println("Subject " + key);
            listOfGrades = grades.get(iStudent).get(key);

            for (Nota grade : listOfGrades) {
                System.out.print(grade + " ");
            }
            System.out.println();
        }
    }
    public void addNote (Student iStudent, Subject iSubject, Nota iGrade) {

        if (!grades.containsKey(iStudent)) {

            ArrayList<Nota> arrayOfGrades = new ArrayList<>();
            arrayOfGrades.add(iGrade);
            Map<Subject, ArrayList<Nota>> mapWithGrades = new HashMap<>();
            mapWithGrades.put(iSubject, arrayOfGrades);
            grades.put(iStudent, mapWithGrades);
        } else if (!grades.get(iStudent).containsKey(iSubject)) {

            ArrayList<Nota> arrayOfGrades = new ArrayList<>();
            arrayOfGrades.add(iGrade);
            grades.get(iStudent).put(iSubject, arrayOfGrades);
        }
        else {

            ArrayList<Nota> arrayOfGrades = grades.get(iStudent).get(iSubject);
            arrayOfGrades.add(iGrade);
        }

    }
    //Todo to implement an action in menu
    public Double calcAverage (Student iStudent, Subject iSubject) {
        try{
           ArrayList<Nota> listOfNotes = grades.get(iStudent).get(iSubject);
           Integer sum  = 0;
           for (Nota grade : listOfNotes) {
               sum += grade.getNota();
           }
           return sum/(double)listOfNotes.size();
        }
        catch (Exception e ) {
            return  null;
        }
    }

    public void showAllGrades (Student iStudent) {

        Iterator<Map.Entry<Subject, ArrayList<Nota>>> notesIt = grades.get(iStudent).entrySet().iterator();
        System.out.println(iStudent.getmLastName() + " " + iStudent.getmFistName());
        while (notesIt.hasNext() ) {

            Map.Entry<Subject, ArrayList<Nota>> entry = notesIt.next();
            System.out.println(entry.getKey() + ": ");
            for (Nota grade : entry.getValue())
            System.out.println(grade);

        }
    }
}
