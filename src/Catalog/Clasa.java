package Catalog;

import java.util.*;
import java.lang.Object;

public class Clasa {
    private String name;
    private Integer id;
    public Set<Student> students;
    public ArrayList<Subject> subjects; // all subjects that are taught in a class
    private CatalogService catalog = new CatalogService(); // stores all notes for every student

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Clasa(Integer iId, String iName) {
        students = new TreeSet<>();
        subjects = new ArrayList<>();
        name = iName;
        id = iId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public CatalogService getCatalog() {
        return catalog;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void addStudent(Student iStudent) {
        students.add(iStudent);
    }

    public void addSubjects(Subject iSubj) {
        subjects.add(iSubj);
    }

    public void setSubjects(ArrayList<Subject> iSubjects) {
        subjects = iSubjects;
    }

    public void addSubjects(Professor iProfessor, AllSubjects iSubj) {

        Boolean existSubj = false;
        for (Subject item : subjects) {
            if (item.getSubject() == iSubj) {
                existSubj = true;
                break;
            }
        }
        if (!existSubj) {
            Subject sub = new Subject(iProfessor, iSubj);
            subjects.add(sub);
        }

    }

    public Student getStudent(String iLastName, String iFirstName) {
        for (Student student : students)
            if (student.getmFistName().equals(iFirstName) && student.getmLastName().equals(iLastName))
                return student;
        return null;
    }

    public void addGrade(Student iStudent, AllSubjects iSubject, Nota iNota) {
        Subject subject = null;
        for (Subject item : subjects) {
            if (item.getSubject() == iSubject)
                subject = item;
        }
        if (subject == null)
            System.out.println("This subject not exist");
        else
            catalog.addNote(iStudent, subject, iNota);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clasa clasa = (Clasa) o;
        return Objects.equals(name, clasa.name) && Objects.equals(id, clasa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    public void showGrades(Student iStudent) {
        catalog.showGrades(iStudent);
    }

    public void showStudents() {
        for (Student student : students)
            System.out.println(student);
    }

    public void showSubjects () {
        for (Subject subject : subjects) {
            System.out.println(subject);
        }
    }

    @Override
    public String toString() {
        return "Clasa " + id + " " + name;
    }

    public  void calcAverage (Student iStudent, Subject iSubject) {
        catalog.calcAverage(iStudent, iSubject);
    }

}
