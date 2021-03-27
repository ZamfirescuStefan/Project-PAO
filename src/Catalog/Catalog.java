package Catalog;

import java.sql.SQLOutput;
import java.util.*;

public class Catalog {
    private Map<Student, Map<Subject, ArrayList <Integer>> > grades = new HashMap<Student, Map<Subject, ArrayList<Integer>>>();

    public void showGrades (Student iStudent) {

        ArrayList<Integer> listOfGrades;
        for (Map.Entry mapElement : grades.get(iStudent).entrySet()) {
            Subject key = (Subject) mapElement.getKey();
            System.out.println("Subject " + key);
            listOfGrades = grades.get(iStudent).get(key);

            for (Integer grade : listOfGrades) {
                System.out.printf(grade + " ");
            }
            System.out.println();
        }
    }
    public void addNote (Student iStudent, Subject iSubject, Integer iGrade) {

        if (!grades.containsKey(iStudent)) {

            ArrayList<Integer> arrayOfGrades = new ArrayList<Integer>();
            arrayOfGrades.add(iGrade);
            Map<Subject, ArrayList<Integer>> mapWithGrades = new HashMap<Subject, ArrayList<Integer>>();
            mapWithGrades.put(iSubject, arrayOfGrades);
            grades.put(iStudent, mapWithGrades);
        } else if (!grades.get(iStudent).containsKey(iSubject)) {

            ArrayList<Integer> arrayOfGrades = new ArrayList<Integer>();
            arrayOfGrades.add(iGrade);
            grades.get(iStudent).put(iSubject, arrayOfGrades);
        }
        else {

            ArrayList<Integer> arrayOfGrades = grades.get(iStudent).get(iSubject);
            arrayOfGrades.add(iGrade);
        }

    }
    //Todo to implement an action in menu
    public Double calcAverage (Student iStudent, Subject iSubject) {
        try{
           ArrayList<Integer> listOfNotes = grades.get(iStudent).get(iSubject);
           Integer sum  = 0;
           for (Integer grade : listOfNotes) {
               sum += grade;
           }
           return sum/(double)listOfNotes.size();
        }
        catch (Exception e ) {
            return  null;
        }
    }

    public void showAllGrades (Student iStudent) {

        Iterator<Map.Entry<Subject, ArrayList<Integer>>> notesIt = grades.get(iStudent).entrySet().iterator();
        System.out.println(iStudent.getmLastName() + " " + iStudent.getmFistName());
        while (notesIt.hasNext() ) {

            Map.Entry<Subject, ArrayList<Integer>> entry = notesIt.next();
            System.out.println(entry.getKey() + ": ");
            for ( Integer grade : entry.getValue())
            System.out.println(grade);

        }
    }
}
